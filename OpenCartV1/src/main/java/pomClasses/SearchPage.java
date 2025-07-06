package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//div[@class='caption']//a")
	private WebElement productLink;
	
	public ProductDisplayPage clickOnProductLink()
	{
		productLink.click();
		return new ProductDisplayPage(driver);
	}
	
	public boolean isProductExist(String pName)
	{
		return  productLink.isDisplayed();
	}
	

}
