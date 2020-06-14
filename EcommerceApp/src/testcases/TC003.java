package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.Homepage;
import Pages.Orderpage;
import Pages.ProductPage;
import libraries.GenericExcelLib;

public class TC003 extends BaseTest
{
	@DataProvider
	public Object[][] getData()
	{
	 return	GenericExcelLib.getDataFromExcelFile(EXCEL_PATH, "TC001");
	}
	
	@Test(dataProvider="getData")
	public void validLogin(String productId, String size, String color) throws InterruptedException
	{
		productId=productId.substring(0, 1);
		Homepage h=new Homepage(driver, webActionUtil);
		h.clickonDressesLink();
		h.selectProduct(productId);
		h.scrolling(0, 500);
		ProductPage productpage=h.clickOnMoreButton(productId);
		productpage.scrolling(0, 300);
		productpage.clickOnPlusButton(3);
		productpage.clickOnMinusButton(1);
		productpage.selectSize(size);
		productpage.selectcolor(color);
		
		productpage.clickOnAddToCartButton();
		Orderpage orderpage=productpage.clickOnProceedToCheckout();
		Assert.assertTrue(orderpage.verifyproductIsDisplayed(productId));
	}
	

}
