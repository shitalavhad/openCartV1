package testClasses;


import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import baseClass.BaseTest;
import pomClasses.HomePage;
import utilities.CommonUtiles;

public class LoginTest  extends BaseTest{
	@Parameters("browser")
	@BeforeMethod
	public void openApplication(String browser)
	{
		
		driver=setup("chrome");
		homePage=new HomePage(driver);
		homePage.clickOnMyAccountLink();
		logger.info("Click On MyAccountLink");
		loginPage=homePage.clickOnLoginLink();
		logger.info("Click on loginLink");
		
	}
	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
	@Test(priority=1,description="TC-001: Login  with  valid Credentials")
	public void  verifyLoginWithValidCredentials()
	{
		logger.info(" *****Started TC-001:Login with valid credentials ****");
		try {
			logger.info("Enter valid Email and Password");
		loginPage.enterEmailAddress(CommonUtiles.getProperty("vaildEmail"));
		loginPage.enterPassword(CommonUtiles.getProperty("password"));
		
		logger.info("Click on LoginButton");
		myAccountPage=loginPage.clickOnLoginButton();
		
		Assert.assertTrue(myAccountPage.isAccountBreadCrumbDisplayed());
		
		}
		catch(Exception e)
		{
			logger.error("Test failed------------");
			logger.debug("Debug logs----------");
		}
		logger.info("*****Finish TC-001:Login with valid credentials *****" );
	}

}
