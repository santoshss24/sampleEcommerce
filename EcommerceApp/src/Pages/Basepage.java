package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import libraries.WebActionUtil;

public class Basepage {
	
	public WebDriver driver;
	public WebActionUtil webActionUtil;
	
	public Basepage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		this.driver=driver;
		this.webActionUtil=webActionUtil;
		PageFactory.initElements(driver, this);
	}

}
