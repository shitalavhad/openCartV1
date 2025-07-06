package baseClass;
import java.awt.AWTException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import pomClasses.AccountSuccessPage;
import pomClasses.ForgotYourPassordPage;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import pomClasses.MyAccountPage;
import pomClasses.ProductDisplayPage;
import pomClasses.RegisterAccountPage;
import pomClasses.SearchPage;
import pomClasses.ShoppingCartPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import utilities.CommonUtiles;

public class BaseTest {
	public static WebDriver driver;
	public HomePage homePage;
	public AccountSuccessPage accountSuccessPage;
	public RegisterAccountPage registerAccountPage;
	public LoginPage loginPage;
	public MyAccountPage myAccountPage;
	public  ForgotYourPassordPage  forgotYourPassordPage;
	public SearchPage searchPage;
	public  ProductDisplayPage   productDisplayPage ;
	public ShoppingCartPage  shoppingCartPage ;
	public Logger logger;
	
	public WebDriver setup(String browser)
	{
		logger=LogManager.getLogger(this.getClass());//log4j
		
		System.setProperty("webdriver.chrome.driver", "H:\\Chrome\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(CommonUtiles.getProperty("url"));
		return  driver;
	}
	
	public void tearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}
	
	//capturing screenshot
	public String captureScreen(String tname) throws IOException{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot tc=(TakesScreenshot)driver;
		File sourceFile=tc.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+ "_"+timeStamp+".png";
		File targetFile=new File(targetFilePath);
		
		FileHandler.copy(sourceFile, targetFile);
		return targetFilePath;
	}
	
	//capture screenshot using robot class
	public String captureScreenRobot(String tname) throws AWTException, IOException
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		Robot rb=new Robot();
		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		
		Rectangle r=new Rectangle(d);
		
		BufferedImage buffredImage=rb.createScreenCapture(r);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+ "_"+timeStamp+".png";
		File destFile=new File(targetFilePath);
		ImageIO.write(buffredImage,"png", destFile);
		return targetFilePath;
	}
	
	//capture screenshot using ashot library
	public String captureScreenAshot(String tname) throws IOException
	{
		String timeStamp=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		Screenshot screenShot = 
		new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+ "_"+timeStamp+".png";
		File destFile=new File(targetFilePath);
		ImageIO.write(screenShot.getImage(), "png", destFile);
		return targetFilePath;
	}
	
	public static String genarateRamdomString()
	{
		String randomAlphabet= RandomStringUtils.randomAlphabetic(5);
		return randomAlphabet;
	}
	 public static String genarateRandomNumber()
	 {
		String  randomNumber= RandomStringUtils.randomNumeric(5);
		return randomNumber;
	 }
  public static String genarateRandomAlphaNemeric()
  {
	  String randomAlphabet= RandomStringUtils.randomAlphabetic(5);
	  String  randomNumber= RandomStringUtils.randomNumeric(3);
	  return randomAlphabet+randomNumber;
  }
}
