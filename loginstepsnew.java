package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class loginstepsnew {




    public class LoginSteps {

        WebDriver driver;

        @Given("user is on the OrangeHRM login page")
        public void user_is_on_the_login_page() {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/");
        }

        @When("user enters username {string} and password {string}")
        public void user_enters_credentials(String username, String password) {
            driver.findElement(By.name("username")).clear();
            driver.findElement(By.name("username")).sendKeys(username);

            driver.findElement(By.name("password")).clear();
            driver.findElement(By.name("password")).sendKeys(password);
        }

        @When("clicks the login button")
        public void clicks_login_button() {
            driver.findElement(By.cssSelector("button[type='submit']")).click();
        }

        @Then("user should be redirected to the dashboard")
        public void user_should_be_redirected_to_dashboard() {
            boolean dashboardDisplayed = driver.getCurrentUrl().contains("/dashboard");
            Assert.assertTrue(dashboardDisplayed, "Dashboard not displayed. Current URL: " + driver.getCurrentUrl());
            driver.quit();
        }

        @Then("an error message {string} should be displayed")
        public void error_message_should_be_displayed(String expectedMsg) {
            String actualMsg = driver.findElement(By.cssSelector("p.oxd-text.oxd-text--p.oxd-alert-content-text")).getText();
            Assert.assertEquals(actualMsg, expectedMsg, "Error message mismatch!");
            driver.quit();
        }

        @Then("an error message {string} should be displayed below the fields")
        public void error_message_should_be_displayed_below_the_fields(String expectedMsg) {
            String actualMsg = driver.findElement(By.cssSelector("span.oxd-input-field-error-message")).getText();
            Assert.assertEquals(actualMsg, expectedMsg, "Validation message mismatch!");
            driver.quit();
        }

        @Then("an error message {string} should be displayed for the password field")
        public void error_message_for_password_field(String expectedMsg) {
            String actualMsg = driver.findElement(By.xpath("//input[@name='password']/following::span[1]")).getText();
            Assert.assertEquals(actualMsg, expectedMsg);
            driver.quit();
        }

        @Then("an error message {string} should be displayed for the username field")
        public void error_message_for_username_field(String expectedMsg) {
            String actualMsg = driver.findElement(By.xpath("//input[@name='username']/following::span[1]")).getText();
            Assert.assertEquals(actualMsg, expectedMsg);
            driver.quit();
        }
    }

}
