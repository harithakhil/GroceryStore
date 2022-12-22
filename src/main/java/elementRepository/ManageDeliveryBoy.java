package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageDeliveryBoy {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public ManageDeliveryBoy(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//p[contains(text(),'Manage Delivery Boy')]")
	WebElement manageDeliveryBoy;
	
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[7]/div/a")
	WebElement showDetails;
	
	@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/a[1]")
	WebElement newButton;
	
	@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/a[2]")
	WebElement searchButton;
	
	public void clickOnManageDeliveryBoy() throws InterruptedException {
		gu.clickOnElement(manageDeliveryBoy);
		gu.mediumDelay(3000);
	}

	public String getToolTipShowDetails() {
		return gu.toolTip(showDetails);
	}
	
	public String getStylePropertyOfNewButton() throws InterruptedException {
		clickOnManageDeliveryBoy();
		return gu.stylePropertyValidation(newButton, "border-color");
	}
	
	public boolean IsSearchButtonIsClickable() throws InterruptedException {
		clickOnManageDeliveryBoy();
		return gu.elementIsEnabled(searchButton);
	}
}
