package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage  extends AbstractComponent{
	
	WebDriver driver;
	
	 
	public CheckoutPage (WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	}

	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	
	@FindBy(xpath="(\"//a[normalize-space()='Place Order']\"")
	WebElement Submit;
	
	By results = By.cssSelector(".ta-results");

	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys( country,"india").build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}
    public ConfirmationPage submitOrder()
    {
    	Submit.click();
    	return new ConfirmationPage(driver);
    }
}
