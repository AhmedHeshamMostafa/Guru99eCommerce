package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private WebDriver driver;

    private By quantityTxtBox = By.cssSelector("[title=\"Qty\"]");
    private By updateBtn = By.cssSelector("[title=\"Update\"]");
    private By quantityError = By.cssSelector(".item-msg.error");
    private By emptyCartLink = By.id("empty_cart_button");
    private By pageTitle = By.className("page-title");
    private By proceedtoCheckoutBtn = By.cssSelector("[title=\"Proceed to Checkout\"]");
    private By oneProductPrice = By.cssSelector(".product-cart-price .cart-price");
    private By grandTotal = By.cssSelector("strong .price");
    private By couponTxtBx = By.id("coupon_code");
    private By applyCouponLink = By.cssSelector("[title=\"Apply\"]");



    public CartPage(WebDriver userDriver){
        this.driver = userDriver;
    }

    public void addQuantityandUpdate(int quantity){
        driver.findElement(quantityTxtBox).clear();
        driver.findElement(quantityTxtBox).sendKeys(String.valueOf(quantity));
        driver.findElement(updateBtn).click();
    }

    public String getQuantityError(){
        return driver.findElement(quantityError).getText();
    }

    public void clickEmptyCartLink(){
        driver.findElement(emptyCartLink).click();
    }

    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }

    public CheckoutPage clickProceedtoCheckoutBtn(){
        driver.findElement(proceedtoCheckoutBtn).click();
        return new CheckoutPage(driver);
    }

    public String getOneProductPrice(){
        return driver.findElement(oneProductPrice).getText();
    }


    public String getGrandTotal(){
        return driver.findElement(grandTotal).getText();
    }


    public void enterCouponAndApply(String couponCode){
        driver.findElement(couponTxtBx).sendKeys(couponCode);
        driver.findElement(applyCouponLink).click();
    }


}
