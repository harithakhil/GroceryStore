package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;

public class LoginTestCase extends BaseClass {
  
	LoginPage lp;
	List<String>loginList;
	@Test(priority =1,description="login using normal methods")
	public void verifyLoggedUser() {
		lp=new LoginPage(driver);
		lp.presteps();
		
		String expectedProfileName=Constant.EXPECTED_PROFILE_NAME;
		String actualProfileName=lp.profileVerification();
		Assert.assertEquals(actualProfileName, expectedProfileName,Constant.LOGIN_ERROR);
	}
	
	@Test(priority=2,description="Login using data provider",dataProvider="data")
	public void verifyLoggedUser(String username,String password) {
		lp=new LoginPage(driver);
		//lp.presteps();
		lp.getUserName(username);
		lp.getPassWord(password);
		lp.clickSignin();
		
		boolean actualAlert=lp.alertMsg();
		Assert.assertTrue(actualAlert,"login successful");
	}
	
	@Test(priority=4,description="verification of remember checkbox is displayed")
	public void verifyRememberCheckBoxIsDisplayedOrNot() {
		lp=new LoginPage(driver);
		lp.getUserName("admin");
		lp.getPassWord("admin");
		
		boolean actualCheckBoxValue=lp.rememberMeIsSelected();
		boolean expectedCheckBoxValue=false;
		Assert.assertEquals(actualCheckBoxValue, expectedCheckBoxValue,"remember me checkbox is checked");
	}
	
	
	
	@Test(priority=5,description="profile style validation")
	public void profileStyleValidation() {
		lp=new LoginPage(driver);
		lp.presteps();
		
		
		String profileColor=lp.styleProperty();
		String expectedProfileColor=Constant.ADMIN_COLOR_PROPERTY;
		Assert.assertEquals(profileColor, expectedProfileColor,Constant.PROFILE_STYLE_ERROR);
		
	}
	@DataProvider(name="data")
	public Object[][] getUserData(){
		return new Object[][] {
			{ "admin5", "admin" }, { "admin", "admin4" }, {"admin1", "admin2"}, };

		}
	
	@Test(priority=3,description="login by using excel read")
	public void verifyTheLoginUsingExcelRead() {
		lp=new LoginPage(driver);
		loginList=lp.getLoginDetails();
		lp.loginCredentials(loginList.get(0), loginList.get(1));
		
		String expectedProfileName=Constant.EXPECTED_PROFILE_NAME;
		String actualProfileName=lp.profileVerification();
		Assert.assertEquals(actualProfileName, expectedProfileName,Constant.LOGIN_ERROR);
	}
	
	
	
		
}
