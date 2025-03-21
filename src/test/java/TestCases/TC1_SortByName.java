package TestCases;

import Base.BaseTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.testng.Assert.*;


/* TC1 : Verify items in Mobile list page can be sorted by name */
public class TC1_SortByName extends BaseTests {
    @Test
    public void testElementsNameSorted(){
        /* Verify title of home page */
        assertTrue(home.getTitleTxt().toLowerCase().contains("this is demo site for"), "Home Page Title is Incorrect!");
        /* Click on MOBILE menu */
        var mobile = home.clickMobileLink();
        /* Verify title of mobile page */
        assertTrue(mobile.getTitleTxt().toLowerCase().contains("mobile"), "Mobile Page Title is Incorrect!");
        /* In the list of all mobiles, select 'SORT BY' dropdown as 'Name' */
        mobile.sortBy("Name");
        /* Verify all products are sorted by name */
        /* This is done by getting the names of the products in an arraylist of strings,
           create another arraylist that has the product names sorted by name,
           then verify whether these two arraylists are equal or not.
         */
        ArrayList<String> productNames = mobile.getProductsNames();
        ArrayList<String> sortedProductNames = new ArrayList<String>(productNames);
        Collections.sort(sortedProductNames);
        assertEquals(productNames,sortedProductNames, "Products are not Ordered by Name!");


    }





}
