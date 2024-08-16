package Session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import javax.swing.*;
import java.time.Duration;

public class Assertions {
    private SoftAssert softAssert;
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void Setup()
    {
        driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test (groups = {"Regression","broken"})
    public void hardAssertValidLoginTestCase()
    {
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("admin");
        driver.findElement(By.id("loginButton")).click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
    }

    @Test(groups = {"Smoke"})
    public void softAssertValidLoginTestCase()
    {
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("admin");
        driver.findElement(By.id("loginButton")).click();

        softAssert = new SoftAssert();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
        softAssert.assertAll();
    }
    @Test(groups = {"Smoke","broken"})
    public void inValidLoginTestCase()
    {
        driver.findElement(By.id("inputUsername")).sendKeys("admin");
        driver.findElement(By.id("inputPassword")).sendKeys("ahmed");
        driver.findElement(By.id("loginButton")).click();
        driver.switchTo().alert().accept();
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");

    }

    @Test(groups = {"Regression"})
    public void inValidLoginTestCaseUsingInvalidUser()
    {
        driver.findElement(By.id("inputUsername")).sendKeys("amr");
        driver.findElement(By.id("inputPassword")).sendKeys("admin");
        driver.findElement(By.id("loginButton")).click();
        driver.switchTo().alert().accept();
        Assert.assertNotEquals(driver.getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");

    }

    @AfterMethod(alwaysRun = true)
    public void quit()
    {
        driver.quit();
    }





}
