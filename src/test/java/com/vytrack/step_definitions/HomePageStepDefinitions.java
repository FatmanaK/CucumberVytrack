package com.vytrack.step_definitions;

import com.vytrack.pages.login_navigation.LoginPage;
import com.vytrack.utilities.BasePage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import cucumber.api.java.en.*;
import org.junit.Assert;

public class HomePageStepDefinitions extends BasePage {

    LoginPage loginPage = new LoginPage();

    @Given("User on login page")
    public void user_on_login_page() {
        System.out.println("User on the login page");
        // when we call Driver class it will navigate to the url. Configuration reader will call the url from config.properties file
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("User logs in using {} and {string}")
    public void user_logs_in_using_and(String email, String password) {
        System.out.println("user logs in using email and password");

//        String storemanagerusername= ConfigurationReader.getProperty("storemanagerusername");
//        String storemanagerpassword =ConfigurationReader.getProperty("storemanagerpassword");
//        loginPage.login(storemanagerusername,storemanagerpassword);

        //this is the second way how we can sign in.
        loginPage.userNameElement.sendKeys("salesmanager270");
        loginPage.passwordElement.sendKeys("UserUser123");
        loginPage.loginButtonElement.click();


    }


    @Then("title should be {string}")
    public void title_should_be(String title) {
//        title="Dashboard";
//        Assert.assertEquals(title, Driver.getDriver().getTitle());
        System.out.println("Dashboard");
    }


    @Then("there should be {int} menu options tabs")
    public void there_should_be_menu_options_tabs(Integer tabsCount) {
        System.out.println("Tabs count");
    }

}
