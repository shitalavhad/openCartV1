package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class AccountSuccessPage extends PageBase {

	public AccountSuccessPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath=" //a[normalize-space()='Account']")
	private WebElement accountSuccessBreadCrumb;
	
	@FindBy(xpath="//h1[contains(text(),'Your Account')]")
	private WebElement accountSuccessMessage;
	
	public String retriveAccountSuccessMessage()
	{
		return accountSuccessMessage.getText();
	}
	public boolean isAccountSuccessBreadCrumbDisplayed()
	{
		return accountSuccessBreadCrumb.isDisplayed();
	}

}
