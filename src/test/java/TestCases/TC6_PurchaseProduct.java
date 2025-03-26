package TestCases;

import Base.BaseTests;
import Utils.StringManager;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


/* TC6 : Verify you can purchase product using a registered account */
public class TC6_PurchaseProduct extends BaseTests {
    @Test
    public void testPurchaseProduct(){
        /* Click on 'MY ACCOUNT' link */
        var myAcc = home.clickMyAccLink();
        /* Enter registered account data */
        String[] accData = {"ahmed.hesham.mostafa82@gmail.com", "93827155aa"};
        myAcc.enterRegisteredAcc(accData);
        /* Click on 'LOGIN' button */
        var myDashboard = myAcc.clickLoginBtn();
        /* Click on 'MY WISHLIST' link */
        var myWishlist = myDashboard.clickMyWishlistLink();
        /* Click on 'ADD TO CART' button */
        var myCart = myWishlist.clickAddtoCartBtn();
        /* Click 'PROCEED TO CHECKOUT' button */
        var checkout = myCart.clickProceedtoCheckoutBtn();
        /* Choose 'Ship to different address' radio button */
        checkout.selectShiptoDiffAddrRadio();
        /* Enter the billing info */
        String[] billInfo = {"ABC", "New York", "New York", "542896", "United States", "12345678"};
        checkout.fillBillingInfo(billInfo);
        /* Click on 'CONTINUE' button */
        checkout.clickContinueBtnAftBillInfo();
        /* Enter the shipping info */
        String[] shipInfo = {"Ahmed", "Hesham", "ABC", "New York", "New York", "542896", "United States", "12345678"};
        checkout.fillShippingInfo(shipInfo);
        /* Click on 'CONTINUE' button */
        checkout.clickContinueBtnAftShipInfo();
        /* Get the shipping cost and method and verify them */
        String cost = checkout.getShippingCost();
        String expectedShipCost = "Flat Rate\nFixed $5.00";
        assertEquals(cost, expectedShipCost, "Shipping Cost or Method is Not Correct!");
        /* Click on 'CONTINUE' button */
        checkout.clickContinueBtnAftShipMethod();
        /* Select Check / Money Order radio button */
        checkout.selectCheck_moneyOrderRadio();
        /* Click on 'CONTINUE' button */
        checkout.clickContinueBtnAftPay();
        String subTot = checkout.getSubTotal();
        String shipping = checkout.getShipandHandlCost();
        String grandTot = checkout.getGrandTotal();
        /* To extract the number 5 from the expectedShipCost string */
        StringManager strMgrObj = new StringManager();
        int shipCostInit = strMgrObj.extractNumfromPrice(expectedShipCost);
        /* To extract the number 5 from the shipping string */
        int shipCostFin = strMgrObj.extractNumfromPrice(shipping);
        /* Verify that shipCostInit and shipCostFin are equal */
        assertEquals(shipCostFin, shipCostInit, "Shipping Cost Added to Subtotal is Not Correct!");

        /* To extract subtotal as an int from subTot string */
        int subTotInt = strMgrObj.extractNumfromPrice(subTot);
        /* To extract grand total as an int from grandTot string */
        int grandTotInt = strMgrObj.extractNumfromPrice(grandTot);
        /* Verify that Subtotal + Shipping Cost = Grand Total */
        assertEquals(grandTotInt - subTotInt, shipCostInit, "Shipping Cost is Summed Incorrectly with Subtotal!");
        /* Click on 'PLACE ORDER' button */
        checkout.clickPlaceOrderBtn();
        /* Verify that the page title indicates that the order is received */
        assertEquals(checkout.getPageTitle(), "YOUR ORDER HAS BEEN RECEIVED.", "Order is Not Received Successfully!");
        /* Print the generated order number */
        System.out.println("Order Number Is : " + checkout.getOrderNum());
    }
}
