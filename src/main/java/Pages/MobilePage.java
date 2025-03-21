package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MobilePage {
    private WebDriver driver;
    private By pageTitle = By.tagName("h1");
    private By sortBy = By.cssSelector("select[title=\"Sort By\"]");
    private By product = By.cssSelector("[class=\"product-name\"]");
    private By SONYXPERIA = By.id("product-collection-image-1");
    private By IPhone = By.id("product-collection-image-2");
    private By SamsungGalaxy = By.id("product-collection-image-3");
    private By xpathforPrice = By.xpath("../../div/div[@class=\"price-box\"]");
    private By xpathforAddtoCart = By.xpath("../../div/div[@class=\"actions\"]/button");

    private WebElement productElement;

    public MobilePage(WebDriver userDriver){
        this.driver = userDriver;
    }

    public String getTitleTxt(){
        return driver.findElement(pageTitle).getText();
    }


    public void sortBy(String option){
        Select sortDrpDown = new Select(driver.findElement(sortBy));
        sortDrpDown.selectByVisibleText(option);
    }

    public ArrayList<String> getProductsNames(){
        ArrayList<WebElement> productElements = new ArrayList<WebElement>(driver.findElements(product));
        ArrayList<String> productsText = productElements.stream().map(WebElement::getText).collect(Collectors.toCollection(ArrayList::new));
        return productsText;
    }

    public String getProductPrice(String productName){
        String productPrice;

        switch(productName.toLowerCase()){
            case "sony xperia":
                productElement = driver.findElement(SONYXPERIA);
                break;

            case "iphone":
                productElement = driver.findElement(IPhone);
                break;

            case "samsung galaxy":
                productElement = driver.findElement(SamsungGalaxy);
                break;
        }



        String[] priceStrings = (productElement.findElement(xpathforPrice).getText()).split("\\s+");

        if(priceStrings.length == 1){
            productPrice = priceStrings[0];
        }
        else{
            productPrice = priceStrings[1];
        }

        return productPrice;

    }


    public CartPage addProductToCart(String productName){
        switch (productName.toLowerCase()){
            case "sony xperia":
                productElement = driver.findElement(SONYXPERIA);
                break;

            case "iphone":
                productElement = driver.findElement(IPhone);
                break;

            case "samsung galaxy":
                productElement = driver.findElement(SamsungGalaxy);
                break;

        }

        productElement.findElement(xpathforAddtoCart).click();

        return new CartPage(driver);
    }



    public SONYXPERIADtlPage clickOnSONYXPERIA(){
        driver.findElement(SONYXPERIA).click();
        return new SONYXPERIADtlPage(driver);
    }


}
