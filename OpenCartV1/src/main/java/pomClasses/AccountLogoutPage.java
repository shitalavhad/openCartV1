package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountLogoutPage  extends PageBase{
	public AccountLogoutPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="//ul[@class='breadcrumb']//a[text()='Logout']")
	private WebElement logoutBreadcurmd;
	
	@FindBy(xpath="//a[text()='Continue']")
	private WebElement continueButton;
	
	public HomePage clickOnContinuButton()
	{
		continueButton.click();
		return new HomePage(driver);
	}
	public boolean didYouNavigateAccountLogoutpage()
	{
		return logoutBreadcurmd.isDisplayed();
	}

}
