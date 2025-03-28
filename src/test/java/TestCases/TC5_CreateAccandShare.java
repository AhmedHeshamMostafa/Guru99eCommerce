package TestCases;

import Base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


/* TC5 : Verify you can create account and can share wishlist using email */
public class TC5_CreateAccandShare extends BaseTests {
    @Test
    public void testCreateAccandShareWishlist(){
        /* Click on 'MY ACCOUNT' link */
        var myAcc = home.clickMyAccLink();
        /* Click on 'CREATE AN ACCOUNT' button */
        var createAcc = myAcc.clickCreateAccBtn();
        /* Fill new account information */
        String[] userData = {"Ahmed", "Hesham", "Hany", "ahmed.hesham.mostafa91@gmail.com", "93827155aa", "93827155aa"};
        createAcc.fillUserInfo(userData);
        /* Click on 'REGISTER' button */
        var dashboard = createAcc.clickRegisterBtn();
        /* Verify registration is done successfully */
        assertEquals(dashboard.getTitleTxt(), "MY DASHBOARD", "Dashboard Page Title is Incorrect!");
        assertEquals(dashboard.getSuccessMsg(), "Thank you for registering with Main Website Store.", "Account Creation Success Message is Incorrect!");
        /* Go to TV menu*/
        var tv = dashboard.clickTVLink();
        /* Add LG LCD to your wishlist */
        var wishlist = tv.addProductToWishlist("lg lcd");
        /* Click 'SHARE WISHLIST' button */
        var shareWishlist = wishlist.clickShareWishlistBtn();
        /* Enter email and a message */
        shareWishlist.fillEmailsTxtBx("ahmedhesham8274@gmail.com");
        shareWishlist.fillMessageTxtBx("This is my lovely wishlist to share with you!");
        /* Click 'SHARE WISHLIST' button */
        wishlist = shareWishlist.clickShareWishlistBtn();
        /* Verify wishlist is shared successfully */
        assertEquals(wishlist.getWishListSharedTxt(), "Your Wishlist has been shared.", "Wishlist is not Shared!");

    }
}
