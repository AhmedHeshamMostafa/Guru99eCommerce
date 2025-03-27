package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
    private WebDriver driver;

    private By createAccBtn = By.cssSelector("[title=\"Create an Account\"]");
    private By emailTxtBx = By.id("email");
    private By passwordTxtBx = By.id("pass");
    private By loginBtn = By.id("send2");

    public MyAccountPage(WebDriver userDriver){
        this.driver = userDriver;
    }

    public CreateAccPage clickCreateAccBtn(){
        driver.findElement(createAccBtn).click();
        return new CreateAccPage(driver);
    }


    /**
     *
     * @param registeredAcc is the email and password for an already registered account such that :
     *                     registeredAcc[0] : email address,
     *                     registeredAcc[1] : password
     */
    public void enterRegisteredAcc(String[] registeredAcc){
        driver.findElement(emailTxtBx).sendKeys(registeredAcc[0]);
        driver.findElement((passwordTxtBx)).sendKeys(registeredAcc[1]);
    }

public MyDashboardPage clickLoginBtn(){
        driver.findElement(loginBtn).click();
        return new MyDashboardPage(driver);
}


}
