package elementRepository;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;
import utilities.Synchronization;

public class ManageOrdersPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	Synchronization syn=new Synchronization();
	
	public ManageOrdersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//p[contains(text(),'Manage Orders')]")
	WebElement manageOrders;
	
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement firstSearchButton;
	
	@FindBy(xpath = "//input[@id='od']")
	WebElement orderId;
	
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement secondSearchButton;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement searchResultOfOrderId;
	
	@FindBy(xpath = "//a[contains(text(),'Change Delivery Date')]")
	WebElement changeDeliveryDateOfSearchedOrder;
	
	@FindBy(xpath = "//input[@class='jquery-datepicker__input datepicker1']")
	WebElement deliveryDate;
	
	@FindBy(xpath = "//input[@id='basicExample']")
	WebElement fromTime;
	
	@FindBy(xpath = "//input[@id='basicExample1']")
	WebElement toTime;
	
	@FindBy(xpath = "(//button[@class='btn btn-info'])[2]")
	WebElement updateButton;
	
	@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]")
	WebElement deliveryDateAlert;
	
	@FindBy(xpath = "//center[contains(text(),'.........RESULT NOT FOUND.......')]")
	WebElement resultNotFound;
	
	@FindBy(xpath = "//select[@id='pt']")
	WebElement paymentMode;
	
	@FindBy(xpath = "//th[contains(text(),'Order Id')]")
	WebElement scrollIntoOrderId;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")
	WebElement validateOrderId;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]")
	WebElement validatePaymentMode;
	
	@FindBy(xpath = "//select[@id='st']")
	WebElement status;
	
	public void clickOnManageOrders() {
		gu.clickOnElement(manageOrders);
	}
	public void clickOnFirstSearchButton() {
		gu.clickOnElement(firstSearchButton);
	}
	public void sendOrderId(String id) {
		gu.sendText(orderId, id);
	}
	public void clickOnSecondSearchButton() {
		gu.clickOnElement(secondSearchButton);
	}
	public String getTextOfSearchResultOfOrderId() {
		return gu.getElementText(searchResultOfOrderId);
	}
	
	public void clickOnChangeDeliveryDateOfSearchedOrder() throws InterruptedException {
		gu.mediumDelay(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", changeDeliveryDateOfSearchedOrder);
		syn.elementIsToBeClickable(driver, "//a[contains(text(),'Change Delivery Date')]");
		js.executeScript("arguments[0].click();", changeDeliveryDateOfSearchedOrder);
		
		
	}
	public void sendDeliveryDate(String date) {
		gu.sendText(deliveryDate, date);
	}
	public void sendFromTime(String fTime) {
		fromTime.clear();
		gu.sendText(fromTime, fTime);
	}
	public void sendToTime(String TTime) {
		toTime.clear();
		gu.sendText(toTime, TTime);
	}
	
	public void clickOnUpdateButton() throws InterruptedException {
		gu.mediumDelay(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", updateButton);
		js.executeScript("arguments[0].click();", updateButton);
	}
	public String getTextAlertOfChangeDeliveryDate() {
		return gu.getElementText(deliveryDateAlert);
	}
	public void searchAnOrder() {
		clickOnFirstSearchButton();
		sendOrderId("325");
		clickOnSecondSearchButton();
		gu.scrollToTheElement(validateOrderId, driver);
	}
	public void changeDeliveryDateOfSearchedOrder() throws InterruptedException {
		clickOnChangeDeliveryDateOfSearchedOrder();
		sendDeliveryDate("18122022");
		sendFromTime("10.00am");
		sendToTime("11:00am");
		clickOnUpdateButton();
	}
	public void searchAnUnauthorizedOrder() {
		clickOnFirstSearchButton();
		sendOrderId("1000");
		clickOnSecondSearchButton();
	}
	public String getResultOfUnautorizedOrder() {
		return gu.getElementText(resultNotFound);
	}
	
	public void selectPaymentMode() {
		gu.selectDropDownByIndex(paymentMode, 2);
	}
	
	public void searchAnOrderUsingPaymentMode() {
		clickOnFirstSearchButton();
		selectPaymentMode();
		clickOnSecondSearchButton();
		gu.scrollToTheElement(scrollIntoOrderId, driver);
	}
	

	public boolean paymentModeColumn() {
		String str="Bank";
		boolean allAreSame=true;
		List<WebElement> paymentList=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[5]"));
		for(WebElement element:paymentList) {
			if(!element.getText().equals(str)) {
				return false;
			}
		}
		return allAreSame;
	}
	
	public void validationOfPaymentModeAndOrderId() {
		clickOnFirstSearchButton();
		sendOrderId("325");
		clickOnSecondSearchButton();
	}
	public String getTextOfSearchedOrderId() {
		return gu.getElementText(validateOrderId);
	}
	
	public String getTextOfSearchedPaymentMode() {
		return gu.getElementText(validatePaymentMode);
	}
	
	public int getStatusOfOrder() {
		clickOnFirstSearchButton();
		Select select=new Select(status);
		List<WebElement> list=select.getOptions();
		int size=list.size();
		return size;
		//System.out.println(size);
//		for(int i=0;i<size;i++) {
//		System.out.println(list.get(i).getText());
//		}
	}
	
	
	
}
