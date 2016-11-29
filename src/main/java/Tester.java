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

    Select dropagent;
    Select dropcountry;
    Select dropgender ;

    Tester(WebDriver w){
        wd=w;
        usename = wd.findElement(By.xpath(".//.[Contains(@name,\"login\")]"));
        fname=wd.findElement(By.xpath(".//.[Contains(@name,\"fname\")]"));
        sname=wd.findElement(By.xpath(".//.[Contains(@name,\"lname\")]"));
        password=wd.findElement(By.xpath(".//*[Contains(@name,\"us_password\")]"));
        confpass=wd.findElement(By.xpath(".//*[Contains(@name,\"confirm_password\")]"));
        email = wd.findElement(By.xpath(".//*[Contains (@name,\"email\")]"));
        city=wd.findElement(By.xpath(".//.[Contains(@name,\"city\")]"));
        adress =wd.findElement(By.xpath(".//.[Contains(@name,\"address\")]"));
        dropagent = new Select(wd.findElement(By.xpath(".//.[Contains(@name,\"owner_id\")]")));
        dropcountry = new Select(wd.findElement(By.xpath(".//.[Contains(@name,\"country\")]")));
        dropgender = new Select(wd.findElement(By.xpath(".//.[Contains(@name,\"gender\")]")));
        phone=wd.findElement(By.xpath(".//.[Contains(@name,\"phone\")]"));
    }
    public void Writer(){
         p = new Player(dropagent.getOptions().size(),dropcountry.getOptions().size());
         if(!alrdyregistered){
             email.sendKeys(p.getEmail());
             password.sendKeys(p.getPass());
             confpass.sendKeys(p.getPass());
             alrdyregistered=true;
         }
        usename.sendKeys(p.getUsename());
        fname.sendKeys(p.getFname());
        sname.sendKeys(p.getLname());
        city.sendKeys(p.getCity());
        adress.sendKeys(p.getAdress());
        phone.sendKeys(String.valueOf(p.getPhone()));
        dropagent.selectByIndex(p.getAgent());
        dropcountry.selectByIndex(p.getCountry());
        dropgender.selectByIndex(p.getGender());
        wd.findElement(By.xpath("Save"));
        equals(wd.getTitle(),"Players");
    }
    public void equals(String actual,String expec){
        if (expec.equals(actual)) System.out.println("PASS");
        else{
            System.out.println("FAILED: Expected result is "+expec+" when actual is "+actual);
        }
    }
    public void Checker(){
        equals(email.getAttribute("value"),p.getEmail());
        equals(usename.getAttribute("value"),p.getUsename());
        equals(fname.getAttribute("value"),p.getFname());
        equals(sname.getAttribute("value"),p.getLname());
        equals(city.getAttribute("value"),p.getCity());
        equals(adress.getAttribute("value"),p.getAdress());
        equals(phone.getAttribute("value"),String.valueOf(p.getPhone()));
        equals(String.valueOf(dropagent.getOptions().indexOf(dropagent.getFirstSelectedOption().getAttribute("value"))),String.valueOf(p.getAgent()));
        equals(String.valueOf(dropcountry.getOptions().indexOf(dropcountry.getFirstSelectedOption().getAttribute("value"))),String.valueOf(p.getCountry()));
        equals(String.valueOf(dropgender.getOptions().indexOf(dropgender.getFirstSelectedOption().getAttribute("value"))),String.valueOf(p.getGender()));
    }
    public void OpenChanger(){
        wd.findElement(By.xpath(".//*[@id=\"filter_panel_filter__login\"]/input")).sendKeys(p.getUsename());
        wd.findElement(By.xpath(".//*[@name=\"search\"]")).click();
        wd.findElement(By.xpath(".//tr[.//a[text()=\""+p.getUsename()+"\"]]")).click();
    }
}
