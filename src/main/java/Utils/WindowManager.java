package Utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {
    private WebDriver driver;

    public WindowManager(WebDriver userDriver){
        this.driver = userDriver;
    }

    public void closeWindow(){
        driver.close();
    }

    public boolean isWindowOpen(String windowTitle){
        var windowHandles = driver.getWindowHandles();

        for(String windowHandle : windowHandles){
            driver.switchTo().window(windowHandle);

            if(driver.getTitle().equals(windowTitle)){
                return true;
            }
        }

        return false;
    }


    public String getCurrentWindowTitle(){
        return driver.getTitle();
    }
}
