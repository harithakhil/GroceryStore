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
	

}
