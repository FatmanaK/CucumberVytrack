package com.vytrack.runners;

//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.junit.Cucumber;



import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                //This is for default cucumber report     this is a plugin more better than cucumber report
        plugin = {"html:target/default-cucumber-reports",  "json:target/cucumber.json"},


        features = {"src/test/resources/features"}, //to specify where are the features,
        //feature contains scenarios
        //every scenario is like a test
        //where is the implementation for features
        glue = {"com/vytrack/step_definitions"},
        //dry run - to generate step definitions automatically
        //you will see them in the console output
        dryRun = false,
        tags = {"@navigation"} //I can put also "@storemanager and @negative"
        //~ (tilde), ~@negative it means scenarios with this tag will be ignored, or we can use "not @negative"
)
public class CukesRunner {
}
