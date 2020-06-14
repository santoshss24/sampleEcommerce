package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import libraries.WebActionUtil;

public class ProductPage extends Basepage 
{
	@FindBy(className="icon-plus")
	private WebElement plusButton;
	
	@FindBy(className="icon-minus")
	private WebElement minusButton;
	
	@FindBy(id="group_1")
	private WebElement sizeDropdown;
	
	@FindBy(name="Beige")
	private WebElement Beigecolorbutton;
	
	@FindBy(name="Pink")
	private WebElement PinkcolorButton;
	
	@FindBy(name="Orange")
	private WebElement Orangecolorbutton;
	
	@FindBy(name="White")
	private WebElement WhitecolorButton;
	
	@FindBy(name="Green")
	private WebElement Greencolorbutton;
	
	@FindBy(name="Blue")
	private WebElement BluecolorButton;
	
	@FindBy(name="Submit")
	private WebElement addtocartButton;
	
	@FindBy(className="cross")
	private WebElement closspopup;
	
	@FindBy(xpath="//span[contains(.,'Continue shopping')]")
	private WebElement continueShoppingButton;
	
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedTocheckout;
	
	//span[contains(text(),'Proceed to checkout')]
	
	public ProductPage(WebDriver driver, WebActionUtil webActionUtil) 
	{
		super(driver, webActionUtil);
	}
	
	public void selectSize(String size)
	{
		webActionUtil.selectDropdownList(sizeDropdown, size);
	}
	public void selectcolor(String color)
	{
		color=color.toLowerCase();
		switch (color) {
		case "beige": webActionUtil.clickOnElement(Beigecolorbutton);
						break;
		case "pink" : webActionUtil.clickOnElement(PinkcolorButton);	
						break;
		case "orange": webActionUtil.clickOnElement(Orangecolorbutton);
						break;
		case "white" : webActionUtil.clickOnElement(WhitecolorButton);	
						break;
		case "green": webActionUtil.clickOnElement(Greencolorbutton);
						break;
		case "blue" : webActionUtil.clickOnElement(BluecolorButton);	
						break;
		
		default: Reporter.log("Sorry color not present",true);
		}
	}
	
	public void clickOnPlusButton(int count)
	{
		for (int i = 0; i < count; i++) {
		
			webActionUtil.clickOnElement(plusButton);
		}
		
	}
	public void clickOnMinusButton(int count)
	{
		for (int i = 0; i < count; i++) {
			webActionUtil.clickOnElement(minusButton);
		}
		
	}
	public Orderpage clickOnProceedToCheckout()
	{
		webActionUtil.clickOnElement(proceedTocheckout);
		return new Orderpage(driver, webActionUtil);
	}
	public void clickOnContinueToShopping()
	{
		webActionUtil.clickOnElement(continueShoppingButton);
	}
	public void closePopUp()
	{
		webActionUtil.clickOnElement(closspopup);
	}
	
	public Orderpage clickOnAddToCartButton()
	{
		webActionUtil.clickOnElement(addtocartButton);
		return new Orderpage(driver, webActionUtil);
	}
	public void scrolling(int x,int y)
	{
		webActionUtil.scrollTillElement(x, y);
	}
	

}
