package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;

    private By pageTitle = By.tagName("h1");
    private String title;
    private By printOrderLink = By.className("link-print");



    public OrderPage(WebDriver userDriver){
        this.driver = userDriver;
        title = driver.findElement(pageTitle).getText();
    }

    public String getOrderNum(){
        String orderNumStr = title.replaceAll("\\D+", "");
        return orderNumStr;
    }

    public String getOrderStatus(){

        String[] titleParts = title.split("\\-");
        String orderstatus = titleParts[1].trim();
        return orderstatus;
    }


    public PrintOrderPage clickPrintOrderandSwitch(){
        driver.findElement(printOrderLink).click();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.)
        var windowHandles = driver.getWindowHandles();
        for(String windowHandle : windowHandles){
            driver.switchTo().window(windowHandle);
        }

        return new PrintOrderPage(driver);
    }
}
