package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class PushNotificationPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public PushNotificationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[text()='Push Notifications']")
	WebElement pushNotification;
	
	@FindBy(xpath = "//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath = "//input[@id='description']")
	WebElement description;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement sendButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;
	
	@FindBy(xpath = "(//span[@class='error'])[1]")
	WebElement mandatorySymbolOfTitle;
	
	@FindBy(xpath = "//h1[contains(text(),'Push Notification')]")
	WebElement pushNotificationTitle;
	
	public void clickOnPushNotification() {
		gu.clickOnElement(pushNotification);
	}

	public void sendTitle(String title1) {
		gu.sendText(title, title1);	
	} 
	
	public void sendDescription(String description1) {
		gu.sendText(description, description1);
	}
	
	public void clickOnSendButton() {
		gu.clickOnElement(sendButton);
	}
	
	public String getTextOfAlertMsg() {
		return gu.getElementText(alertMsg);
	}
	
	public String getBackgorundColorOfAlertMsg() {
		return gu.stylePropertyValidation(alertMsg, "background");
	}
	
	public String getColorOfSendButton() {
		return gu.stylePropertyValidation(sendButton, "color");
	}
	
	public String getColorOfMandatorySymbolOfTitle() {
		return gu.stylePropertyValidation(mandatorySymbolOfTitle, "color");
	}
	
	public String getTextOfPushNotification() {
		return gu.getElementText(pushNotificationTitle);
	}
}
