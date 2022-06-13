



Want a powerful and easy to use command line tool for running Selenium tests? <a href="https://github.com/cucumber/cucumber-js">Cucumber</a> might be the option for you. Cucumber provides language-bindings for the powerful browser-driving tool <a href="http://www.seleniumhq.org/docs/" rel="nofollow">Selenium</a>. Its <a href="https://docs.cucumber.io/gherkin/" rel="nofollow">Gherkin</a> language allows you to write your tests in a way that can be easily read by anyone on your team. Cucumber Java integrates easily with the Lambdatest platform, so you can perform tests on a wide variety of OS/Device/Browser combinations, all from one test.
<h3>Let's walk through getting setup.</h3>
<strong>1.</strong> Start be installing <a href="https://maven.apache.org/download.cgi">Maven</a>, a software project management and comprehension tool.

<strong>2.</strong> Create a simple project with Cucumber installed  by running command:
<pre><code>
mvn archetype:generate \
-DarchetypeGroupId=io.cucumber \
-DarchetypeArtifactId=cucumber-archetype \
-DarchetypeVersion=4.2.6.1 \
-DgroupId=seleniumcucumber \
-DartifactId=seleniumcucumber \
-Dpackage=seleniumcucumber \
-Dversion=1.0.0-SNAPSHOT \
-DinteractiveMode=false
</code></pre>
<strong>3.</strong> After changing into the seleniumcucumber directory that was just created, add the following dependency to the pom.xml file:
<pre><code>&lt;dependency&gt;
        &lt;groupId&gt;org.seleniumhq.selenium&lt;/groupId&gt;
        &lt;artifactId&gt;selenium-java&lt;/artifactId&gt;
        &lt;version&gt;3.141.59&lt;/version&gt;
&lt;/dependency&gt;  
</code></pre>
<strong>4.</strong> Create an empty file called <span class="text-java"><code>src/test/resources/seleniumcucumber/todo.feature</code></span> with the following content:

<strong>5.</strong> Edit the file called <span class="text-java"><code>src/test/java/seleniumcucumber/Stepdefs.java</code></span> with the following content:
<pre><code>package seleniumcucumber;

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
        authkey = "CCCCTfelp95y0WKq0MSKORBzWD7xpFGOTv5KlMTZ18qnAcGjId"; //replace with your authkey

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
</code></pre>
<div class="blue-alert">

You’ll need to use your Username and Authkey to run your tests on Lambdatest. To get yours, sign up for a <a 
</div>
<strong>6.</strong> Now you are ready to run your test using the command:
<pre><code>mvn test</code></pre>
As you can probably make out from our test, we visit a small ToDo App example, interact with our page, and use assertions to verify that the changes we've made are actually reflected in our app.

