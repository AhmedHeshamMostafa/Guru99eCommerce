package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyDashboardPage {
    private WebDriver driver;

    private By title = By.tagName("h1");
    private By successMsg = By.className("success-msg");
    private By TVMenu = By.linkText("TV");
    private By myWishlistLink = By.xpath("//*[contains(text(), \"My Wishlist\") and not(@title)]");
    private By myOrdersLink = By.xpath("//a[contains(text(), \"My Orders\")]");
    private By reOrderLink = By.className("link-reorder");

    public MyDashboardPage(WebDriver userDriver){
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


    public WishlistPage clickMyWishlistLink(){
        driver.findElement(myWishlistLink).click();
        return new WishlistPage(driver);
    }


    public MyOrdersPage clickMyOrdersLink(){
        driver.findElement(myOrdersLink).click();
        return new MyOrdersPage(driver);
    }


    public CartPage clickReOrderLink(){
        driver.findElement(reOrderLink).click();
        return new CartPage(driver);
    }


}
