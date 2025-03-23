package TestCases;

import Base.BaseTests;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

/* TC4 : Verify that you are able to compare two products */
public class TC4_CompareTwoProducts extends BaseTests {
    ArrayList<String> expectProdNames = new ArrayList<String>();

    @Test
    public void testCmprProducts(){
        /* Click on 'MOBILE' menu */
        var mobile = home.clickMobileLink();
        /* In mobile products list, click on 'Add to Compare' for SONY XPERIA and IPHONE */
        mobile.addProductToCompare("sony xperia");
        mobile.addProductToCompare("iphone");
        /* Click on 'COMPARE' button */
        var cmprPage = mobile.clickCmprBtnandSwitch();
        /* Verify the pop-up window and check that the products are reflected in it */
        assertEquals(cmprPage.getPageHeading(), "COMPARE PRODUCTS", "Compare Page Heading is Incorrect!");
        expectProdNames.add("SONY XPERIA");
        expectProdNames.add("IPHONE");
        assertEquals(cmprPage.getProductsNames(), expectProdNames, "Product Names in Compare Page are Incorrect!");
        /* Close the pop-up window */
        windowMgr.closeWindow();
        assertFalse(windowMgr.isWindowOpen("Products Comparison List - Magento Commerce"), "Compare Page is Not Closed!");
    }
}
