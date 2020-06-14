package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import libraries.WebActionUtil;

public class Orderpage extends Basepage 
{
	
//	@FindBy(className="icon-plus")
	
	@FindBy(xpath="//tbody/tr")
	private List<WebElement> productList;
	
	public Orderpage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver, webActionUtil);
	}
	
	public  boolean verifyproductIsDisplayed(String productId)
	{
		for (WebElement product : productList) {
			
			boolean res = product.findElement(By.tagName("a")).getAttribute("href").contains(productId);
			if (res) 
			{
				return true;	
			}
		}
		return false;
	}

}
