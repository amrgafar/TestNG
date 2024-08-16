package Session1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import Listeners.IInvocedMethod;

import java.time.Duration;

//@Listeners(IInvocedMethod.class)
public class ParameterClass {
    ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public Logger LOGGER = LogManager.getLogger();

    @Parameters (value = "browser")
    @BeforeMethod(alwaysRun = true)
    public void Setup(String browser)
    {
        switch (browser)
        {
            case "chrome": driverThreadLocal.set(new ChromeDriver());
            break;
            default: driverThreadLocal.set(new EdgeDriver());
        }
        driverThreadLocal.get().manage().window().maximize();
        driverThreadLocal.get().get("https://ashraaf7.github.io/AA-Practice-Test-Automation/index.html");
        driverThreadLocal.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }
    @Parameters(value = {"username","password"})
    @Test //(invocationCount = 3,threadPoolSize = 3)
    public void hardAssertValidLoginTestCase(@Optional("admin") String username, @Optional("admin") String password)
    {
        driverThreadLocal.get().findElement(By.id("inputUsername")).sendKeys(username);
        driverThreadLocal.get().findElement(By.id("inputPassword")).sendKeys(password);
        driverThreadLocal.get().findElement(By.id("loginButton")).click();

        Assert.assertEquals(driverThreadLocal.get().getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
    }

    @Parameters(value = {"username","password"})
    @Test
    public void hardAssertValidLoginTestCase2(@Optional("admin") String username, @Optional("admin") String password)
    {
        LOGGER.info("testcase started");
        driverThreadLocal.get().findElement(By.id("inputUsername")).sendKeys(username);
        LOGGER.info("username is written");
        driverThreadLocal.get().findElement(By.id("inputPassword")).sendKeys(password);
        LOGGER.info("passwordis written");
        driverThreadLocal.get().findElement(By.id("loginButton")).click();
        LOGGER.info("button is clicked");

        Assert.assertEquals(driverThreadLocal.get().getCurrentUrl(),"https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");
    }

    @AfterMethod(alwaysRun = true)
    public void quit()
    {
        driverThreadLocal.get().quit();
        driverThreadLocal.remove();
    }
}
