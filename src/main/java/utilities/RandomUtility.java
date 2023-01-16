package utilities;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class RandomUtility {
	static Faker faker;
	public void randomUserNames(WebElement element) {
		faker=new Faker();
		String userName=faker.name().username();
		element.sendKeys(userName);
	}
	
	public void randomNames(WebElement element) {
		faker=new Faker();
		String name=faker.name().name();
		element.sendKeys(name);
	}
	
	public void randomFullName(WebElement element) {
		faker=new Faker();
		String fullName=faker.name().fullName();
		element.sendKeys(fullName);
	}
	
	public void randomFirstName(WebElement element) {
		faker=new Faker();
		String firstName=faker.name().firstName();
		element.sendKeys(firstName);
	}
	
	public void randomLastName(WebElement element) {
		faker=new Faker();
		String lastName=faker.name().lastName();
		element.sendKeys(lastName);
	}
	
	public void randomNameWithMiddle(WebElement element) {
		faker=new Faker();
		String nameWithMiddle=faker.name().nameWithMiddle();
		element.sendKeys(nameWithMiddle);
	}

	public void randomBloodGroup(WebElement element) {
		faker=new Faker();
		String bloodGroup=faker.name().bloodGroup();
		element.sendKeys(bloodGroup);
	}
}
