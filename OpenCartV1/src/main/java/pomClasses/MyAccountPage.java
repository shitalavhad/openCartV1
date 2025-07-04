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
	
	public boolean isAccountBreadCrumbDisplayed()
	{
		return accountBreadCrumb.isDisplayed();
	}

}
