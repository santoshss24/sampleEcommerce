package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Homepage;
import Pages.Orderpage;
import Pages.ProductPage;

public class TC001 extends BaseTest
{
	@Test
	public void validLogin(String productId) throws InterruptedException
	{
		Homepage h=new Homepage(driver, webActionUtil);
		h.clickonDressesLink();
		h.selectProduct("4");
		h.scrolling(0, 500);
		ProductPage productpage=h.clickOnMoreButton(productId);
		productpage.clickOnPlusButton(3);
		productpage.clickOnMinusButton(1);
		productpage.selectSize("L");
		productpage.selectcolor("Pink");
		productpage.clickOnAddToCartButton();
		Orderpage orderpage=productpage.clickOnProceedToCheckout();
		Assert.assertTrue(orderpage.verifyproductIsDisplayed("4"));
	}
	

}
