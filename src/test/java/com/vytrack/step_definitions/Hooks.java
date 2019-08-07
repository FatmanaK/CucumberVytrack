package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before(order  =0)
    public void setUp(){
        System.out.println("I am setting up the test the Hooks class!!");

        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //we can also add maximize screen here, but I already added at Driver class
    }



    @After()
    public void tearDown(Scenario scenario) {
        System.out.println("Reporting with @After");
        //I want to take screenshot when current scenario fails.
        //scenario.isFailed() --> tels if the scenario failed or not.
       if(scenario.isFailed()){
           //this is for taking screenshot
           final byte[] screenshot =((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
           scenario.embed(screenshot,"image/png");
       }
        System.out.println("Closing driver");
        Driver.closeDriver();
    }


//    @Before(value = "@driver", order = 2)
//    public void setUpDriver() {
//        System.out.println("Set up driver test");
//    }
}
