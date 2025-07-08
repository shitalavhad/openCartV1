package testClasses;

import org.testng.Assert;
import org.testng.annotations.*;

import baseClass.BaseTest;
import pomClasses.HomePage;
import utilities.Constant;
import utilities.FakerDataUtiles;

public class RegisterAccountTest extends  BaseTest{
@Parameters({"browser","os"})
@BeforeMethod
public void openApplication(String browser,String os)
{
	
	driver=setup(browser,os);
	homePage=new HomePage(driver);
	homePage.clickOnMyAccountLink();
	logger.info("Click on MyAccountLink");
	registerAccountPage=homePage.clickOnRegisterLink();
	logger.info("Clcik on RegisterLink");
}
@AfterMethod
public void closeBrowser()
{
	tearDown();
}
@Test(priority=1,description="TC-001: Verify RegistreAccount with only manetory fields")
public void verifyRegisteringAccountWithManetoryFields()
{
	try {
		logger.info("Enter User Credentials");
	registerAccountPage.enterTextInFirstNameField(genarateRandomAlphaNemeric());
	registerAccountPage.enterTextInLastNameField(genarateRandomAlphaNemeric());
	registerAccountPage.enterTextInEmailField(genarateRamdomString()+"@gmail.com");
	registerAccountPage.enterTextInTelephoneField(genarateRandomNumber());
	
	String password=genarateRandomNumber();
	registerAccountPage.enterTextInPasswordField(password);
	registerAccountPage.enterTextInConfirmPasswordField(password);
	
	registerAccountPage.clickOnPrivacyPolicyButton();
	logger.info("Click on Privacy Policy Button");
	accountSuccessPage=registerAccountPage.clickOnContinueButton();
	logger.info("Click on Continue Button");
	
	Assert.assertTrue(accountSuccessPage.isAccountSuccessBreadCrumbDisplayed());
	logger.info("Verify AccountSuccessBreadCrumb Displayed or not");
	Assert.assertEquals(accountSuccessPage.retriveAccountSuccessMessage(),Constant.REGISTRATION_SUCCESS_MESSAGE);
	logger.info("Verify Account Success Message");
	}
	catch(Exception e)
	{
		logger.error("Test failed------------");
		logger.debug("Debug logs----------");
	}
}

@Test(priority=2,description="TC-002:Verify RegistreAccount By providing all Fields")
public void verifyRegisterAccountByProvidingallFields()
{
	try {
	logger.info("Enter User Credentials");
	registerAccountPage.enterTextInFirstNameField(genarateRandomAlphaNemeric());
	registerAccountPage.enterTextInLastNameField(genarateRandomAlphaNemeric());
	registerAccountPage.enterTextInEmailField(genarateRamdomString()+"@gmail.com");
	registerAccountPage.enterTextInTelephoneField(genarateRandomNumber());
	
	String password=genarateRandomNumber();
	registerAccountPage.enterTextInPasswordField(password);
	registerAccountPage.enterTextInConfirmPasswordField(password);
	
	registerAccountPage.clickOnNewsLetterYesButton();
	registerAccountPage.clickOnPrivacyPolicyButton();
	logger.info("Click on Privacy Policy Button");
	accountSuccessPage=registerAccountPage.clickOnContinueButton();
	logger.info("Click on Continue Button");
	
	Assert.assertTrue(accountSuccessPage.isAccountSuccessBreadCrumbDisplayed());
	logger.info("Verify AccountSuccessBreadCrumb Displayed or not");
	Assert.assertEquals(accountSuccessPage.retriveAccountSuccessMessage(),Constant.REGISTRATION_SUCCESS_MESSAGE);
	logger.info("Verify Account Success Message");
}
catch(Exception e)
{
	logger.error("Test failed------------");
	logger.debug("Debug logs----------");
}
}
@Test(priority=3,description="TC-003: Verify RegisterFunctinality with valid Data")
	public void verifyRegisterAccountWithValidData()
	{
	    logger.info("****Started TC-003: Verify RegisterFunctinality with valid Data*****");
	try {
		logger.info("Insert all information ");
		registerAccountPage.enterTextInFirstNameField(FakerDataUtiles.getFirstName());
		registerAccountPage.enterTextInLastNameField(FakerDataUtiles.getLastName());
		registerAccountPage.enterTextInEmailField(FakerDataUtiles.getEmail());
		registerAccountPage.enterTextInTelephoneField(FakerDataUtiles.getPhoneNumber());
		String password=FakerDataUtiles.getPassword();
		registerAccountPage.enterTextInPasswordField(password);
		registerAccountPage.enterTextInConfirmPasswordField(password);
		
		registerAccountPage.clickOnPrivacyPolicyButton();
		logger.info("Click on Privacy Policy Button");
		accountSuccessPage=registerAccountPage.clickOnContinueButton();
		logger.info("Click on Continue Button");
		
		Assert.assertTrue(accountSuccessPage.isAccountSuccessBreadCrumbDisplayed());
		logger.info("Verify AccountSuccessBreadCrumb Displayed or not");
		Assert.assertEquals(accountSuccessPage.retriveAccountSuccessMessage(),Constant.REGISTRATION_SUCCESS_MESSAGE);
		logger.info("Verify Account Success Message");	
		
	}
	catch(Exception e)
	{
		
		logger.error("Test failed------------");
		logger.debug("Debug logs----------");
	}
	  logger.info("****Finished TC-003: Verify RegisterFunctinality with valid Data*****");
	}
}

