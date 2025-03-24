package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;

    By title = By.tagName("h1");
    By successMsg = By.className("success-msg");
    By TVMenu = By.linkText("TV");

    public DashboardPage(WebDriver userDriver){
        this.driver = userDriver;
    }

    public String getTitleTxt(){
        return driver.findElement(title).getText();
    }


    public String getSuccessMsg(){
        return driver.findElement(successMsg).getText();
    }

    public TVPage clickTVLink(){
        driver.findElement(TVMenu).click();
        return new TVPage(driver);
    }


}
