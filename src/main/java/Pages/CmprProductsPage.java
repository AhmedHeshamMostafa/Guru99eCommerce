package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CmprProductsPage {
    private WebDriver driver;

    private By product = By.className("product-name");

    private By pageHeading = By.tagName("h1");

    public CmprProductsPage(WebDriver userDriver){
        this.driver = userDriver;
    }

    public String getPageHeading(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(pageHeading));
        return driver.findElement(pageHeading).getText();
    }


    public ArrayList<String> getProductsNames(){
        return (driver.findElements(product)).stream().map(WebElement::getText).collect(Collectors.toCollection(ArrayList::new));


    }
}
