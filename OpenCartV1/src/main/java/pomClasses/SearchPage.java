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
	
	@FindBy(xpath="//button[@id='list-view']")
	private WebElement listViewButton;
	
	@FindBy(xpath="(//button[@type='button' and @data-toggle='tooltip'] )[4]")
	private WebElement compareThisProductButton;
	
	@FindBy(xpath="(//ul[@class='breadcrumb']/following-sibling::div)[1]")
	private WebElement productComparisionSuccessMessage;
	
	public boolean isProductComparisionSuccessMessageDisplayed()
	{
		 return compareThisProductButton.isDisplayed();
	}
	public void clickOnCompareThisProductButton()
	{
		compareThisProductButton.click();
	}

	public void clickOnListViewButton()
	{
		listViewButton.click();
	}
	
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
