package pomClasses;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait ewait;

	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		js=(JavascriptExecutor)driver;
	}

}
