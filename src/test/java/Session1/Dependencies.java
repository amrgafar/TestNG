package Session1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Dependencies {

    private SoftAssert softAssert;
    private WebDriver driver;

    @BeforeClass
    public void Setup()
    {
        driver= new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Test
   public void registerTC()
   {
        Assert.fail();
   }

   @Test (dependsOnMethods = "registerTC")
   public void loginTC()
   {
       System.out.println("Login TC");

   }



    @AfterClass
    public void quit()
    {
        driver.quit();
    }

}
