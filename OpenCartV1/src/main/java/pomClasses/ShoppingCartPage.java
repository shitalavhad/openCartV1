package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		
	}
	@FindBy(xpath="(//table[@class='table table-bordered'])[2]//tbody//tr//td[1]")
	private WebElement productImage;
	
	@FindBy(xpath="(//table[@class='table table-bordered'])[2]//tbody//tr//td[6]")
	private WebElement totalPrice;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	private WebElement btnCheakOut;
	
	public void clickOnCheakOutButton()
	{
		 btnCheakOut.click();
	}
	
	public String getTotalPrice()
	{
		return totalPrice.getText();
	}
	
	public boolean isProductImageDisplayed()
	{
		return productImage.isDisplayed();
	}
	
	

}
