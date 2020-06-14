package libraries;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebActionUtil 
{
	public WebDriver driver;
	long ETO;
	WebDriverWait wait;
	public WebActionUtil(WebDriver driver,Long ETO) {
		
		this.driver=driver;
		wait=new WebDriverWait(driver, ETO);
		this.ETO=ETO;
	}
	public void clickOnElement(WebElement target)
	{
		wait.until(ExpectedConditions.elementToBeClickable(target));
		target.click();
	}
	public void enterKeys(WebElement target,String keysToSend)
	{
		wait.until(ExpectedConditions.visibilityOf(target));
		target.sendKeys(keysToSend);
	}
	
	public void selectDropdownList(WebElement target, String text)
	{
		Select select=new Select(target);
		select.selectByVisibleText(text);
	}
	public void mouseHover(WebElement target)
	{
		Actions action=new Actions(driver);
		action.moveToElement(target).perform();
	}
	public void scrollTillElement(int x, int y)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy("+x+","+y+");");
	}
}
