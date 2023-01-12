package testCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;



import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageLocationPage;

public class ManageLocationTestCase extends BaseClass {
	
	LoginPage lp;
	ManageLocationPage mlp;
	
  @Test(priority = 1,description = "verification of the active status count")
  public void verifyTheCountOfActiveStatus() {
	  lp=new LoginPage(driver);
	  mlp=new ManageLocationPage(driver);
	  lp.presteps();
	  mlp.clickOnManageLocation();
	  boolean value=mlp.getCountOfActiveStatus();
	  Assert.assertTrue(value);
  }
  
  @Test(priority = 2,description = "verification of the selected value")
  public void verifyTheSelectedValueIsBelfast() {
	  lp=new LoginPage(driver);
	  mlp=new ManageLocationPage(driver);
	  lp.presteps();
	  
	  String actualOption=mlp.checkSelectedStateIsBelfast();
	  Assert.assertEquals(actualOption,Constant.EXPECTED_SELECTED_VALUE_TEXT,"selected value is different");
  }
  
}
