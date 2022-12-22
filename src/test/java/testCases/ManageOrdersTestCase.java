package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageOrdersPage;

public class ManageOrdersTestCase extends BaseClass{
	
	LoginPage lp;
	ManageOrdersPage mop;
	
  @Test(groups= {"SmokeTest"})
  public void verifyTheSearchOfExistingOrder() {
	  lp=new LoginPage(driver);
	  mop=new ManageOrdersPage(driver);
	  lp.presteps();
	  
	  mop.clickOnManageOrders();
	  mop.searchAnOrder();
	  
	  String actualOrderList=mop.getTextOfSearchResultOfOrderId();
	  String expectedOrderList="100";
	  Assert.assertEquals(actualOrderList, expectedOrderList,"invalid result");
  }
  
  @Test
  public void verifyTheChangeDeliveryDateOfSearchedOrder() throws InterruptedException {
	  lp=new LoginPage(driver);
	  mop=new ManageOrdersPage(driver);
	  lp.presteps();
	  
	  mop.clickOnManageOrders();
	  mop.searchAnOrder();
	  mop.changeDeliveryDateOfSearchedOrder();
	  
	  String actualAlertDeliveryMsg=mop.getTextAlertOfChangeDeliveryDate();
	  System.out.println(actualAlertDeliveryMsg);
	  Assert.assertEquals(actualAlertDeliveryMsg, Constant.EXPECTED_DELIVERY_ALERT_MSG,"invalid result");
  }
  
  @Test
  public void verifyTheSearchOfNonExistingOrder() {
	  lp=new LoginPage(driver);
	  mop=new ManageOrdersPage(driver);
	  lp.presteps();
	  
	  mop.clickOnManageOrders();
	  mop.searchAnUnauthorizedOrder();
	  
	  String actualOrderList=mop.getResultOfUnautorizedOrder();
	  Assert.assertEquals(actualOrderList, Constant.EXPECTED_UNAUTHORIZED_SEARCH_RESULT_TEXT,"invalid result");
  }
  
  @Test()
  public void verifyThePaymentModeIsBank() {
	  lp=new LoginPage(driver);
	  mop=new ManageOrdersPage(driver);
	  lp.presteps();
	  
	  mop.clickOnManageOrders();
	  mop.searchAnOrderUsingPaymentMode();
	  boolean actualValue=mop.paymentModeColumn();
	 // System.out.println(actualValue);
	  boolean expectedValue=true;
	  Assert.assertEquals(actualValue, expectedValue,"invalid result");
  }
  
  @Test
  public void verifyThePaymentModeAndOrderId() {
	  lp=new LoginPage(driver);
	  mop=new ManageOrdersPage(driver);
	  lp.presteps();
	  mop.clickOnManageOrders();
	  mop.searchAnOrder();
	  
	  String actualOrderId=mop.getTextOfSearchedOrderId();
	  String actualPaymentMode=mop.getTextOfSearchedPaymentMode();
	  String expectedOrderId="367";
	  String expectedPaymentMode="COD";
	  SoftAssert softAssert=new SoftAssert();
	  softAssert.assertEquals(actualOrderId, expectedOrderId,"wrong search result of order id");
	  softAssert.assertEquals(actualPaymentMode, expectedPaymentMode,"wrong search result of payment mode");
	  softAssert.assertAll();
  }
  
  @Test()
  public void verifyTheValuesOfStatusInSearchOrder() {
	  lp=new LoginPage(driver);
	  mop=new ManageOrdersPage(driver);
	  lp.presteps();
	  
	  mop.clickOnManageOrders();
	  int actualSize=mop.getStatusOfOrder();
	  int expectedSize=5;
	  Assert.assertEquals(actualSize, expectedSize,"size is different");
	  
  }
}
