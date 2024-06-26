package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Elementsreuse;

public class RegisterPage {
	
	 WebDriver driver;
	 public Elementsreuse  elementsReuse;

	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementsReuse = new Elementsreuse(driver);
		}
	
	@FindBy(id="input-firstname") WebElement Firstname;
	@FindBy(id="input-lastname")  WebElement Lastname;
	@FindBy(name="email")  WebElement EmailId;
	@FindBy(id="input-telephone")  WebElement phonenum;
	@FindBy(id="input-password")  WebElement Password;
	@FindBy(id="input-confirm")  WebElement  Confirmpassword;
	@FindBy(xpath="//input[@name='agree']") WebElement policyAgree;
	@FindBy(xpath="//input[@value='Continue']") WebElement conbutton;
	
	@FindBy(xpath="//div[@id='content']/p[1]") WebElement account_created;
	@FindBy(xpath="//div[contains(@class,'alert-danger')]") WebElement Accountexist;
	
	public void firstName(String firstname) {
//		elementsReuse.typeTextIntoField(Firstname, firstname, 30);
		Firstname.sendKeys(firstname);	
	}
	public void lastName(String lastname) {
//		elementsReuse.typeTextIntoField(Lastname, lastname, 30);
		Lastname.sendKeys(lastname);
	}
	public void EmailId(String emailid) {
//		elementsReuse.typeTextIntoField(EmailId, emailid, 30);
		EmailId.sendKeys(emailid);
	}
	public void telphone(String Phonenum) {
//		elementsReuse.typeTextIntoField(phonenum, Phonenum, 30);
		phonenum.sendKeys(Phonenum);
	}
	public void Password(String password) {
//		elementsReuse.typeTextIntoField(Password, password, 30);
		Password.sendKeys(password);
	}
	public void Confirmpassword(String password) {
//		elementsReuse.typeTextIntoField(Confirmpassword, password, 30);
		Confirmpassword.sendKeys(password);
	}
	public void polycyagree() {
//		elementsReuse.clickOnElement(policyAgree, 30);
		policyAgree.click();
	}
	public void Continuebtn() {
//		elementsReuse.clickOnElement(conbutton, 30);
		conbutton.click();
	}
	public String accountCreated() {
		return account_created.getText();
		
	}
	public String AccountExist() {
		return  Accountexist.getText();
	}

}
