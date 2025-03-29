package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPnlLoginPage {
    private WebDriver driver;

    private By userNameTxtBx = By.id("username");
    private By passwordTxtBx = By.id("login");
    private By loginBtn = By.className("form-button");


    public AdminPnlLoginPage(WebDriver userDriver){
        this.driver = userDriver;
    }


    /**
     * @param userCredentials is the credentials for the user to login such that:
     *                        userCredentials[0] is the username,
     *                        userCredentials[1] is the password
     */
    public void enterCredentials(String[] userCredentials){
        driver.findElement(userNameTxtBx).sendKeys(userCredentials[0]);
        driver.findElement(passwordTxtBx).sendKeys(userCredentials[1]);
    }


    public AdminPanelPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return new AdminPanelPage(driver);
    }






}
