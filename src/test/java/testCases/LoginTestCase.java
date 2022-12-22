package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;

public class LoginTestCase extends BaseClass {
  
	LoginPage lp;
	
	@Test
	public void verifyLoggedUser() {
		lp=new LoginPage(driver);
		lp.presteps();
		
		String expectedProfileName=Constant.EXPECTED_PROFILE_NAME;
		String actualProfileName=lp.profileVerification();
		Assert.assertEquals(actualProfileName, expectedProfileName,Constant.LOGIN_ERROR);
	}
	
	@Test
	public void verifyRememberCheckBoxIsDisplayedOrNot() {
		lp=new LoginPage(driver);
		lp.getUserName("admin");
		lp.getPassWord("admin");
		
		boolean actualCheckBoxValue=lp.rememberMeIsSelected();
		boolean expectedCheckBoxValue=false;
		Assert.assertEquals(actualCheckBoxValue, expectedCheckBoxValue,"remember me checkbox is checked");
	}
	
	@Test(description="Login using data provider",dataProvider="data")
	public void verifyLoggedUserDataProvider(String username,String password) {
		lp=new LoginPage(driver);
		//lp.presteps();
		lp.getUserName(username);
		lp.getPassWord(password);
		lp.clickSignin();
		String expectedProfileName=Constant.EXPECTED_PROFILE_NAME;
		String actualProfileName=lp.profileVerification();
		Assert.assertEquals(actualProfileName, expectedProfileName,Constant.LOGIN_ERROR);
	}
	
	@Test
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
			{ "admin", "admin" }, { "admin5", "admin" }, { "admin", "admin4" }, {"admin1", "admin2"}, };

		}
		
}