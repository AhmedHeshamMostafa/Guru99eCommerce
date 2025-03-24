package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TVPage {
    private WebDriver driver;

    private By LGLCD = By.id("product-collection-image-4");
    private By SamsungLCD = By.id("product-collection-image-5");
    private By xpathforAddtoWishlist = By.xpath("../../div/div[@class=\"actions\"]/ul/li/a[@class=\"link-wishlist\"]");

    private WebElement productElement;


    public TVPage(WebDriver userDriver){
        this.driver = userDriver;
    }

    public WishlistPage addProducttoWishlist(String productName){
        switch(productName.toLowerCase()){
            case "lg lcd":
                productElement = driver.findElement(LGLCD);
                break;

            case "samsung lcd":
                productElement = driver.findElement(SamsungLCD);
                break;
        }

        productElement.findElement(xpathforAddtoWishlist).click();
        return new WishlistPage(driver);
    }


}
