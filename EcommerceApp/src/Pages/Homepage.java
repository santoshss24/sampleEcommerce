package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import libraries.WebActionUtil;

public class Homepage extends Basepage
{	
	public String xpathForMoreButton="//a[contains(@href,'product=id')]//span[text()='More']";
			
	@FindBy(className="logout")
	private WebElement logoutButton;
	
	@FindBy(linkText="Women")
	private WebElement WomenLink;
	
	@FindBy(xpath="(//a[.='Dresses'])[2]")
	private WebElement DressesLink;
	
	
	@FindBy(xpath="(//a[.='T-shirts'])[2]")
	private WebElement TshirtsLink;
	
	@FindBy(id="selectProductSort")
	private WebElement sortDropDown;
	
	@FindBy(linkText="Grid")
	private WebElement GridView;
	
	@FindBy(linkText="List")
	private WebElement ListView;
	
	
	@FindBy(xpath="//ul[@class=\"product_list grid row\"]/li")
	private List<WebElement> productsList;
	
	//@FindBy()
	//private WebElement moreButton;
	
	
	public Homepage(WebDriver driver, WebActionUtil webActionUtil) {
		super(driver,webActionUtil);
	}
	
	public void clickOnlogout()
	{
		webActionUtil.clickOnElement(logoutButton);
	}
	public void clickonWomenLink()
	{
		webActionUtil.clickOnElement(WomenLink);
	}
	public void clickonDressesLink()
	{
		webActionUtil.clickOnElement(DressesLink);
	}
	public void clickonTshirtsLink()
	{
		webActionUtil.clickOnElement(TshirtsLink);
	}
	
	public void selectSortOption()
	{
		webActionUtil.clickOnElement(sortDropDown);
	}
	
	public void clickonGridView()
	{
		webActionUtil.clickOnElement(GridView);
	}
	
	public void clickonListView()
	{
		webActionUtil.clickOnElement(ListView);
	}
	
	public void selectProduct(String productId)
	{
		for (WebElement product : productsList) 
		{
			WebElement targett = product.findElement(By.tagName("a"));
			if(targett.getAttribute("href").contains(productId))
			{
				webActionUtil.mouseHover(targett);
				break;
			}
		}
	}
	public ProductPage clickOnMoreButton(String productId)
	{
		xpathForMoreButton=xpathForMoreButton.replace("id",productId);
		WebElement target=driver.findElement(By.xpath(xpathForMoreButton));
		webActionUtil.clickOnElement(target);
		return new ProductPage(driver,webActionUtil);
	}
	
	public void scrolling(int x,int y)
	{
		webActionUtil.scrollTillElement(x, y);
	}

}
