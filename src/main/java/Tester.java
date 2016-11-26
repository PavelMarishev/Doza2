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
    WebElement usename;
    WebElement fname;
    WebElement sname;
    WebElement email;
    WebElement city;
    WebElement street;
    WebElement adress;

    Select dropagent;
    Select dropcountry;
    Select dropgender ;

    Tester(WebDriver w){
        usename = wd.findElement(By.xpath("username"));
        fname=wd.findElement(By.xpath("Fname"));
        sname=wd.findElement(By.xpath("Sname"));
        email = wd.findElement(By.xpath("email"));
        city=wd.findElement(By.xpath("City"));
        street=wd.findElement(By.xpath("Street"));
        adress =wd.findElement(By.xpath("adress"));
        dropagent = new Select(wd.findElement(By.xpath("Агент")));
        dropcountry = new Select(wd.findElement(By.xpath("Страна")));
        dropgender = new Select(wd.findElement(By.xpath("Gender")));
    }
    public void Writer(){
         p = new Player(dropagent.getOptions().size(),dropcountry.getOptions().size());
         if(!alrdyregistered)email.sendKeys(p.getEmail());
        usename.sendKeys(p.getUsename());
        fname.sendKeys(p.getFname());
        sname.sendKeys(p.getLname());
        city.sendKeys(p.getCity());
        street.sendKeys(p.getCity());
        adress.sendKeys(p.getAdress());
        dropagent.selectByIndex(p.getAgent());
        dropcountry.selectByIndex(p.getCountry());
        dropgender.selectByIndex(p.getGender());
        alrdyregistered=true;
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
        equals(email.getText(),p.getEmail());
        equals(usename.getText(),p.getUsename());
        equals(fname.getText(),p.getFname());
        equals(sname.getText(),p.getLname());
        equals(city.getText(),p.getCity());
        equals(street.getText(),String.valueOf(p.getStreet()));
        equals(adress.getText(),p.getAdress());
        equals(String.valueOf(dropagent.getOptions().indexOf(dropagent.getFirstSelectedOption().getText())),String.valueOf(p.getAgent()));
        equals(String.valueOf(dropcountry.getOptions().indexOf(dropcountry.getFirstSelectedOption().getText())),String.valueOf(p.getCountry()));
        equals(String.valueOf(dropgender.getOptions().indexOf(dropgender.getFirstSelectedOption().getText())),String.valueOf(p.getGender()));
    }
    public void OpenChanger(){
        wd.findElement(By.xpath("User finding field")).sendKeys(p.getUsename());
        wd.findElement(By.xpath("Find button")).click();
        wd.findElement(By.xpath("Change but")).click();
    }
}
