package pomClasses;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait ewait;
	public Actions act;

	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		js=(JavascriptExecutor)driver;
		ewait=new WebDriverWait(driver,Duration.ofSeconds(5));
		act=new Actions(driver);
	}

}
