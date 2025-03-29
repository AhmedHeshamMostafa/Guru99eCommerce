package TestCases;

import Base.BaseTests;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.*;

public class TC10_ExportOrders extends BaseTests {
    @Test
    public void testExportOrdersandEmail() throws Exception {
        /* Enter the user credentials */
        String[] userCredentials = {"user01", "guru99com"};
        adminLogin.enterCredentials(userCredentials);
        /* Click on 'LOGIN' button */
        var adminPanel = adminLogin.clickLoginBtn();
        /* Close the pop-up message */
        adminPanel.closePopupMsg();
        /* Hover on the 'Sales' menu then click the 'Orders' option from it */
        adminPanel.hoverOnSalesMenu();
        adminPanel.clickOrdersOption();
        /* Select 'CSV' from the 'Export to' drop-down menu then click on 'Export' button' */
        adminPanel.selectFromExportToDropDn("CSV");
        adminPanel.clickExportBtn();

        /* Now we are displaying the contents the downloaded CSV file in console */
        String downloadPath = "C:\\Users\\Ahmed Hesham\\Downloads";
        String fileName = "orders.csv";
        //File csvFile = new File(downloadPath + fileName);
        Path csvFilePath = Paths.get(downloadPath, fileName);
        File csvFile = csvFilePath.toFile();
        while (!Files.exists(csvFilePath)) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Thread.sleep(5000);
        BufferedReader br = new BufferedReader(new FileReader(csvFile));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
}

