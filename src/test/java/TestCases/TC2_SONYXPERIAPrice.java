package TestCases;

import Base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


/* TC2 : Verify that cost of SONY XPERIA in list page and details page are equal */
public class TC2_SONYXPERIAPrice extends BaseTests {
    @Test
    public void testProductPrice(){
        /* Click on 'MOBILE' menu */
        var mobile = home.clickMobileLink();
        /* Read the SONY XPERIA price from list page */
        String priceonList = mobile.getProductPrice("sony xperia");
        /* Click on SONY XPERIA mobile */
        var SONYXPERIA = mobile.clickOnSONYXPERIA();
        /* Read the SONY XPERIA price from details page */
        String priceOnDetails = SONYXPERIA.getPrice();
        /* Verify both prices in list page and details page are equal */
        assertEquals(priceonList, priceOnDetails, "Price on Result Page Does Not Equal Price on Details Page!");
    }
}
