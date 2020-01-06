package Tests;

import java.io.File;
import Tests.AbstractBaseTests.TestBase;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;

/**
 * Test.
 */
public class BlazedemoTest extends TestBase {

    @BeforeTest
    public void launchBrowser() {

    }

    @Test(priority = 4)
    public void register() throws InterruptedException {

        driver.get("http://www.blazedemo.com/register");
        driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Demo");
        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("Demo Company");
        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("demo@example.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id='password-confirm']")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id='app']/div/div/div/div/div[2]/form/div[6]/div/button")).click();

    }


    @Test(priority = 3)
    public void login() throws InterruptedException {

        driver.get("http://www.blazedemo.com/login");

        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("demo@example.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//*[@id='app']/div/div/div/div/div[2]/form/div[4]/div/button")).click();

    }
    
    @Test(priority = 2)
    public void gotoTheBeach() throws InterruptedException {

        driver.get("http://www.blazedemo.com/");

        driver.findElement(By.xpath("/html/body/div[2]/div/p[2]/a")).click();
        Assert.assertEquals("BlazeDemo - vacation", driver.getTitle());
        
    }
    
    @Test(priority = 1)
    public void flightFromBostonToNewYork() throws InterruptedException {

        driver.get("http://www.blazedemo.com");

        driver.findElement(By.xpath("//select[@name='fromPort']/option[text()='Boston']")).click();
        driver.findElement(By.xpath("//select[@name='toPort']/option[text()='New York']")).click();
        driver.findElement(By.className("btn-primary")).click();
        driver.findElement(By.className("btn-small")).click();            
        driver.findElement(By.id("inputName")).sendKeys("Blaze Meter");
        driver.findElement(By.id("address")).sendKeys("3965 Freedom Cir");
        driver.findElement(By.id("city")).sendKeys("Santa Clara");
        driver.findElement(By.id("state")).sendKeys("CA");
        driver.findElement(By.id("zipCode")).sendKeys("95054");
        driver.findElement(By.xpath("//select[@name='cardType']/option[text()='American Express']")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys("00001111222233334444");
        driver.findElement(By.id("creditCardMonth")).clear();
        driver.findElement(By.id("creditCardMonth")).sendKeys("01");
        driver.findElement(By.id("creditCardYear")).clear();
        driver.findElement(By.id("creditCardYear")).sendKeys("2020");
        driver.findElement(By.id("nameOnCard")).sendKeys("Blaze Meter");
        driver.findElement(By.className("btn-primary")).click();

    }
    
    @AfterTest
    public void terminateBrowser(){
        driver.close();
    }
}
