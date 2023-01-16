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
	
  @Test(priority=1,description = "search an existing order", groups= {"SmokeTest"})
  public void verifyTheSearchOfExistingOrder() {
	  lp=new LoginPage(driver);
	  mop=new ManageOrdersPage(driver);
	  lp.presteps();
	  
	  mop.clickOnManageOrders();
	  mop.searchAnOrder();
	  
	  String actualOrderList=mop.getTextOfSearchResultOfOrderId();
	  Assert.assertEquals(actualOrderList, Constant.EXPECTED_ORDER_ID,"invalid result");
  }
  
  @Test(priority = 2,description = "change the delivery date of a searched order")
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
  
  @Test(priority = 3,description = "search of a non existing order")
  public void verifyTheSearchOfNonExistingOrder() {
	  lp=new LoginPage(driver);
	  mop=new ManageOrdersPage(driver);
	  lp.presteps();
	  
	  mop.clickOnManageOrders();
	  mop.searchAnUnauthorizedOrder();
	  
	  String actualOrderList=mop.getResultOfUnautorizedOrder();
	  Assert.assertEquals(actualOrderList, Constant.EXPECTED_UNAUTHORIZED_SEARCH_RESULT_TEXT,"invalid result");
  }
  
  @Test(priority = 4,description = "verify whether the payment mode is bank")
  public void verifyThePaymentModeIsBank() {
	  lp=new LoginPage(driver);
	  mop=new ManageOrdersPage(driver);
	  lp.presteps();
	  
	  mop.clickOnManageOrders();
	  mop.searchAnOrderUsingPaymentMode();
	  boolean actualValue=mop.paymentModeColumn();
	  boolean expectedValue=true;
	  Assert.assertEquals(actualValue, expectedValue,"invalid result");
  }
  
  @Test(priority = 5,description = "verification of payment mode and order id")
  public void verifyThePaymentModeAndOrderId() {
	  lp=new LoginPage(driver);
	  mop=new ManageOrdersPage(driver);
	  lp.presteps();
	  mop.clickOnManageOrders();
	  mop.searchAnOrder();
	  
	  String actualOrderId=mop.getTextOfSearchedOrderId();
	  String actualPaymentMode=mop.getTextOfSearchedPaymentMode();
	  String expectedOrderId=Constant.EXPECTED_ORDER_ID;
	  String expectedPaymentMode=Constant.EXPECTED_PAYMENT_MODE;
	  SoftAssert softAssert=new SoftAssert();
	  softAssert.assertEquals(actualOrderId, expectedOrderId,"wrong search result of order id");
	  softAssert.assertEquals(actualPaymentMode, expectedPaymentMode,"wrong search result of payment mode");
	  softAssert.assertAll();
  }
  
  @Test(priority = 6,description = "verify the status in search order")
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
