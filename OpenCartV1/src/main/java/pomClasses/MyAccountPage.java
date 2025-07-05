package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//i[@class='fa fa-home']")
	private WebElement accountBreadCrumb;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	private WebElement btnLogout;
	
	public AccountLogoutPage clickOnLogOutLink()
	{
		btnLogout.click();
		return new AccountLogoutPage(driver);
	}
	
	
	public boolean isUserLoggedIn()
	{
		return btnLogout.isDisplayed();
	}
	
	public boolean isAccountBreadCrumbDisplayed()
	{
		return accountBreadCrumb.isDisplayed();
	}

}
