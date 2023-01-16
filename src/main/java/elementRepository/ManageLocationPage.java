package elementRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class ManageLocationPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public ManageLocationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[contains(text(),'Manage Location')]")
	WebElement manageLocation;
	
	@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[1]/a[1]")
	WebElement newButton;
	
	@FindBy(xpath = "//select[@id='country_id']")
	WebElement country;
	
	@FindBy(xpath = "//select[@id='st_id']")
	WebElement state;
	
	public void clickOnManageLocation() {
		gu.clickOnElement(manageLocation);
	}
	public void clickOnNewButton() {
		gu.clickOnElement(newButton);
	}
	public void selectCountry() {
		gu.selectDropDownByValue(country, "230");
	}
	public void selectState() {
		gu.selectDropDownByVisibleText(state, "Belfast");
	}
	
	public boolean getCountOfActiveStatus() {
		List<WebElement> activeList=driver.findElements(By.xpath("//tbody/tr/td[5]"));
		int size=activeList.size();
		int count=0;
		for(int i=0;i<size;i++) {
			if(activeList.get(i).getText().equals("Active")) {
				count++;
			}
		}
		//System.out.println(count);
		if(count==16) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public String checkSelectedStateIsBelfast() {
		clickOnManageLocation();
		clickOnNewButton();
		selectCountry();
		selectState();
		String selectedOption=gu.FirstSelectedOption(state);
		return selectedOption;
	}

}
