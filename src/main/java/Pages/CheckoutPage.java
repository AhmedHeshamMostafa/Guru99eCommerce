package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {
    private WebDriver driver;

    private By shiptoDiffAddrRadio = By.id("billing:use_for_shipping_no");
    private By bill_addrTxtBx = By.id("billing:street1");
    private By bill_cityTxtBx = By.id("billing:city");
    private By bill_stateDropDn = By.id("billing:region_id");
    private By bill_zipTxtBx = By.id("billing:postcode");
    private By bill_countryDropDn = By.id("billing:country_id");
    private By bill_telephoneTxtBx = By.id("billing:telephone");
    private By continueBtnAftBillInfo = By.cssSelector("[onclick=\"billing.save()\"]");

    private By ship_firstNameTxtBx = By.id("shipping:firstname");
    private By ship_lastNameTxtBx = By.id("shipping:lastname");
    private By ship_addressTxtBx = By.id("shipping:street1");
    private By ship_cityTxtBx = By.id("shipping:city");
    private By ship_stateDrpDn = By.id("shipping:region_id");
    private By ship_zipTxtBx = By.id("shipping:postcode");
    private By ship_countryDrpDn = By.id("shipping:country_id");
    private By ship_telephoneTxtBx = By.id("shipping:telephone");
    private By continueBtnAftShipInfo = By.cssSelector("[onclick=\"shipping.save()\"]");

    private By shipCost = By.cssSelector("dl[class=\"sp-methods\"]");
    private By continueBtnShip = By.cssSelector("[onclick=\"shippingMethod.save()\"]");

    private By check_moneyOrderRadio = By.id("p_method_checkmo");
    private By continueBtnPay = By.cssSelector("[onclick=\"payment.save()\"]");

    private By subTotal = By.cssSelector("[class=\"first\"] .a-right.last");
    private By shipandHandlCost = By.cssSelector("tr:not(.first):not(.last) .a-right.last");
    private By grandTotal = By.cssSelector("[class=\"last\"] .a-right.last");

    private By placeOrderBtn = By.cssSelector("[title=\"Place Order\"]");
    private By pageTitle = By.className("page-title");
    private By orderNum = By.cssSelector("div[class=\"main\"] div[class=\"col-main\"] p a");





    public CheckoutPage(WebDriver userDriver){
        this.driver = userDriver;
    }

    public void selectShiptoDiffAddrRadio(){
        driver.findElement(shiptoDiffAddrRadio).click();
    }


    /**
     *
     * @param billingInfo is an array of strings in which the user provides their billing info such that:
     *              billingInfo[0] : address,
     *              billingInfo[1] : city,
     *              billingInfo[2] : state/province (Write text as displayed in the dropdown menu),
     *              billingInfo[3] : zip,
     *              billingInfo[4] : country (Write text as displayed in the dropdown menu),
     *              billingInfo[5] : telephone
     */
    public void fillBillingInfo(String[] billingInfo){
        Select stateDropDown = new Select(driver.findElement(bill_stateDropDn));
        Select countryDropDown = new Select(driver.findElement(bill_countryDropDn));

        driver.findElement(bill_addrTxtBx).sendKeys(billingInfo[0]);
        driver.findElement(bill_cityTxtBx).sendKeys(billingInfo[1]);
        stateDropDown.selectByVisibleText(billingInfo[2]);
        driver.findElement(bill_zipTxtBx).sendKeys(billingInfo[3]);
        countryDropDown.selectByVisibleText(billingInfo[4]);
        driver.findElement(bill_telephoneTxtBx).sendKeys(billingInfo[5]);
    }


    /**
     *
     * @param shippingInfo is an array of strings in which the user provides their billing info such that:
     *              shippingInfo[0] : first name,
     *              shippingInfo[1] : last name,
     *              shippingInfo[2] : address,
     *              shippingInfo[3] : city,
     *              shippingInfo[4] : state/province (Write text as displayed in the dropdown menu),
     *              shippingInfo[5] : zip,
     *              shippingInfo[6] : country (Write text as displayed in the dropdown menu),
     *              shippingInfo[7] : telephone
     *
     */
    public void fillShippingInfo(String[] shippingInfo){
        Select stateDropDown = new Select(driver.findElement(ship_stateDrpDn));
        Select countryDropDown = new Select(driver.findElement(ship_countryDrpDn));



//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("window.scrollTo(0, 0);");

        driver.findElement(ship_firstNameTxtBx).sendKeys(shippingInfo[0]);
        driver.findElement(ship_lastNameTxtBx).sendKeys(shippingInfo[1]);
        driver.findElement(ship_addressTxtBx).sendKeys(shippingInfo[2]);
        driver.findElement(ship_cityTxtBx).sendKeys(shippingInfo[3]);
        stateDropDown.selectByVisibleText(shippingInfo[4]);
        driver.findElement(ship_zipTxtBx).sendKeys(shippingInfo[5]);
        countryDropDown.selectByVisibleText(shippingInfo[6]);
        driver.findElement(ship_telephoneTxtBx).sendKeys(shippingInfo[7]);
    }



    public String getShippingCost(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, 0);");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.presenceOfElementLocated(shipCost));
        wait.until(d -> !driver.findElement(shipCost).getText().trim().isEmpty());

        return driver.findElement(shipCost).getText();
    }


    public void clickContinueBtnAftBillInfo(){
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(continueBtn));
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.elementToBeClickable(continueBtnAftBill));
        driver.findElement(continueBtnAftBillInfo).click();
    }

    public void clickContinueBtnAftShipInfo(){
        driver.findElement(continueBtnAftShipInfo).click();
    }

    public void clickContinueBtnAftShipMethod(){
        driver.findElement(continueBtnShip).click();
    }


    public void clickContinueBtnAftPay(){
        driver.findElement(continueBtnPay).click();
    }


    public void selectCheck_moneyOrderRadio(){
        driver.findElement(check_moneyOrderRadio).click();
    }


    public String getSubTotal(){
        return driver.findElement(subTotal).getText();
    }

    public String getShipandHandlCost(){
        return driver.findElement(shipandHandlCost).getText();
    }

    public String getGrandTotal(){
        return driver.findElement(grandTotal).getText();
    }

    public void clickPlaceOrderBtn(){
       driver.findElement(placeOrderBtn).click();
    }

    public String getPageTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.presenceOfElementLocated(pageTitle));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(pageTitle)));
        wait.until(d -> !driver.findElement(pageTitle).getText().equals("CHECKOUT"));
        return driver.findElement(pageTitle).getText();
    }

    public String getOrderNum(){
        return driver.findElement(orderNum).getText();
    }







}
