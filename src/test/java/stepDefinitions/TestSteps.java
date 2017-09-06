package stepDefinitions;

import automationFramework.supportMethods.ExcelUtility;
import cucumber.api.java.en.Given;
import webDriver.DriverMethods;

import java.util.ArrayList;

public class TestSteps {
    DriverMethods dm= new DriverMethods();
    ExcelUtility utility= new ExcelUtility();

    @Given("^school domain$")
    public void school_domain() throws Throwable {
        ArrayList<String>list= utility.readExcel();
        for (String lst:list){
            dm.getUrl(lst);


        }
    }
}
