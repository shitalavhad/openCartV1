package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement btnLogin;
	
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	private WebElement forgottenPasswordLink;
	
	public void clickOnForgottenPasswordLink()
	{
		forgottenPasswordLink.click();
	}
	
	public MyAccountPage clickOnLoginButton()
	{
		btnLogin.click();
		return new MyAccountPage(driver);
	}
	
	public void enterPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void enterEmailAddress(String em)
	{
		txtEmailAddress.sendKeys(em);
	}
	

}
