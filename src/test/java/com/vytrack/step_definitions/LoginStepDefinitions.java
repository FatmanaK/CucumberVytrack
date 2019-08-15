package com.vytrack.step_definitions;

import com.vytrack.pages.login_navigation.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    Pages pages=new Pages();


    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        pages.loginPage().goToLandingPage();
    }

    @Then("user logs in as a store manager")
    public void user_logs_in_as_a_store_manager() {
        String username=ConfigurationReader.getProperty("storemanagerusername");
        String password=ConfigurationReader.getProperty("storemanagerpassword");
        pages.loginPage().login(username,password);
    }

    @Then("user verifies that {string} page name is displayed")
    public void user_verifies_that_page_name_is_displayed(String expected) {
        Assert.assertEquals(expected,pages.dashboardPage().getPageSubTitle());
    }


    @Then("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String username, String password) {
        pages.loginPage().login(username,password);
    }

    @Then("user verifies that {string} warning message is displayed")
    public void user_verifies_that_warning_message_is_displayed(String expected) {
        Assert.assertEquals(expected, pages.loginPage().getErrorMessage());
    }

    @Then("user logs in as a driver")
    public void user_logs_in_as_a_driver() {
       String userName=ConfigurationReader.getProperty("driverusername");
       String userPassword=ConfigurationReader.getProperty("driverpassword");
       pages.loginPage().login(userName, userPassword);
    }

    @Then("user logs in as a {string}")
    public void user_logs_in_as_a(String role) {
        pages.loginPage().login(role);
    }















//
//    @Given("Open Vytrack login page")
//    public void open_Vytrack_login_page() {
//        Driver.getDriver().get("https://amazon.com");
////        Driver.getDriver().close();
//    }
//
//    @When("Enter valid username and invalid password credentials")
//    public void enter_valid_username_and_invalid_password_credentials() {
//        System.out.println("Entering valid user name");
//
//    }
//
//    @When("Click login button")
//    public void click_login_button() {
//        System.out.println("Clicking on login button");
//    }
//
//    @Then("Message Invalid user name or password. should be displayed")
//    public void message_Invalid_user_name_or_password_should_be_displayed() {
//        System.out.println("Getting message");
//    }
//
//    @Then("Page title and url should be the same")
//    public void page_title_and_url_should_be_the_same() {
//        System.out.println("Getting title");
//    }
//
//    @When("Enter valid driver user name and valid password credentials")
//    public void enter_valid_driver_user_name_and_valid_password_credentials() {
//        System.out.println("Signing in as driver");
//    }
//
//    @Then("Homepage should be displayed")
//    public void homepage_should_be_displayed() {
//        System.out.println("On home page");
//    }
//
//    @Then("Verify page title")
//    public void verify_page_title() {
//        System.out.println("Verifying title");
//    }

}
