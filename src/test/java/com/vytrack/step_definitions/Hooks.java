package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    //this is default that runs for any scenario
    @Before(order  =0) //it will get the name of Scenario that we run
    public void setUp(Scenario scenario){
        System.out.println("scenario = " + scenario.getSourceTagNames());

        System.out.println("scenario = " + scenario.getName());
        System.out.println("I am setting up the test the Hooks class!! Before method running!!");

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //we can also add maximize screen here, but I already added at Driver class
    }









    @After()
    public void tearDown(Scenario scenario) {
        System.out.println("Reporting with @After");
        //I want to take screenshot when current scenario fails.
        //scenario.isFailed() --> tels if the scenario failed or not.
        if(scenario.isFailed()){

            //I did it with Vasyl
//            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
//            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
//            scenario.embed(image, "image/png");


            //this is for taking screenshot
            final byte[] screenshot =((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot,"image/png");
        }
        System.out.println("Closing driver with After method");
        Driver.closeDriver();
    }





    //this Hook will work only for scenarios with tag @negative
    //also it will run before default hook
    //because of priority (order=1)
//    @Before(value = "@negative", order = 0)
//    public void setUpDriver() {
//        System.out.println("Before for negative");
//    }



}
