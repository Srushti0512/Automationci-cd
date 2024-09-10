package rahulshettyacademy.tests;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.internal.invokers.AbstractParallelWorker.Arguments;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{

	@Test
	
	public void submitOrder() throws IOException{
		
		// TODO Auto-generated method stub
		String prodName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingpage.loginApplication("srushti@gmail.com","Srushti@143!");
		
		List<WebElement> products =productCatalogue.getProductList();
		productCatalogue.addProductTocart(prodName);
		CartPage cartpage = productCatalogue.goToCartPage();
		Boolean match = cartpage.verifyProductsDisplay(prodName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage =cartpage.goToCheckout();
		checkoutPage.selectCountry("india");
		WebElement e =driver.findElement(By.xpath("//a[normalize-space()='Place Order']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",e);
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		

		
		
	}
	
	
	
	
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistoryTest() {
		ProductCatalogue productCatalogue = landingpage.loginApplication("sruhti@gmail.com","Sruhti@143!");
		
		
		//"ZARA COAT 3";
	}
			
	
}
