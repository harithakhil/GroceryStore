package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class MobileSliderPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public MobileSliderPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//p[text()='Mobile Slider'])[1]")
	WebElement mobileSlider;
	
	@FindBy(xpath = "//tbody/tr[1]/td[1]/img[1]")
	WebElement firstImage;
	
	@FindBy(xpath = "//tbody/tr[1]/td[2]/a[1]/span[1]")
	WebElement status;
	
	public String getTextOfMobileSlider() {
		return gu.getElementText(mobileSlider);
	}
	public void clickOnMobileSlider() {
		gu.clickOnElement(mobileSlider);
	}
	public boolean isFirstImageDisplayed() {
		return gu.elementIsDisplayed(firstImage);
	}
	
	public String IsStatusActive() {
		return gu.getElementText(status);
	}

}
