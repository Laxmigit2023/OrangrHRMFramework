package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.driver_factory;
import utilities.utilityFetchProperty;

import java.io.IOException;

public class loginPage {
   // static WebDriver driver;

    public static void sitenavigation() throws IOException, InterruptedException {
        // System.setProperty("webdriver.chrome.driver", "E:\\chromeDriver\\chromedriver.exe");
        //  driver = new ChromeDriver();
        // driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        driver_factory.initializeddriver();  //WebDriver driver= new Chromedriver
        driver_factory.getDriver().get(utilityFetchProperty.fetchPropertyValue("url"));
        driver_factory.getDriver().manage().window().maximize();   //driver>> driver_factory.getDriver()
        Thread.sleep(1000);
    }

    public static void loginpage(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        driver_factory.getDriver().findElement(By.xpath("//input[@name='username']")).sendKeys(username);
        driver_factory.getDriver().findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver_factory.getDriver().findElement(By.xpath("//button[@type='submit']")).click();

    }

    public static void homePageNavigation() {
        String actualurl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String expectedurl = driver_factory.getDriver().getCurrentUrl();
        if (actualurl.contentEquals(expectedurl)) {
            System.out.println("Test case is passed");
        } else {
            System.out.println("Test case is failed");
        }
        //  public static void teardown () {
        driver_factory.getDriver().quit();
    }
}


