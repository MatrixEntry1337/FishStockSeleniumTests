package com.KOIFish.FishStock.Login;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FishStockLoginPage {
	private WebDriver driver;
	private String usernameTextBoxName, passwordTextBoxName, loginButtonId, errorMessageId;
	private boolean onLoginPage = false;
	
	
	public FishStockLoginPage(WebDriver driver, String usernameTextBoxName, String passwordTextBoxName,
			String loginButtonId, String errorMessageId) {
		super();
		this.driver = driver;
		this.usernameTextBoxName = usernameTextBoxName;
		this.passwordTextBoxName = passwordTextBoxName;
		this.loginButtonId = loginButtonId;
		this.errorMessageId = errorMessageId;
	}


	public void goToLoginPage(String url) { 
		driver.get(url);
		onLoginPage = true;
	}
	
	
	public boolean isUsernameTextBoxThere() {
		return !onLoginPage ? false : (driver.findElements(By.name(usernameTextBoxName)).size() > 0 ? true : false);
	}
	
	public boolean isPasswordTextBoxThere() {
		return !onLoginPage ? false : (driver.findElements(By.name(passwordTextBoxName)).size() > 0 ? true : false);
	}
	
	public boolean isLoginButtonThere(){
		return !onLoginPage ? false : (driver.findElements(By.id(loginButtonId)).size() > 0 ? true : false);
	}
	
	public void enterUsername(String username) {
		if (!isUsernameTextBoxThere()) { return; }
		WebElement element = driver.findElement(By.name(usernameTextBoxName));
		element.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		if (!isPasswordTextBoxThere()) { return; }
		WebElement element = driver.findElement(By.name(passwordTextBoxName));
		element.sendKeys(password);
	}
	
	public void clickLoginButton() {
		if (!isLoginButtonThere()) { return; }
		WebElement element = driver.findElement(By.id(loginButtonId));
		element.click();
	}
	
	public boolean isLoggedIn() {
		return driver.findElements(By.id(loginButtonId)).isEmpty();
	}
	
	public boolean isShowingError() {
		return driver.findElements(By.id(errorMessageId)).size() == 0 ? false : driver.findElement(By.id(errorMessageId)).isDisplayed();
	}
	
}
