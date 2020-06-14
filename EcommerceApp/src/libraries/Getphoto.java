package libraries;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Getphoto 
{
	public static void getphoto(WebDriver driver, String name)
	{
		LocalDateTime ldt=LocalDateTime.now();
		String date = ldt.toString().replace(":", "-");
		TakesScreenshot t=(TakesScreenshot)driver;
		File srcFILE = t.getScreenshotAs(OutputType.FILE);
		File destFILE= new File(IAutoConstants.IMAGE_PATH+date+name+".png");
		 
		
		try {
			
			FileUtils.copyFile(srcFILE, destFILE);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
