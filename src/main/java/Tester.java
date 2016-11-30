import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Scynet on 26.11.2016.
 */
public class Tester {
    Boolean alrdyregistered=false;
    Player p;
    WebDriver wd;
    WebElement password;
    WebElement confpass;
    WebElement usename;
    WebElement fname;
    WebElement sname;
    WebElement email;
    WebElement city;
    WebElement adress;
    WebElement phone;

    String prevname;

    Select dropagent;
    Select dropcountry;
    Select dropgender ;

    Tester(WebDriver w){
        wd=w;
        usename = wd.findElement(By.xpath(".//*[contains(@name,'login')]"));
        fname=wd.findElement(By.xpath(".//*[contains(@name,'fname')]"));
        sname=wd.findElement(By.xpath(".//*[contains(@name,'lname')]"));
        password=wd.findElement(By.xpath(".//*[contains(@name,'us_password')]"));
        confpass=wd.findElement(By.xpath(".//*[contains(@name,'confirm_password')]"));
        email = wd.findElement(By.xpath(".//*[contains (@name,'email')]"));
        city=wd.findElement(By.xpath(".//*[contains(@name,'city')]"));
        adress =wd.findElement(By.xpath(".//*[contains(@name,'address')]"));
        dropagent = new Select(wd.findElement(By.xpath(".//*[contains(@name,'owner_id')]")));
        dropcountry = new Select(wd.findElement(By.xpath(".//*[contains(@name,'country')]")));
        dropgender = new Select(wd.findElement(By.xpath(".//*[contains(@name,'gender')]")));
        phone=wd.findElement(By.xpath(".//*[contains(@name,'phone')]"));
    }
    public void Init(){
        usename = wd.findElement(By.xpath(".//*[contains(@name,'login')]"));
        fname=wd.findElement(By.xpath(".//*[contains(@name,'fname')]"));
        sname=wd.findElement(By.xpath(".//*[contains(@name,'lname')]"));
        email = wd.findElement(By.xpath(".//*[contains (@name,'email')]"));
        city=wd.findElement(By.xpath(".//*[contains(@name,'city')]"));
        adress =wd.findElement(By.xpath(".//*[contains(@name,'address')]"));
        dropagent = new Select(wd.findElement(By.xpath(".//*[contains(@name,'owner_id')]")));
        dropcountry = new Select(wd.findElement(By.xpath(".//*[contains(@name,'country')]")));
        dropgender = new Select(wd.findElement(By.xpath(".//*[contains(@name,'gender')]")));
        phone=wd.findElement(By.xpath(".//*[contains(@name,'phone')]"));
    }
    public void Cleaner(){
        fname.clear();
        sname.clear();
        city.clear();
        phone.clear();
        email.clear();
        adress.clear();
        phone.clear();
    }
    public void Writer(){
        Cleaner();
         p = new Player(dropagent.getOptions().size(),dropcountry.getOptions().size(),alrdyregistered,prevname);
         if(!alrdyregistered){
             password.sendKeys(p.getPass());
             usename.sendKeys(p.getUsename());
             prevname=p.getUsename();
             confpass.sendKeys(p.getPass());
             alrdyregistered=true;
         }else Init();
        email.sendKeys(p.getEmail());
        fname.sendKeys(p.getFname());
        sname.sendKeys(p.getLname());
        city.sendKeys(p.getCity());
        adress.sendKeys(p.getAdress());
        phone.sendKeys(String.valueOf(p.getPhone()));
        dropagent.selectByIndex(p.getAgent()-1);
        dropcountry.selectByIndex(p.getCountry()-1);
        dropgender.selectByIndex(p.getGender()-1);
        wd.findElement(By.xpath(".//*[contains(@name,'button_save')]")).click();
       equals(wd.getTitle(),"Players");
    }
    public void equals(String actual,String expec){
        if (expec.equals(actual)) System.out.println("PASS");
        else{
            System.out.println("FAILED: Expected result is "+expec+" when actual is "+actual);
        }
    }
    public void Checker(){
        Init();
        equals(email.getAttribute("value"),p.getEmail());
        equals(usename.getAttribute("value"),p.getUsename());
        equals(fname.getAttribute("value"),p.getFname());
        equals(sname.getAttribute("value"),p.getLname());
        equals(city.getAttribute("value"),p.getCity());
        equals(adress.getAttribute("value"),p.getAdress());
        equals(phone.getAttribute("value"),String.valueOf(p.getPhone()));
    }
    public void OpenChanger(){
        wd.findElement(By.xpath(".//*[@id=\"filter_panel_filter__login\"]/input")).clear();
        wd.findElement(By.xpath(".//*[@id=\"filter_panel_filter__login\"]/input")).sendKeys(p.getUsename());
        wd.findElement(By.xpath(".//*[@name=\"search\"]")).click();
        wd.findElement(By.xpath(".//tr[.//a[text()='"+p.getUsename()+"']]/td[@width=16]")).click();
    }
}
