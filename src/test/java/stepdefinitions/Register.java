package stepdefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import Factory.DriverFactory;
import Pages.HomePage;
import Pages.RegisterPage;
import Utilities.UtilesFiles;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;



public class Register {

	WebDriver driver;
	HomePage  homepage;
	RegisterPage registerpage;
	@Given("user use given browser")
	public void user_use_given_browser() {

		driver=DriverFactory.getDriver();
		homepage = new HomePage(driver);
		homepage.myAccount();
		homepage.registerOption();
	}

	@When("a user enters all required information")
	public void a_user_enters_all_required_information(DataTable dataTable) {

		Map<String, String>  dataMap =dataTable.asMap(String.class,String.class);

		registerpage = new RegisterPage(driver);
		registerpage.firstName(dataMap.get("FirstName"));
		registerpage.lastName(dataMap.get("LastName"));
		registerpage.EmailId(UtilesFiles.randaemailid());
		registerpage.telphone(dataMap.get("Telphone"));
		registerpage.Password(dataMap.get("Password"));
		registerpage.Confirmpassword(dataMap.get("confirmPassword"));

	}
	
	@When("a user enters all required information with existing emailID")
	public void a_user_enters_all_required_information_with_existing_email_id(DataTable dataTable) {
	    
	Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
	registerpage = new RegisterPage(driver);
	registerpage.firstName(dataMap.get("FirstName"));
	registerpage.lastName(dataMap.get("LastName"));
	registerpage.EmailId(dataMap.get("EmailId"));
	registerpage.telphone(dataMap.get("Telphone"));
	registerpage.Password(dataMap.get("Password"));
	registerpage.Confirmpassword(dataMap.get("confirmPassword"));
	}
	

	@And("selects Privcy policy.")
	public void selects_privcy_policy() {
		registerpage = new RegisterPage(driver);
		registerpage.polycyagree();

	}

	@And("click on continue button")
	public void click_on_continue_button() {
		registerpage = new RegisterPage(driver);
		registerpage.Continuebtn();

	}

	@Then("the successful creation of an account")
	public void the_successful_creation_of_an_account() {
		registerpage = new RegisterPage(driver);
		Assert.assertTrue(registerpage.accountCreated().contains("Congratulations"));
	}

	@Then("verify waring message displayed")
	public void verify_waring_message_displayed() {

		registerpage = new RegisterPage(driver);
		Assert.assertTrue(registerpage.AccountExist().contains("Warning: E-Mail Address is already registered!"));
	}


}
