package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;
import utilities.RandomUtility;

public class AdminUsersPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	RandomUtility ru=new RandomUtility();

	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "(//p[text()='Admin Users'])[1]")
	WebElement adminUsers;
	
	@FindBy(xpath = "//a[contains(text(),'New')]")
	WebElement newButton;
	
	@FindBy(xpath = "//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userType;
	
	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[2]")
	WebElement saveButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement successAlertMsg;
	
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement unSuccessAlertMsg;
	
	
	
	@FindBy(xpath = "(//*[contains(text(),'Search')])[1]")
	WebElement searchButton;
	
	@FindBy(xpath = "//input[@id='un']")
	WebElement searchUsername;
	
	@FindBy(xpath = "//select[@id='ut']")
	WebElement selectUserType;
	
	@FindBy(xpath = "(//button[@class='btn btn-block-sm btn-danger'])[1]")
	WebElement clickSearch;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]")
	WebElement usernameVerification;
	
	
	public void clickOnAdminUsers() {
		gu.clickOnElement(adminUsers);
	}
	public void clickOnNewButton() {
		gu.clickOnElement(newButton);
	}
	public void sendUsername() {
		ru.randomUserNames(username);
	}
	public void sendPassword() {
		gu.sendText(password, "anu123");
	}
	public void selectUserType() {
		gu.selectDropDownByValue(userType, "admin");
	}
	public void clickOnSaveButton() {
		gu.clickOnElement(saveButton);
	}
	public String getTextOfSuccessAlert() {
		return gu.getElementText(successAlertMsg);
	}
	public String getTextOfUnSuccessAlert() {
		return gu.getElementText(unSuccessAlertMsg);
	}
	
	
	public void clickOnSearchButton() {
		gu.clickOnElement(searchButton);
	}
	public void sendExistingUsername() {
		gu.sendText(searchUsername, "ammu");
	}
	public void selectExistingUserType() {
		gu.selectDropDownByValue(selectUserType, "admin");
	}
	public void clickOnSecondSearchButton() {
		gu.clickOnElement(clickSearch);
	}
	public String getTextOfSearchResult() {
		return gu.getElementText(usernameVerification);
	}
	
	
	public void createAdminUsers() {
		clickOnAdminUsers();
		clickOnNewButton();
		sendUsername();
		sendPassword();
		selectUserType();
		clickOnSaveButton();	
	}
	public void createExistingAdminUsers() {
		clickOnAdminUsers();
		clickOnNewButton();
		gu.sendText(username, "Meenu");
		sendPassword();
		selectUserType();
		clickOnSaveButton();	
	}
	public void searchExistingUsers() {
		clickOnAdminUsers();
		clickOnSearchButton();
		sendExistingUsername();
		selectExistingUserType();
		clickOnSecondSearchButton();
	}
	
	

}
