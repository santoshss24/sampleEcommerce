package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import libraries.WebActionUtil;

public class Loginpage extends Basepage 
{
	@FindBy(partialLinkText="Sign in")
	public WebElement signInButton;
	
	@FindBy(id="email")
	public WebElement emailTb;
	
	@FindBy(id="passwd")
	public WebElement passwordTb;
	
	@FindBy(id="SubmitLogin")
	public WebElement logInButton;
	
	public Loginpage(WebDriver driver,WebActionUtil webActionUtil) {
		
		super(driver, webActionUtil);
	}
	public void login(String un, String pwd)
	{
		webActionUtil.clickOnElement(signInButton);
		webActionUtil.enterKeys(emailTb,un);
		webActionUtil.enterKeys(passwordTb, pwd);
		webActionUtil.clickOnElement(logInButton);
	}

}
