package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoyPage;

public class ManageDeliveryBoyTestCase extends BaseClass {
	
	LoginPage lp;
	ManageDeliveryBoyPage mdb;
	
  @Test(priority=1,description="tool tip test case",groups= {"SmokeTest"})
  public void verifyToolTip() throws InterruptedException {
	  
	  lp=new LoginPage(driver);
	  mdb=new ManageDeliveryBoyPage(driver);
	  
	  lp.presteps();
	  mdb.clickOnManageDeliveryBoy();
	  mdb.getToolTipShowDetails();
	  
	  String actualToolTip=mdb.getToolTipShowDetails();
	  Assert.assertEquals(actualToolTip, Constant.EXPECTED_TOOL_TIP,Constant.TOOL_TIP_ERROR);
	  
	  
  }
  @Test(priority=2,description="new button test case")
  public void verifyStylePropertyOfNewButton() throws InterruptedException {
	  
	  lp=new LoginPage(driver);
	  mdb=new ManageDeliveryBoyPage(driver);
	  lp.presteps();
	  
	  String actualBorderColor=mdb.getStylePropertyOfNewButton();
	  Assert.assertEquals(actualBorderColor, Constant.EXPECTED_NEW_BUTTON_STYLE,Constant.NEW_BUTTON_STYLE_ERROR);
  }
  
  @Test(priority=3,description="search button test case")
  public void verifySearchButtonIsClickable() throws InterruptedException {
	  
	  lp=new LoginPage(driver);
	  mdb=new ManageDeliveryBoyPage(driver);
	  lp.presteps();
	  
	  boolean actualResult=mdb.IsSearchButtonIsClickable();
	  boolean expectedResult=true;
	  Assert.assertEquals(actualResult,expectedResult,"Search button is not clickable" );
  }
}
