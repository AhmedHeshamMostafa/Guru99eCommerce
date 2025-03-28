package TestCases;

import Base.BaseTests;
import Utils.StringManager;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


/* TC9 : Verify discount coupon works correctly */
public class TC9_DiscountCoupon extends BaseTests {
    @Test
    public void testDiscountCoupon(){
        /* Click on 'MOBILE' link */
        var mobile = home.clickMobileLink();
        /* Add IPHONE to cart */
        var cart = mobile.addProductToCart("iphone");
        /* Get grand total before applying coupon */
        String grandTotBeforeCouponStr = cart.getGrandTotal();
        /* Apply 'GURU50' coupon */
        cart.enterCouponAndApply("GURU50");
        /* Get grand total after applying coupon */
        String grandTotAftCouponStr = cart.getGrandTotal();
        StringManager strMgr = new StringManager();
        int grandTotBeforeCouponInt = strMgr.extractNumfromPrice(grandTotBeforeCouponStr);
        int grandTotAftCouponInt = strMgr.extractNumfromPrice(grandTotAftCouponStr);
        /* Verify that grand total after applying coupon is equal to 95% of grand total before applying coupon */
        assertEquals(grandTotAftCouponInt, (95.0/100)*grandTotBeforeCouponInt, "Discount is Not Correctly Applied!");




    }
}
