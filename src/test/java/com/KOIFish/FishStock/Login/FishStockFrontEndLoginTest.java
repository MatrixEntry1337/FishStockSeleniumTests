package com.KOIFish.FishStock.Login;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Ignore
public class FishStockFrontEndLoginTest {

	private static WebDriver driver;
	private final String loginPageUrl = "http://35.166.23.212:8080/FishStock/#!/app/login";
	private final String usernameTextBoxName = "username", passwordTextBoxName = "password",
			loginButtonId = "submitButton", errorMessageId = "errorMessage";

	private FishStockLoginPage page;
	
	static {
		String PATH_GECKO_DRIVER="/opt/geckodriver";
		System.setProperty("webdriver.gecko.driver", PATH_GECKO_DRIVER);
	}

	@Before
	public static void prepareDriver() {
		//driver = new JBrowserDriver();
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@After
	public static void shutdownDriver() {
		driver.quit();
	}

	@Given("^I am on the main page$")
	public void i_am_on_the_main_page() {
		page = new FishStockLoginPage(driver, usernameTextBoxName, passwordTextBoxName, loginButtonId, errorMessageId);
		page.goToLoginPage(loginPageUrl);
	}

	@Given("^login and password fields exist$")
	public void login_and_password_fields_exist() {
		assertTrue(page.isUsernameTextBoxThere());
		assertTrue(page.isPasswordTextBoxThere());
	}

	@Given("^login button exists$")
	public void login_button_exists() {
		assertTrue(page.isLoginButtonThere());
	}

	@When("^I input \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_input_and(String username, String password) {
		page.enterUsername(username);
		page.enterPassword(password);
	}

	@When("^and click the login button$")
	public void and_click_the_login_button() {
		page.clickLoginButton();
	}

	@Then("^I gain access to the main page$")
	public void i_gain_access_to_the_main_page() {
		assertTrue(page.isLoggedIn());
		assertFalse(page.isShowingError());
	}

	@When("^I input \"([^\"]*)\" and/or \"([^\"]*)\"$")
	public void i_input_and_or(String username, String password) {
		page.enterUsername(username);
		page.enterPassword(password);
	}

	@When("^click the login button$")
	public void click_the_login_button() {
		page.clickLoginButton();
	}

	@Then("^I get an error message$")
	public void i_get_an_error_message() {
		assertFalse(page.isLoggedIn());
		assertTrue(page.isShowingError());
	}

}
