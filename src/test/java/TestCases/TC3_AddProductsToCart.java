package TestCases;

import Base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/* TC3 : Verify that you cannot add more products in cart than available in store and empty cart */
public class TC3_AddProductsToCart extends BaseTests {
    @Test
    public void testAddtoCart(){
        /* Click on 'MOBILE' menu */
        var mobile = home.clickMobileLink();
        /* In the list of all mobiles, click on 'ADD TO CART' for SONY XPERIA mobile */
        var cart = mobile.addProductToCart("iphone");
        /* Change 'QTY' value to 1000 and click 'UPDATE' button */
        cart.addQuantityandUpdate(1000);
        /* Verify the error message */
        assertEquals(cart.getQuantityError(), "* The maximum quantity allowed for purchase is 500.", "Quantity Error is Incorrect!");
        /* Click on 'EMPTY CART' link in the footer of cart page */
        cart.clickEmptyCartLink();
        /* Verify cart is empty */
        assertEquals(cart.getPageTitle(), "SHOPPING CART IS EMPTY", "Cart is Not Empty!");
    }
}
