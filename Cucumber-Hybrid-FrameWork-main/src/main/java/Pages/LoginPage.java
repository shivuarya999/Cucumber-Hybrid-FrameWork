package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Elementsreuse;


public class LoginPage {


	WebDriver driver;
	public Elementsreuse  elementsReuse;

	public LoginPage(WebDriver driver) {
		this.driver=driver;

		PageFactory.initElements(driver, this);
		elementsReuse = new Elementsreuse(driver);
	}

	@FindBy(xpath="//input[@id='input-email']")
	WebElement email_field;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password_field;
	@FindBy(xpath="//input[@value='Login']")
	WebElement LoginButton;
	@FindBy(linkText ="Edit your account information")
	WebElement verifyAccountTxt;
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	WebElement Waring_msg_verify;



	public void Emailfiled(String EmailTxt ) {
		elementsReuse.typeTextIntoField(email_field, EmailTxt, 30);
//		email_field.sendKeys(EmailTxt);
	}

	public void passwordfield(String passwordTxt) {
//		password_field.sendKeys(passwordTxt);
		elementsReuse.typeTextIntoField(password_field, passwordTxt, 30);
			}

	public void Loginbutton() {
		elementsReuse.clickOnElement(LoginButton, 30);
//		LoginButton.click();
	}
	public boolean VerifyAccountTxt() {
		return verifyAccountTxt.isDisplayed();
	}
	public String WaringMsgValidation() {
		
		return Waring_msg_verify.getText();
		
	}
}
