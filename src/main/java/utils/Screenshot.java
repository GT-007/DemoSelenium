package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	
	
	public static String captureScreenshot(WebDriver driver)
	{
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
	
	
	
	
	
	/*public static String captureScreenshot(WebDriver driver, String screenshotName) {
        String path = "C:/Selenium Projects/Report/screenshots/" + screenshotName + "_" + System.currentTimeMillis() + ".png";
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(path);
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }*/

}
