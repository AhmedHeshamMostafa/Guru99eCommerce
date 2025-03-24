package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage {
    private WebDriver driver;

    private By shareWishlistBtn = By.name("save_and_share");
    private By wishListSharedTxt = By.className("success-msg");

    public WishlistPage(WebDriver userDriver){
        this.driver = userDriver;
    }


    public ShareWishListPage clickShareWishlistBtn(){
        driver.findElement(shareWishlistBtn).click();
        return new ShareWishListPage(driver);
    }

    public String getWishListSharedTxt(){
        return driver.findElement(wishListSharedTxt).getText();
    }


}
