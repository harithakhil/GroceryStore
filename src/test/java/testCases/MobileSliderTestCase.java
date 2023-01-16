package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.MobileSliderPage;

public class MobileSliderTestCase extends BaseClass {
	
	LoginPage lp;
	MobileSliderPage msp;
	
  @Test(priority = 1,description = "verification of text mobile slider",groups = {"RegressionTest"})
  public void verifyTextOfMobileSlider() {
	  
	  lp=new LoginPage(driver);
	  msp=new MobileSliderPage(driver);
	  lp.presteps();
	  
	  String actualMobileSliderText=msp.getTextOfMobileSlider();
	  Assert.assertEquals(actualMobileSliderText, Constant.EXPECTED_MOBILE_SLIDER_TEXT,"actualtext and expected text is not same");
	  
  }
  
  @Test(priority = 2,description = "verify if the uploaded image is displayed")
  public void verifyFirstImageIsDisplayedOrNot() {
	  
	  lp=new LoginPage(driver);
	  msp=new MobileSliderPage(driver);
	  lp.presteps();
	  msp.clickOnMobileSlider();
	  boolean actualFirstImageDisplay=msp.isFirstImageDisplayed();
	  boolean expectedFirstImageDisplay=true;
	  Assert.assertEquals(actualFirstImageDisplay, expectedFirstImageDisplay,"first image is not displayed");
	  
  }
  
  @Test(priority = 3,description = "verify the image status is active or not")
  public void verifyFirstImageStatusIsActiveOrNot() {
	  
	  lp=new LoginPage(driver);
	  msp=new MobileSliderPage(driver);
	  lp.presteps();
	  msp.clickOnMobileSlider();
	  String actualStatus=msp.IsStatusActive();
	  Assert.assertEquals(actualStatus, Constant.EXPECTED_FIRST_IMAGE_STATUS,"Status is not as per expectation");
	  
  }
}
