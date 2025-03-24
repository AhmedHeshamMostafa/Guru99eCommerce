package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private WebDriver driver;

    private By createAccBtn = By.cssSelector("[title=\"Create an Account\"]");

    public MyAccountPage(WebDriver userDriver){
        this.driver = userDriver;
    }

    public CreateAccPage clickCreateAccBtn(){
        driver.findElement(createAccBtn).click();
        return new CreateAccPage(driver);
    }


}
