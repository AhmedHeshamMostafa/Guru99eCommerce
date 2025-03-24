package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccPage {
    private WebDriver driver;

    private By firstNameTxtBx = By.id("firstname");
    private By midNameTxtBx = By.id("middlename");
    private By lastNameTxtBx = By.id("lastname");
    private By emailTxtBx = By.id("email_address");
    private By passwordTxtBx = By.id("password");
    private By confirmPWTxtBx = By.id("confirmation");
    private By registerBtn = By.cssSelector("button[title=\"Register\"]");


    public CreateAccPage(WebDriver userDriver){
        this.driver = userDriver;
    }

    /**
     *
     * @param userInfo is an array of strings, where each string is an entry for the textboxes in the create an account page such that:
     *                 userInfo[0] : First name,
     *                 userInfo[1] : Middle name,
     *                 userInfo[2] : Last name,
     *                 userInfo[3] : Email address,
     *                 userInfo[4] : Password,
     *                 userInfo[5] : Confirm password
     *
     */
    public void fillUserInfo(String[] userInfo){
        driver.findElement(firstNameTxtBx).sendKeys(userInfo[0]);
        driver.findElement(midNameTxtBx).sendKeys(userInfo[1]);
        driver.findElement(lastNameTxtBx).sendKeys(userInfo[2]);
        driver.findElement(emailTxtBx).sendKeys(userInfo[3]);
        driver.findElement(passwordTxtBx).sendKeys(userInfo[4]);
        driver.findElement(confirmPWTxtBx).sendKeys(userInfo[5]);
    }


    public DashboardPage clickRegisterBtn(){
        driver.findElement(registerBtn).click();
        return new DashboardPage(driver);
    }





}
