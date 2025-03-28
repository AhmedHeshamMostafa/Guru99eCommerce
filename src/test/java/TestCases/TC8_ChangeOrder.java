package TestCases;

import Base.BaseTests;
import Utils.StringManager;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/* TC8 : Verify that you are able to change or reorder a previously added product */
public class TC8_ChangeOrder extends BaseTests {
    @Test
    public void testChangeOrder(){
        /* Click on 'MY ACCOUNT' link */
        var myAcc = home.clickMyAccLink();
        /* Enter registered account data */
        String[] accData = {"ahmed.hesham.mostafa91@gmail.com", "93827155aa"};
        myAcc.enterRegisteredAcc(accData);
        /* Click on 'LOGIN' button */
        var dashboard = myAcc.clickLoginBtn();
        /* Click on REORDER' link */
        var cart = dashboard.clickReOrderLink();
        /* Change product quantity to be 10 and click 'UPDATE' button */
        String gTotBeforeUpdtStr = cart.getGrandTotal();
        cart.addQuantityandUpdate(10);
        /* Collect relevant prices to be used in assertions */
        String prodPriceStr = cart.getOneProductPrice();
        String gTotAftUpdtStr = cart.getGrandTotal();

        StringManager strMgr = new StringManager();

        int prodPriceInt = strMgr.extractNumfromPrice(prodPriceStr);
        int grandTotBeforeInt = strMgr.extractNumfromPrice(gTotBeforeUpdtStr);
        int grandTotAftInt = strMgr.extractNumfromPrice(gTotAftUpdtStr);
        /* Verify that when quantity equals 1, grand total is equal to the one product price */
        assertEquals(grandTotBeforeInt, prodPriceInt, "Before Quantity Update, One Product Price is Not Equals to Grand Total!");
        /* Verify that when quantity equals 10, grand total is equal to the one product price times 10 */
        assertEquals(grandTotAftInt, prodPriceInt*10, "Grand Total in Not Correctly Changed!");

        /* Click on 'PROCEED TO CHECKOUT' button */
        var checkout = cart.clickProceedtoCheckoutBtn();
        /* Complete the steps of the checkout process */
        checkout.clickContinueBtnAftBillInfo();
        checkout.clickContinueBtnAftShipMethod();
        checkout.selectCheck_moneyOrderRadio();
        checkout.clickContinueBtnAftPay();
        /* Click on 'PLACE ORDER' button' */
        checkout.clickPlaceOrderBtn();
        /* Verify that the new order is successfully generated and print its number */
        assertEquals(checkout.getPageTitle(), "YOUR ORDER HAS BEEN RECEIVED.", "Order is Not Received Successfully!");
        System.out.println("Order Number Is : " + checkout.getOrderNum());
    }

}
