package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    By title = By.tagName("h2");
    By mobile = By.xpath("//a[contains(text(),'Mobile')]");

    public HomePage(WebDriver userDriver){
        this.driver = userDriver;
    }

    public String getTitleTxt(){
        return driver.findElement(title).getText();
    }

    public MobilePage clickMobileLink(){
        driver.findElement(mobile).click();
        return new MobilePage(driver);
    }


}
