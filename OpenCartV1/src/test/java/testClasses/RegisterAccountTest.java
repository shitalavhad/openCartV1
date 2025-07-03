package testClasses;

import org.testng.Assert;
import org.testng.annotations.*;

import baseClass.BaseTest;
import pomClasses.HomePage;
import utilities.Constant;

public class RegisterAccountTest extends  BaseTest{
@Parameters("browser")
@BeforeMethod
public void openApplication(String browser)
{
	
	driver=setup("chrome");
	homePage=new HomePage(driver);
	homePage.clickOnMyAccountLink();
	registerAccountPage=homePage.clickOnRegisterLink();
}
@AfterMethod
public void closeBrowser()
{
	tearDown();
}
@Test(priority=1,description="TC-001: Verify RegistreAccount with only manetory fields")
public void verifyRegisteringAccountWithManetoryFields()
{
	registerAccountPage.enterTextInFirstNameField(genarateRandomAlphaNemeric());
	registerAccountPage.enterTextInLastNameField(genarateRandomAlphaNemeric());
	registerAccountPage.enterTextInEmailField(genarateRamdomString()+"@gmail.com");
	registerAccountPage.enterTextInTelephoneField(genarateRandomNumber());
	
	String password=genarateRandomNumber();
	registerAccountPage.enterTextInPasswordField(password);
	registerAccountPage.enterTextInConfirmPasswordField(password);
	
	registerAccountPage.clickOnPrivacyPolicyButton();
	accountSuccessPage=registerAccountPage.clickOnContinueButton();
	
	Assert.assertTrue(accountSuccessPage.isAccountSuccessBreadCrumbDisplayed());
	Assert.assertEquals(accountSuccessPage.retriveAccountSuccessMessage(),Constant.REGISTRATION_SUCCESS_MESSAGE);
}

@Test(priority=2,description="TC-002:Verify RegistreAccount By providing all Fields")
public void verifyRegisterAccountByProvidingallFields()
{
	registerAccountPage.enterTextInFirstNameField(genarateRandomAlphaNemeric());
	registerAccountPage.enterTextInLastNameField(genarateRandomAlphaNemeric());
	registerAccountPage.enterTextInEmailField(genarateRamdomString()+"@gmail.com");
	registerAccountPage.enterTextInTelephoneField(genarateRandomNumber());
	
	String password=genarateRandomNumber();
	registerAccountPage.enterTextInPasswordField(password);
	registerAccountPage.enterTextInConfirmPasswordField(password);
	
	registerAccountPage.clickOnNewsLetterYesButton();
	registerAccountPage.clickOnPrivacyPolicyButton();
	accountSuccessPage=registerAccountPage.clickOnContinueButton();
	
	Assert.assertTrue(accountSuccessPage.isAccountSuccessBreadCrumbDisplayed());
	Assert.assertEquals(accountSuccessPage.retriveAccountSuccessMessage(),Constant.REGISTRATION_SUCCESS_MESSAGE);
}
	
}

