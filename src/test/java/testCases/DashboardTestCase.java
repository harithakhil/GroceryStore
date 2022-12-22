package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.DashboardPage;
import elementRepository.LoginPage;

public class DashboardTestCase extends BaseClass {
	LoginPage lp;
	DashboardPage dp;
	
  @Test
  public void homeStyleValidation() {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  dp=new DashboardPage(driver);
	  
	  String actualBackgroundColor=dp.getStyleProperty();
	  String expectedBackgroundColor=Constant.HOME_BACKGROUND_COLOR;
	  Assert.assertEquals(actualBackgroundColor, expectedBackgroundColor,Constant.HOME_STYLE_ERROR);
  }
  
  @Test
  public void verifyTextOfManageExpenses() {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  dp=new DashboardPage(driver);
	  
	  String actualManageExpensesText=dp.getTextOfManageExpenses();
	  String expectedManageExpensesText=Constant.EXPECTED_MANAGE_EXPENSES_NAME;
	  Assert.assertEquals(actualManageExpensesText, expectedManageExpensesText,Constant.MANAGE_EXPENSES_TEXT_ERROR);
  }
  
  @Test
  public void verifyTextOfManageUsers() {
	  lp=new LoginPage(driver);
	  lp.presteps();
	  dp=new DashboardPage(driver);
	  
	  String actualManageUsersText=dp.getTextOfManageUsers();
	  String expectedManageUsersText=Constant.EXPECTED_MANAGE_USERS_NAME;
	  Assert.assertEquals(actualManageUsersText, expectedManageUsersText,Constant.MANAGE_EXPENSES_USERS_ERROR);
  }
}
