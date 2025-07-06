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
	
	@FindBy(xpath="//input[@placeholder='Search']")
	private WebElement searchField;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement btnSearch;
	
	public SearchPage clickOnSearchButton()
	{
		btnSearch.click();
		return new SearchPage(driver);
	}
	
	public void eneterProductName(String pName)
	{
		searchField.sendKeys(pName);
	}
	
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
