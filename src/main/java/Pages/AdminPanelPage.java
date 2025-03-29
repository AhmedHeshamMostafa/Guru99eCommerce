package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AdminPanelPage {
    private WebDriver driver;

    private By closePopupMsgBtn = By.cssSelector("[title=\"close\"]");
    private By salesMenu = By.cssSelector("#nav>li:nth-child(1)");
    private By ordersOption = By.xpath("//*[contains(text(), \"Orders\")]");
    private By exportToDropDn = By.id("sales_order_grid_export");
    private By exportBtn = By.cssSelector("[title=\"Export\"]");


    public AdminPanelPage(WebDriver userDriver){
        this.driver = userDriver;
    }


    public void closePopupMsg(){
        driver.findElement(closePopupMsgBtn).click();
    }


    public void hoverOnSalesMenu(){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(salesMenu)).perform();
    }


    public void clickOrdersOption(){
        driver.findElement(ordersOption).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(salesMenu)));
    }


    /**
     *
     * @param option is the option you are willing to chose from the Export to drop-down menu
     *               write the string value in option as visible text.
     */
    public void selectFromExportToDropDn(String option){
        Select exportToDropobj = new Select(driver.findElement(exportToDropDn));
        exportToDropobj.selectByVisibleText(option);
    }


    public void clickExportBtn(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.presenceOfElementLocated(exportBtn));
        driver.findElement(exportBtn).click();
    }







}
