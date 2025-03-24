package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShareWishListPage {
    private WebDriver driver;

    private By emailsTxtBx = By.id("email_address");
    private By messageTxtBx = By.id("message");
    private By shareWishListBtn = By.cssSelector("[title=\"Share Wishlist\"]");

    public ShareWishListPage(WebDriver userDriver){
        this.driver = userDriver;
    }

    public void fillEmailsTxtBx(String emails){
        driver.findElement(emailsTxtBx).sendKeys(emails);
    }

    public void fillMessageTxtBx(String message){
        driver.findElement(messageTxtBx).sendKeys(message);
    }

    public WishlistPage clickShareWishlistBtn(){
        driver.findElement(shareWishListBtn).click();
        return new WishlistPage(driver);
    }

}
