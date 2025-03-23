package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SONYXPERIADtlPage {
    private WebDriver driver;

    private By price = By.className("price");

    public SONYXPERIADtlPage(WebDriver userDriver){
        this.driver = userDriver;
    }

    public String getPrice(){
        return driver.findElement(price).getText();
    }


}
