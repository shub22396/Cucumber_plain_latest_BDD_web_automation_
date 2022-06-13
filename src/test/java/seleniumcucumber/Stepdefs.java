package seleniumcucumber;

//import cucumber.api.PendingException;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.When;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.*;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class Stepdefs {
    private String username, authkey;
    private RemoteWebDriver driver;

    @Before
    public void setUp() throws Throwable {

        username = "shubhamr"; //replace with your username
        authkey = ""; //replace with your authkey

        String browser = System.getProperty("browser");

        DesiredCapabilities caps = new DesiredCapabilities();
        
        caps.setCapability("name", "selenium cucumber");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("screenResolution", "1366x768");
        caps.setCapability("record_video", "true");

        driver = new RemoteWebDriver(new URL("http://" + username + ":" + authkey +"@hub.lambdatest.com/wd/hub"), caps);
    }
    @Given("Navigate to the web application")
    public void Navigate_to_the_web_application() throws Throwable {
         driver.get("https://the-internet.herokuapp.com/login");
    }

    @When("enter username and password")
    public void enter_username_and_password() throws Throwable {

        driver.findElement(By.id("username")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Gmail@123");
    }

    @Then("click on submit button")
    public void click_on_submit_button() throws Throwable {
        driver.findElement(By.xpath("/html/body/div[2]/div/div/form/button")).click();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
