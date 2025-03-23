package Base;

import Pages.HomePage;
import Utils.WindowManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    private WebDriver driver;
    protected HomePage home;
    protected WindowManager windowMgr;

    @BeforeClass
    public void testClassSetUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        home = testMethodSetUp();
        windowMgr = new WindowManager(driver);
    }

    @BeforeMethod
    public HomePage testMethodSetUp(){
        driver.get("http://live.techpanda.org/");
        return new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
