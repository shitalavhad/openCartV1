package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.*;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);	
	}

	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement myAccountLink;
	
	@FindBy( xpath=" //a[normalize-space()='Register']")
	private WebElement registerLink;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	private WebElement loginLink;
	
	
	public LoginPage clickOnLoginLink()
	{
		loginLink.click();
		return new LoginPage(driver);
	}
	public RegisterAccountPage clickOnRegisterLink()
	{
		registerLink.click();
		return new RegisterAccountPage(driver);
	}
	public void clickOnMyAccountLink()
	{
		myAccountLink.click();
	}
	
}
