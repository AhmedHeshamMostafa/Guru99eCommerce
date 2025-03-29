package Base;

import Pages.AdminPnlLoginPage;
import Pages.HomePage;
import Utils.WindowManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTests {
    private WebDriver driver;
    protected HomePage home;
    protected AdminPnlLoginPage adminLogin;
    protected WindowManager windowMgr;

    @BeforeClass
    public void testClassSetUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //home = testMethodSetUp1();
        //adminLogin = testMethodSetUp2();
        windowMgr = new WindowManager(driver);
    }

    @BeforeMethod
    public void testMethodSetUp(Method testMethod){
        if(testMethod.getName().equals("testExportOrdersandEmail")){
            driver.get("https://live.techpanda.org/index.php/backendlogin/");
            adminLogin = new AdminPnlLoginPage(driver);
        }
        else{
            driver.get("http://live.techpanda.org/");
            home = new HomePage(driver);
        }
    }

//    public AdminPnlLoginPage testMethodSetUp2(){
//
//
//    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}
