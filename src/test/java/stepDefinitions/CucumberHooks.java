package stepDefinitions;

import automationFramework.supportMethods.GenericObjects;
import automationFramework.supportMethods.ReadFile;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import webDriver.DriverMethods;

import java.io.IOException;

import static webDriver.AppDriver.driver;
import static webDriver.AppDriver.getCurrentDriver;

public class CucumberHooks implements GenericObjects {
    private DriverMethods dm= new DriverMethods();

    @Before
    public void launchBrowser() throws IOException {
        ReadFile readConfig= new ReadFile();
        System.setProperty(readConfig.readProperty(f,"driver"),readConfig.readProperty(f,"driverPath"));
        driver= getCurrentDriver();
        dm.maximizeWindow();
    }

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()){
            //utility.takeScreenshot();
        }
    }

    @After
    public void closeBrowser()
    {
        driver.quit();
        driver= null;
    }
}
