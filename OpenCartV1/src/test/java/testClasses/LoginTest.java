package testClasses;


import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;
import baseClass.BaseTest;
import pomClasses.ForgotYourPassordPage;
import pomClasses.HomePage;
import utilities.CommonUtiles;
import utilities.Constant;

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
@	Test(priority=2,description="TC-002:Login with Invalid Credentials")
public void verifyLoginWithInvalidCredentials()
{
	logger.info("****Started TC-002:Login with invalid credencials******");	
	try {
		logger.info("Enetr Invalid Email and Password");
		loginPage.enterEmailAddress(CommonUtiles.getProperty("invalidEmail"));
		loginPage.enterPassword(CommonUtiles.getProperty("invalidPassword"));
		
		logger.info("Clcik on login Button");
		loginPage.clickOnLoginButton();
		
		logger.info("Verify error message");
		Assert.assertEquals(loginPage.getInvalidEmPwdWarning(), Constant.INVALIDEMAILPASSWORDWARNING);
	}
	catch(Exception e)
	{
		logger.error("Test failed-------");
		logger.debug("Debud logs------");
	}
	logger.info("****Finished TC-002:Login with invalid credencials******");
}
@Test(priority=3,description="TC-003:Login with invalid Email and valid Password")
public void verifyLoginWithInvalidEmailAndValidPassword()
{
	logger.info("****Started TC-003:Login with invalid  Email  and Valid Password******");	
	try {
		logger.info("Enetr Invalid Email and Password");
		loginPage.enterEmailAddress(CommonUtiles.getProperty("invalidEmail"));
		loginPage.enterPassword(CommonUtiles.getProperty("password"));
		
		logger.info("Clcik on login Button");
		loginPage.clickOnLoginButton();
		
		logger.info("Verify error message");
		Assert.assertEquals(loginPage.getInvalidEmPwdWarning(), Constant.INVALIDEMAILVALIDPASSWORD);
	}
	catch(Exception e)
	{
		logger.error("Test failed-------");
		logger.debug("Debud logs------");
	}
	logger.info("****Finished TC-003:Login with invalid Email and valid Password ******");
}
@Test(priority=4,description="TC-004:Login with Valid Email and  Invalid Password")
public void verifyLoginWithValidEmailAndInvalidPassword()
{
	logger.info("****Started TC-004:Login with valid Email  and InValid Password******");	
	try {
		logger.info("Enetr Invalid Email and Password");
		loginPage.enterEmailAddress(CommonUtiles.getProperty("vaildEmail"));
		loginPage.enterPassword(CommonUtiles.getProperty("invalidPassword"));
		
		logger.info("Clcik on login Button");
		loginPage.clickOnLoginButton();
		
		logger.info("Verify error message");
		Assert.assertEquals(loginPage.getInvalidEmPwdWarning(), 
				Constant.VALIDEMAIL_INVALIDPASSWORD_WARNING_MESSAGE);
	}
	catch(Exception e)
	{
		logger.error("Test failed-------");
		logger.debug("Debud logs------");
	}
	logger.info("****Finished TC-004:Login with valid Email and Invalid Password ******");
}
@Test(priority=5,description="TC-005:Login with without Credentials")
public void verifyLoginWithWithoutCredentials()
{
	logger.info("****Started TC-005:Login with without Credentials******");	
	try {
		
		logger.info("Clcik on login Button");
		loginPage.clickOnLoginButton();
		
		logger.info("Verify error message");
		Assert.assertEquals(loginPage.getInvalidEmPwdWarning(), 
				Constant.WITHOUT_CREDENTIALS_WARNING_MESSAGE);
	}
	catch(Exception e)
	{
		logger.error("Test failed-------");
		logger.debug("Debud logs------");
	}
	logger.info("****Finished TC-005:Login with without Credentials ******");
}
@Test(priority=6,description="TC-006: Verify Forgotten Link Avaliable and Working")
public void verifyForgottenLinkAvaliableAndWorking()
{
	logger.info("****Started TC-006: verify) Forgotten Link Avaliable and Working****");
	try {
		logger.info("Verify ForgottenPassword Link Avalible on login Page");
	Assert.assertTrue(loginPage.isForgottenLinkDisplayed());
	
	logger.info("Click on ForgottenPassword Link");
	 forgotYourPassordPage=loginPage.clickOnForgottenPasswordLink();
	 
	 logger.info("Verify user Navigate to forgotYourPassword Page");
	 Assert.assertTrue(forgotYourPassordPage.isForgottenPasswordBreadCrumbDisplayed());
	}
	catch(Exception e)
	{
		logger.error("Test failed-------");
		logger.debug("Debud logs------");
	}
	logger.info("****Finished TC-006: verify forgottenpassword link avaliable and working fine ******");
}
}
	


