package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.PushNotificationPage;

public class PushNotificationTestCase extends BaseClass {
	LoginPage lp;
	PushNotificationPage pn;
	
  @Test(priority = 1,description = "verify the alert text",groups = {"SanityTest"})
  public void verifyTheAlertText() {
	  lp=new LoginPage(driver);
	  pn=new PushNotificationPage(driver);
	  lp.presteps();
	  
	  pn.clickOnPushNotification();
	  pn.sendTitle("Demo Tile");
	  pn.sendDescription("Demo Description");
	  pn.clickOnSendButton();
	  
	  String actualAlert=pn.getTextOfAlertMsg();
	  Assert.assertEquals(actualAlert, Constant.EXPECTED_ALERT_MSG,"Alert msg is different");
	  
  }
  
  @Test(priority = 2,description = "verify the background color of alert")
  public void verifyTheBackgroundColorOfAlert() {
	  lp=new LoginPage(driver);
	  pn=new PushNotificationPage(driver);
	  lp.presteps();
	  
	  pn.clickOnPushNotification();
	  pn.sendTitle("Demo Tile");
	  pn.sendDescription("Demo Description");
	  pn.clickOnSendButton();
	  
	  String actualAlertColor=pn.getBackgorundColorOfAlertMsg();
	  String extectedAlertColor=Constant.EXPECTED_ALERT_COLOR;
	  Assert.assertEquals(actualAlertColor, extectedAlertColor,"Alert msg background color is different");
	  
  }
  
  @Test(priority = 3,description = "verify the color of send button",groups = {"SanityTest"})
  public void verifyTheColorOfSendButton() {
	  lp=new LoginPage(driver);
	  pn=new PushNotificationPage(driver);
	  lp.presteps();
	  
	  pn.clickOnPushNotification();
	  
	  String actualSendButtonColor=pn.getColorOfSendButton();
	  Assert.assertEquals(actualSendButtonColor, Constant.EXPECTED_SEND_BUTTON_COLOR,"Send Button color is different");
	  
  }
  
  @Test(priority = 4,description = "verify the color of mandatory symbol")
  public void verifyTheColorOfMandatorySymbolOfTitle() {
	  lp=new LoginPage(driver);
	  pn=new PushNotificationPage(driver);
	  lp.presteps();
	  
	  pn.clickOnPushNotification();
	  
	  String actualMandatorySymbolColor=pn.getColorOfMandatorySymbolOfTitle();
	  Assert.assertEquals(actualMandatorySymbolColor, Constant.EXPECTED_MANDATORY_SYMBOL_COLOR,"mandatory symbol color is not as expectation");
	  
  }
  
  @Test(priority = 5,description = "verify the title of push notification")
  public void verifyTheTitleOfPushNotification() {
	  lp=new LoginPage(driver);
	  pn=new PushNotificationPage(driver);
	  lp.presteps();
	  
	  pn.clickOnPushNotification();
	  
	  String actualText=pn.getTextOfPushNotification();
	  Assert.assertEquals(actualText, Constant.EXPECTED_PUSH_NOTIFICATION_TEXT,"push notification text is not as expectation");
	  
  }
  
}
