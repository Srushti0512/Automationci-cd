package rahulshettyacademy.tests;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.LandingPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidation extends BaseTest{

	@Test(groups = {"ErrorHandling"},retryAnalyzer=Retry.class)
	
	public void LoginErrorValidation() throws IOException,InterruptedException{
		
		// TODO Auto-generated method stub
		String prodName = "ZARA COAT 3";
	    landingpage.loginApplication("srushti@gmail.com","Srushti@143!");
		Assert.assertEquals("Incorrect  or password.",landingpage.getErrorMessage());
		
		
	}
	public void ProductErrorValidation() throws IOException,InterruptedException{
		
		// TODO Auto-generated method stub
		String prodName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingpage.loginApplication("srushti@gmail.com","Srushti@143!");
		
		List<WebElement> products =productCatalogue.getProductList();
		productCatalogue.addProductTocart(prodName);
		CartPage cartpage = productCatalogue.goToCartPage();
		Boolean match = cartpage.verifyProductsDisplay("ZARA COAT 3");
		Assert.assertFalse(match);
     
	}
}
