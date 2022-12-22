package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class DashboardPage {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	
	public DashboardPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//a[text()='Home']")
	WebElement home;
	
	@FindBy(xpath = "(//p[contains(text(),'Manage Expense')])[1]")
	WebElement manageExpenses;
	
	@FindBy(xpath = "(//p[text()='Manage Users'])[1]")
	WebElement manageUsers;
	
	public String getStyleProperty() {
		return gu.stylePropertyValidation(home, "background-color");
	}
	
	public String getTextOfManageExpenses() {
		return gu.getElementText(manageExpenses);
	}
	
	public String getTextOfManageUsers() {
		return gu.getElementText(manageUsers);
	}
}
