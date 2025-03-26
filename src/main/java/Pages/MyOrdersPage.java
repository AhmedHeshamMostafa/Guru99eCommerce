package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyOrdersPage {
    private WebDriver driver;

    private By viewOrderLink = By.cssSelector(".a-center.view.last span a:nth-child(1)");

    public MyOrdersPage(WebDriver userDriver){
        this.driver = userDriver;
    }


    public OrderPage clickViewOrderLink(){
        driver.findElement(viewOrderLink).click();
        return new OrderPage(driver);
    }


}
