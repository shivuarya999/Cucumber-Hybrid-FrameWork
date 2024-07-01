package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Factory.DriverFactory;
import Hooks.hooks;
import Pages.HomePage;
import Pages.LoginPage;
import Utilities.UtilesFiles;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Login {

	WebDriver driver; 
	HomePage homepage;
	LoginPage loginpage;
	@Given("user navigate and lunch browser")
	public void user_navigate_and_lunch_browser() {

		driver=  DriverFactory.getDriver();
		homepage = new HomePage(driver);
		homepage.myAccount();
		homepage.loginOption();

	}

	@When("^user enter username (.+) into username field$")
	public void user_enter_username_into_username_field(String EmailTxt) {

		loginpage= new LoginPage(driver);
		loginpage.Emailfiled(EmailTxt);
	}

	@And("^user enter password (.+) into password field$")
	public void user_enter_password_into_password_field(String passwordTxt) {
		loginpage= new LoginPage(driver);
		loginpage.passwordfield(passwordTxt);
	}

	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		loginpage= new LoginPage(driver);
		loginpage.Loginbutton();

	}

	@Then("user sucessfull log in")
	public void user_sucessfull_log_in() {
		loginpage= new LoginPage(driver);
		Assert.assertTrue(loginpage.VerifyAccountTxt());

	}


	@When("user enter invalid username {string} into username field")
	public void user_enter_invalid_username_into_username_field(String Invalid_username) {

		loginpage= new LoginPage(driver);
		loginpage.Emailfiled(Invalid_username);
	}

	@Then("user verify warning meassage")
	public void user_verify_warning_meassage() {
		loginpage= new LoginPage(driver);
		Assert.assertTrue(loginpage.WaringMsgValidation().contains("Warning: No match for E-Mail Address and/or Password."));

	}

	@And("user enter invalidpassword {string} into password field")
	public void user_enter_invalidpassword_into_password_field(String invalid_pass) {
		loginpage= new LoginPage(driver);
		loginpage.passwordfield(invalid_pass);

	}


}
