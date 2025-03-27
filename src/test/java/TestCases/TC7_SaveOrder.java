package TestCases;

import Base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/* TC7 : Verify that you can save a previously placed order as PDF */
public class TC7_SaveOrder extends BaseTests {
    @Test
    public void testSaveOrdertoPDF(){
        /* Click on 'MY ACCOUNT' link */
        var myAcc = home.clickMyAccLink();
        /* Enter registered account data */
        String[] accData = {"ahmed.hesham.mostafa91@gmail.com", "93827155aa"};
        myAcc.enterRegisteredAcc(accData);
        /* Click on 'LOGIN' button */
        var myDashboard = myAcc.clickLoginBtn();
        /* Click on 'MY ORDERS' link */
        var myOrders = myDashboard.clickMyOrdersLink();
        /* Click on 'VIEW ORDER' link */
        var order = myOrders.clickViewOrderLink();
        /* Get order number and status and verify them */
        String orderNumStr = order.getOrderNum();
        String orderStatus = order.getOrderStatus();
        System.out.println("Order Number is : " + orderNumStr);
        assertEquals(orderStatus, "PENDING", "Order Status is NOT Pending!");
        /* Click on 'Print Order' link */
        var printOrder = order.clickPrintOrderandSwitch();
        /* Verify that the print order window is open successfully */
        String curWindowTitle = windowMgr.getCurrentWindowTitle();
        assertEquals(curWindowTitle, "Print Order # " + orderNumStr, "Order is Not Correctly Printed!");

    }
}
