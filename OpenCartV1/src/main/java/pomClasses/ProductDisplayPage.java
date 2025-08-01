package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductDisplayPage extends PageBase {

	public ProductDisplayPage(WebDriver driver) {
		super(driver);	
	}
@FindBy(xpath="(//ul[@class='breadcrumb']//a)[3]")
private WebElement productBreadCrumb;

@FindBy(xpath="//input[@id='input-quantity']")
private WebElement qualityField;

@FindBy(xpath="//button[@id='button-cart']")
private WebElement addToCartButton;

@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
private WebElement addToCartSuccessMessage;

@FindBy(xpath="(//div[@id='top-links']//span)[5][text()='Shopping Cart']")
private WebElement shoppingCartLink;

@FindBy(xpath="(//button[@class='btn btn-default'])[2]")
private WebElement compareThisProductButton;

@FindBy(xpath="(//ul[@class='breadcrumb']/following-sibling::div)[1]")
private WebElement productComparisionSuccessMessage;

@FindBy(xpath="//button[@id='list-view']")
private WebElement listViewButton;

public void clickOnListViewButton()
{
	listViewButton.click();
}

public boolean retriveProductComparisionSuccessMessage()
{
	return productComparisionSuccessMessage.isDisplayed();
}
public void clickOnCompareThisProductButton()
{
	compareThisProductButton.click();
}
public boolean isCompareThisProductButtonVisible()
{
	return compareThisProductButton.isDisplayed();
}

public ShoppingCartPage clickOnShoppingCartLink()
{
	//js.executeScript("arguments[0].click();", shoppingCartLink);
	ewait.until(ExpectedConditions.visibilityOf(shoppingCartLink)).click();
	return new ShoppingCartPage (driver);
}

public boolean isAddToCartSuccessMessageDisplayed()
{
	return ewait.until(ExpectedConditions.visibilityOf(addToCartSuccessMessage)).isDisplayed();
	 //return addToCartSuccessMessage.isDisplayed();
}
public void ClickOnAddToCartButton()
{
	addToCartButton.click();
}

public void setQuality(String quality)
{
	qualityField.sendKeys(quality);
}

public boolean isProductBreadCrumbExist(String pName)
{
	return productBreadCrumb.isDisplayed();
}
}