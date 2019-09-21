package StepDefination;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStep {
	WebDriver driver;

	@Given("Chrome is Opened & Login Page is displayed")
	public void chrome_is_Opened_Login_Page_is_displayed() {
		// Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://127.0.0.1:8080/htmldb");

	}

	@When("User enters {string} & {string}")
	public void user_enters_userName_Password(String username, String password) {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@type='password']")).sendKeys(password);

	}

	@When("Click on Login button")
	public void click_on_Login_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@type='BUTTON']")).click();

	}

	@Then("Home Page Should Display")
	public void home_Page_Should_Display() {
		// Write code here that turns the phrase above into concrete actions
		assertEquals("Login Failed", "Oracle", driver.getTitle());
	}

	@And("Click on Administration link")
	public void click_on_Administration_link() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.linkText("Administration")).click();
	}

	@And("Click on Database Users link")
	public void click_on_Database_Users_link() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@title='Database Users']")).click();
	}

	@And("Click on Create user button")
	public void click_on_Create_User_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//*[@value='Create >']")).click();
	}

	/**
	 * @When("User enters Username & password & confirmPassword") public void
	 * user_enters_Username_password_confirmPassword() { // Write code here that
	 * turns the phrase above into concrete actions
	 * driver.findElement(By.id("P2611_USERNAME")).sendKeys("demo");
	 * driver.findElement(By.id("P2611_PASSWORD")).sendKeys("demo");
	 * driver.findElement(By.id("P2611_CONFIRM_PASSWORD")).sendKeys("demo"); }
	 */

	@When("User enters following details")
	public void user_enters_following_details(io.cucumber.datatable.DataTable dataTable) {

		/* List<Map<String, String>> data = dataTable.asMaps(); */
		List<List<String>> data = dataTable.asLists();

		/*
		 * * driver.findElement(By.id("P2611_USERNAME")).sendKeys(data.get(0).get(
		 * "Username"));
		 * driver.findElement(By.id("P2611_PASSWORD")).sendKeys(data.get(0).get(
		 * "password"));
		 * driver.findElement(By.id("P2611_CONFIRM_PASSWORD")).sendKeys(data.get(0).get(
		 * "confirmPassword"));
		 */

		driver.findElement(By.id("P2611_USERNAME")).sendKeys(data.get(1).get(0));
		driver.findElement(By.id("P2611_PASSWORD")).sendKeys(data.get(1).get(1));
		driver.findElement(By.id("P2611_CONFIRM_PASSWORD")).sendKeys(data.get(1).get(2));
	}

	@And("Click on Create button")
	public void click_on_Create_button() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//input[@value='Create']")).click();
	}

	@Then("User Created Should Display")
	public void user_Created_Should_Display() {
		// Write code here that turns the phrase above into concrete actions
		String text = driver.findElement(By.xpath("//div[@class='htmldbSuccessMessage']")).getText();
		assertEquals("User Created.", text);
	}
}
