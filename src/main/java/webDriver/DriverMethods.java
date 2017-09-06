package webDriver;

import static webDriver.AppDriver.driver;

public class DriverMethods {
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void getUrl(String url){
        driver.get(url);
    }
}
