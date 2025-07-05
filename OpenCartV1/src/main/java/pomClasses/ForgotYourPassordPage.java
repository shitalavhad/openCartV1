package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotYourPassordPage  extends PageBase{

	public ForgotYourPassordPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Forgotten Password']")
	private WebElement forgotttenPasswordBreadCrumb;
	
	public boolean isForgottenPasswordBreadCrumbDisplayed()
	{
		return forgotttenPasswordBreadCrumb.isDisplayed();
	}

}
