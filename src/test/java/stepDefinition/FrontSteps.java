package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class FrontSteps {
	
	WebDriver driver;
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		driver= new ChromeDriver();
		
	}
	@After
public void after() throws Exception{
		 Thread.sleep(2000);
		  driver.quit();
	}
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
	   driver.get("http://demo.frontaccounting.eu/index.php");
	}

	@When("User enters username as {string} & password as {string} & clicks on login")
	public void user_enters_username_as_password_as_clicks_on_login(String un, String pwd) {
	   driver.findElement(By.className("user_name_entry_field")).clear();
	   driver.findElement(By.className("user_name_entry_field")).sendKeys(un);
	   driver.findElement(By.className("password")).clear();
	   driver.findElement(By.className("password")).sendKeys(pwd);
	   driver.findElement(By.className("SubmitUser")).click();
	   
	}

	@Then("login {string} should happen")
	public void login_should_happen(String status) {
	    if(status.equals("should")){
	    	if(driver.getTitle().equals("Main Menu")) {
	    		System.out.println("Positive Test successful");
	    	}
	    	else {
	    		System.out.println("Positive Test failed");
	    	}
	    }
	    else {
	 	    	if(driver.getTitle().equals("Main Menu")) {
	 	    		System.out.println("Negative Test Failed");
	 	    		Assert.fail("Positive Test Failed");
	 	    	}
	 	    	else {
	 	    		System.out.println("Negative Test failed");
	 	    		Assert.fail("NegativeTest Failed");
	 	    	}
	    	
	    }
	}

}
