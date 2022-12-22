package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class LoginPage {

	WebDriver driver;
	
	GeneralUtilities gu=new GeneralUtilities();

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	WebElement userName;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	WebElement signin;

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement profileName;

	@FindBy(xpath = "//label[contains(text(),'Remember Me')]")
	WebElement rememberCheckBox;

	@FindBy(xpath = "//input[@id='remember']")
	WebElement verificationOfRememberCheckBox;

	public void getUserName(String username) {
		gu.sendText(userName, username);
	}

	public void getPassWord(String passWord) {
		gu.sendText(password, passWord);
	}

	public void clickSignin() {
		gu.clickOnElement(signin);
		
	}
	public boolean rememberMeIsSelected() {
		return gu.elementIsSelected(rememberCheckBox);
	}

	public String profileVerification() {
		return gu.getElementText(profileName);
	}

	public String styleProperty() {
		String color=gu.stylePropertyValidation(profileName, "color");
		return color;
	}
	
	public void presteps() {
		getUserName("admin");
		getPassWord("admin");
		clickSignin();
	}
	

}

