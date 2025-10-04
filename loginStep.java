package stepDefinitions;

import Pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import utilities.driver_factory;
import utilities.utilityFetchProperty;

import java.io.IOException;

public class loginStep {
        @Given("Iam in the login page")
        public void iamInTheLoginPage() throws IOException, InterruptedException {
            loginPage.sitenavigation();  //


        }
    @When("login with valid username {string} & valid password{string}")
    public void loginWithValidUsernameValidPassword(String username, String password) throws InterruptedException {
            loginPage.loginpage(username, password);


    }

    @Then("successful login")
    public void successfulLogin() {
            loginPage.homePageNavigation();
    }

    @Then("unsuccessful login")
    public void unsuccessfulLogin() {
        loginPage.homePageNavigation();
    }

    @When("login with a {} & a {}")
    public void loginWithAA(String username, String password) throws InterruptedException {
        loginPage.loginpage(username, password);
    }

    @When("login with valid username {string} & Invalid password{string}")
    public void loginWithValidUsernameInvalidPassword(String username, String password) throws InterruptedException {
        loginPage.loginpage(username, password);
    }


//    @Then("successful\\/unsuccessful login")
//    public void successfulUnsuccessfulLogin() {
//        loginPage.homePageNavigation();
//    }


    @Given("user in the login page")
    public void userInTheLoginPage() throws IOException, InterruptedException {


                   }

    @Then("successful\\/unsuccessful login")
    public void successfulUnsuccessfulLogin() {

    }

    @When("user login with valid username and valid password")
    public void userLoginWithValidUsernameAndValidPassword() {
        String username=utilityFetchProperty.fetchPropertyValue("username");
        String password=utilityFetchProperty.fetchPropertyValue("password");
        loginPage.loginpage(username,password);


    }
}


