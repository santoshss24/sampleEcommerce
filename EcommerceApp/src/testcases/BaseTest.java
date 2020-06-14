package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import Pages.Homepage;
import Pages.Loginpage;
import libraries.Getphoto;
import libraries.IAutoConstants;
import libraries.WebActionUtil;

public class BaseTest implements IAutoConstants
{
	public WebDriver driver;
	public WebActionUtil webActionUtil;
	
	@Parameters({"browserName","appUrl","ITO","ETO"})
	@BeforeClass
	public void launchApp(@Optional(BROWSER_NAME)String browserName,
							@Optional(APP_URL)String appUrl,
							@Optional(ITO)String ITO,
							@Optional(ETO)String ETO)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver=new ChromeDriver(options);
		}
		else if (browserName.equalsIgnoreCase("firefox")) 
		{
			
			System.setProperty(FIREFOX_KEY,FIREFOX_VALUE);
			FirefoxOptions options=new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled",false);
			}
			else
			{
				throw new IllegalArgumentException(browserName+"Not supported");
			}
				
			driver.manage().window().maximize();
			Long implicit = Long.parseLong(ITO);
			driver.manage().timeouts().implicitlyWait(implicit, TimeUnit.SECONDS);
			driver.get(APP_URL);
			Long explicit= Long.parseLong(ETO);
			webActionUtil =new WebActionUtil(driver, explicit);
			}
	
		@Parameters({"un","pwd"})
		@BeforeMethod
		public void loginToApp(@Optional(USERNAME)String un,@Optional(PASSWORD)String pwd)
		{
			Loginpage login=new Loginpage(driver, webActionUtil);
			login.login(un, pwd);
		}
		
		@AfterMethod
		public void logoutFromApp(ITestResult result)
		{
			if (result.getStatus()==1) {
				Getphoto.getphoto(driver, result.getName());
			}
			Homepage home=new Homepage(driver, webActionUtil);
			home.clickOnlogout();
		}
			
		@AfterClass(alwaysRun=true)
		public void closeApp()
		{
			driver.quit();
		}

}	

