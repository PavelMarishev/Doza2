import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Scynet on 25.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        WebDriver wd =new FirefoxDriver();
        wd.get("http://80.92.229.236:81/auth/login");
        wd.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        WebElement usernameInput= wd.findElement(By.id("username"));
        usernameInput.sendKeys("admin");
        WebElement passInput= wd.findElement(By.id("password"));
        passInput.sendKeys("123");
        WebElement loginButton= wd.findElement(By.id("logIn"));
        loginButton.click();

        String actualtitle=wd.getTitle();
        final String expectedtitle="Players";
        if(actualtitle.equals(expectedtitle)) System.out.println("PASSED");
        else
            System.err.println("Failed. Expected title is "+expectedtitle+" and Actual is"+actualtitle);
          wd.findElement(By.xpath(".//*[@title=\"Insert\"]")).click();
       Tester tester =new Tester(wd);
           tester.Writer();
      tester.OpenChanger();
       tester.Checker();
       tester.Writer();
       tester.OpenChanger();
       tester.Checker();
       wd.quit();


    }

}
