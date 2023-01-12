package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.AdminUsersPage;
import elementRepository.LoginPage;

public class AdminUsersTestCase extends BaseClass {
	LoginPage lp;
	AdminUsersPage aup;
  @Test(priority=1,description="admin user creation",retryAnalyzer=retryTest.RetryAnalyzer.class)
  public void verifyTheAdminUserIsAbleToCreate() {
	  lp=new LoginPage(driver);
	  aup=new AdminUsersPage(driver);
	  lp.presteps();  
	  aup.createAdminUsers();
	  String actualAlert=aup.getTextOfSuccessAlert();
	  Assert.assertEquals(actualAlert, Constant.EXPECTED_ADMIN_USERS_SUCCESS_ALERT_MSG,"admin user not created successfully");
  }
  @Test(priority=2,description = "checking whether an existing user is able to create")
  public void verifyIfTheExistingAdminUserIsAbleToCreateOrNot() {
	  lp=new LoginPage(driver);
	  aup=new AdminUsersPage(driver);
	  lp.presteps();  
	  aup.createExistingAdminUsers();
	  
	  String actualAlert=aup.getTextOfUnSuccessAlert();
	  Assert.assertEquals(actualAlert, Constant.EXPECTED_ADMIN_USERS_UNSUCCESS_ALERT_MSG,"admin user created successfully");
  }
  @Test(priority = 3,description = "search of an existing admin user")
  public void verifyTheSearchOfExistingAdminUser() {
	  lp=new LoginPage(driver);
	  aup=new AdminUsersPage(driver);
	  lp.presteps();  
	  aup.searchExistingUsers();
	  
	  String actualAlert=aup.getTextOfSearchResult();
	  Assert.assertEquals(actualAlert, Constant.EXPECTED_SEARCH_RESULT_TEXT,"incorrect search result");
  }
}
