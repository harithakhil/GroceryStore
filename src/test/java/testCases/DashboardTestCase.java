package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;

public class DashboardTestCase extends BaseClass {
	LoginPage lp;
	DashboardPage dp;
	
  @Test(priority = 1,description = "validating the background color of home")
  public void homeStyleValidation() {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  dp=new DashboardPage(driver);
	  
	  String actualBackgroundColor=dp.getStyleProperty();
	  String expectedBackgroundColor=Constant.HOME_BACKGROUND_COLOR;
	  Assert.assertEquals(actualBackgroundColor, expectedBackgroundColor,Constant.HOME_STYLE_ERROR);
  }
  
  @Test(priority = 2,description = "validate the manage expenses text")
  public void verifyTextOfManageExpenses() {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  dp=new DashboardPage(driver);
	  
	  String actualManageExpensesText=dp.getTextOfManageExpenses();
	  String expectedManageExpensesText=Constant.EXPECTED_MANAGE_EXPENSES_NAME;
	  Assert.assertEquals(actualManageExpensesText, expectedManageExpensesText,Constant.MANAGE_EXPENSES_TEXT_ERROR);
  }
  
  @Test(priority = 3,description = "validate the manage users text")
  public void verifyTextOfManageUsers() {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  dp=new DashboardPage(driver);
	  
	  String actualManageUsersText=dp.getTextOfManageUsers();
	  String expectedManageUsersText=Constant.EXPECTED_MANAGE_USERS_NAME;
	  Assert.assertEquals(actualManageUsersText, expectedManageUsersText,Constant.MANAGE_EXPENSES_USERS_ERROR);
  }
}
