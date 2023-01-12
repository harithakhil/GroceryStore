package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileHandling;
import utilities.GeneralUtilities;

public class ManageProductPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	FileHandling fh=new FileHandling();
	
	public ManageProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[contains(text(),'Manage Product')]")
	WebElement manageProduct;
	
	@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/a[1]")
	WebElement newButton;
	
	@FindBy(xpath = "//input[@id='title']")
	WebElement title;
	
	@FindBy(xpath = "//input[@value='Nonveg']")
	WebElement productTypeNonVeg;
	
	@FindBy(xpath = "//input[@id='tag']")
	WebElement tagName;
	
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement category;
	
	@FindBy(xpath = "//select[@id='sub_id']")
	WebElement subCategory;
	
	@FindBy(xpath = "//select[@id='grp_id']")
	WebElement group;
	
	@FindBy(xpath = "//input[@id='purpose1']")
	WebElement priceTypePiece;
	
	@FindBy(xpath = "//select[@id='p_minimum']")
	WebElement minimumPiece;
	
	@FindBy(xpath = "//input[@id='p_max']")
	WebElement maximumQuantity;
	
	@FindBy(xpath = "//input[@id='p_price']")
	WebElement price;
	
	@FindBy(xpath = "//input[@id='p_mrp']")
	WebElement mrp;
	
	@FindBy(xpath = "//input[@id='p_stock']")
	WebElement availableStock;
	
	@FindBy(xpath = "//input[@id='p_pp']")
	WebElement purchasePrice;
	
	@FindBy(xpath = "(//input[@value='yes'])[5]")
	WebElement stockValueYes;
	
	@FindBy(xpath = "//input[@id='main_img']")
	WebElement imageUpload;
	
	@FindBy(xpath = "//input[@id='main_imgs']")
	WebElement subImageUpload;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement saveButton;
	
	@FindBy(xpath = "//body/div[1]/div[1]/div[2]/div[1]/div[1]")
	WebElement alertMsg;
	
	@FindBy(xpath = "//input[@value='Veg']")
	WebElement productTypeVeg;
	
	@FindBy(xpath = "//div[@id='imagePreview']")
	WebElement imagePreview;
	
	public void clickOnManageProductModule() {
		gu.clickOnElement(manageProduct);
	}
	public void clickOnNewButton() {
		gu.clickOnElement(newButton);
	}
	public void sendTitle(String title1) {
		gu.sendText(title, title1);
	}
	public void selectProductType() {
		gu.clickOnElement(productTypeNonVeg);
	}
	public void sendTagName(String tag) {
		gu.sendText(tagName, tag);
	}
	public void selectCategory() {
		gu.selectDropDownByIndex(category, 1);
	}
	public void selectSubCategory() throws InterruptedException {
		gu.mediumDelay(3000);
		gu.selectDropDownByIndex(subCategory, 2);
	}
	public void selectGroup() {
		gu.selectDropDownByIndex(group, 1);
	}
	public void selectPriceType() {
		gu.clickOnElement(priceTypePiece);
	}
	public void selectMinimumPiece() {
		gu.scrollToTheElement(minimumPiece, driver);
		gu.selectDropDownByIndex(minimumPiece, 4);
	}
	public void sendMaximumQuantity(String quantity) {
		gu.sendText(maximumQuantity, quantity);
	}
	public void sendPrice(String price1) {
		gu.sendText(price, price1);
	}
	public void sendMrp(String mrp1) {
		gu.sendText(mrp, mrp1);
	}
	public void sendStockAvailability(String stock) {
		gu.sendText(availableStock, stock);
	}
	public void sendPurchasePrice(String pprice) {
		gu.sendText(purchasePrice, pprice);
		gu.scrollToTheElement(stockValueYes, driver);
	}
	public void imageUpload(String imgPath){
		
		//fh.fileUpload("C:\\Users\\harit\\eclipse-workspace\\GroceryStore\\src\\main\\resources\\Images\\meat_puff.jpg", imageUpload, driver);
		gu.sendText(imageUpload,imgPath);
	}
	public void subImageUpload(String subPath){
		//fh.fileUpload("C:\\Users\\harit\\OneDrive\\Desktop\\Test images\\egg_puff.jpg", subImageUpload, driver);
		gu.sendText(subImageUpload, subPath);
	}
	public void clickOnSaveButton() {
		gu.javaScriptExecutorClick(saveButton, driver);
	}
	public String getTextOfAlertMsg() {
		return gu.getElementText(alertMsg);
	}
	
	public void addProduct() throws InterruptedException{
		sendTitle("Puffs");
		selectProductType();
		sendTagName("puff");
		selectCategory();
		selectSubCategory();
		selectGroup();
		selectPriceType();
		selectMinimumPiece();
		sendMaximumQuantity("100");
		sendPrice("40");
		sendMrp("35");
		sendStockAvailability("200");
		sendPurchasePrice("35");
		imageUpload("C:\\Users\\harit\\OneDrive\\Desktop\\Test images\\meat_puff.jpg");;
		subImageUpload("C:\\Users\\harit\\OneDrive\\Desktop\\Test images\\egg_puff.jpg");
		clickOnSaveButton();
	}
	
	public boolean productTypeIsSelected() {
		return gu.elementIsSelected(productTypeVeg);
	}
	public boolean validateImageUpload() throws InterruptedException, AWTException {
		gu.scrollToTheElement(imageUpload, driver);
		gu.mediumDelay(2000);
		fh.fileUpload("C:\\Users\\harit\\OneDrive\\Desktop\\eclipse-workspace\\GroceryStore\\src\\main\\resources\\Images\\egg_puff.jpg", imageUpload, driver);
		gu.mediumDelay(2000);
		//imageUpload("C:\\Users\\harit\\eclipse-workspace\\GroceryStore\\src\\main\\resources\\Images\\meat_puff.jpg");
		return gu.elementIsDisplayed(imagePreview);
	}
	public boolean stockIsSelected() {
		gu.scrollToTheElement(stockValueYes, driver);
		return gu.elementIsSelected(stockValueYes);
	}
}
