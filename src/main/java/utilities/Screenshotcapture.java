package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshotcapture {
	
	public void Screenshotcapturefunc(WebDriver driver, String name) throws IOException {

		TakesScreenshot scrShot = (TakesScreenshot) driver; //Convert web driver object to TakeScreenshot
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //Call getScreenshotAs method to create image file

		File f1 = new File(System.getProperty("user.dir") + "\\ScreenShots");  //path to store screenshot
		if (!f1.exists()) {
			f1.mkdirs();
		}

		File finalDestination = new File(System.getProperty("user.dir") + "\\ScreenShots\\" + name + ".png"); //Move image file to new destination
		FileHandler.copy(screenShot, finalDestination);  //Copy file at destination
	}


}
