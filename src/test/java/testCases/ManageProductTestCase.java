package testCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;

public class ManageProductTestCase extends BaseClass {
	
	LoginPage lp;
	ManageProductPage mpp;
	
  
  @Test(priority = 1,description = "veg radio button is selected in product type",groups = {"RegressionTest"})
  public void verifyVegIsSelectedInProductType(){
	  lp=new LoginPage(driver);
	  mpp=new ManageProductPage(driver);
	  lp.presteps();
	  mpp.clickOnManageProductModule();
	  mpp.clickOnNewButton();
	
	  boolean actualDisplay=mpp.productTypeIsSelected();
	  boolean expectedDisplay=true;
	  Assert.assertEquals(actualDisplay,expectedDisplay,"product type is not selected");
  }
  
  @Test(priority = 2,description = "verify image is uploaded")
  public void verifyImageUpload() throws InterruptedException, AWTException{
	  lp=new LoginPage(driver);
	  mpp=new ManageProductPage(driver);
	  lp.presteps();
	  mpp.clickOnManageProductModule();
	  mpp.clickOnNewButton();
	  
	  boolean actualImagePreview=mpp.validateImageUpload();
	  boolean expectedImagePreview=true;
	  Assert.assertEquals(actualImagePreview, expectedImagePreview,"image is not uploaded");
	  
  }
  
  @Test(priority = 3,description = "verify the radio button Yes is selected in stock")
  public void verifyYesIsSelectedInStock(){
	  lp=new LoginPage(driver);
	  mpp=new ManageProductPage(driver);
	  lp.presteps();
	  mpp.clickOnManageProductModule();
	  mpp.clickOnNewButton();
	
	  boolean actualStockDisplay=mpp.stockIsSelected();
	  boolean expectedStockDisplay=true;
	  Assert.assertEquals(actualStockDisplay,expectedStockDisplay,"stock is not selected");
  }
}
