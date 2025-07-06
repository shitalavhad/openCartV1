package testClasses;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import baseClass.BaseTest;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import pomClasses.ProductDisplayPage;
import pomClasses.ShoppingCartPage;
import utilities.CommonUtiles;
import utilities.Constant;

public class EndToEndTest extends BaseTest {
	@Parameters("browser")
	@BeforeMethod
	public void openApplication(String browser)
	{
		
		driver=setup("chrome");
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
	@Test(priority=1,description="TC-001: Verify End To End Test")
	public void verifyEndToEndTest()
	{
		//Soft assertion
		SoftAssert soft=new SoftAssert();
		
	  logger.info("Account Registations");
	  registerAccountPage.enterTextInFirstNameField(genarateRamdomString().toUpperCase());
	  registerAccountPage.enterTextInLastNameField(genarateRamdomString().toUpperCase());
	  
	  String email=genarateRamdomString()+"@gmail.com";
	  registerAccountPage.enterTextInEmailField(email);//randomly genarated the email
	  
	  registerAccountPage.enterTextInTelephoneField(genarateRandomNumber());
	  
	  String pwd=genarateRandomAlphaNemeric();
	  registerAccountPage.enterTextInPasswordField(pwd);
	  registerAccountPage.enterTextInConfirmPasswordField(pwd);
	  registerAccountPage.clickOnPrivacyPolicyButton();
	  accountSuccessPage=registerAccountPage.clickOnContinueButton();
	  
	  //valiadtion1
	  soft.assertEquals(accountSuccessPage.retriveAccountSuccessMessage(),Constant.REGISTRATION_SUCCESS_MESSAGE );
	  
	  accountSuccessPage.clickOnLogoutLink();
	  
	 logger.info("Login to Application");
	  homePage=new HomePage(driver);
	  homePage.clickOnMyAccountLink();
	  
	 loginPage= homePage.clickOnLoginLink();
	 loginPage.enterEmailAddress(CommonUtiles.getProperty("vaildEmail"));
	 loginPage.enterPassword(CommonUtiles.getProperty("password"));
	 myAccountPage=loginPage.clickOnLoginButton();
	 
	 //validation2
	 soft.assertTrue(myAccountPage.isAccountBreadCrumbDisplayed());
	 
	 logger.info("Search and add product to cart");
	 homePage=new HomePage(driver);
	 homePage.eneterProductName(CommonUtiles.getProperty("searchProductName"));
	searchPage= homePage.clickOnSearchButton();
	 if(searchPage.isProductExist(CommonUtiles.getProperty("searchProductName"))){
		 productDisplayPage =searchPage.clickOnProductLink(); 
	 }
	 
	 //productDisplay Page
	 if(productDisplayPage.isProductBreadCrumbExist(CommonUtiles.getProperty("searchProductName")))
	 {
		 productDisplayPage.setQuality("2");
		 productDisplayPage.ClickOnAddToCartButton();
	 }
	 //validation3
	 soft.assertEquals(productDisplayPage.isAddToCartSuccessMessageDisplayed(), true);
	 
	 logger.info("Shooping cart");
	shoppingCartPage=productDisplayPage.clickOnShoppingCartLink();
	 ShoppingCartPage shoppingCartPage=new ShoppingCartPage(driver);
	 soft.assertTrue(shoppingCartPage.isProductImageDisplayed());
	 String totprices=shoppingCartPage.getTotalPrice();
	 soft.assertEquals(totprices, "$244.00");
	 shoppingCartPage.clickOnCheakOutButton();
	 
	 
	 
			
	
			
	 
	
	
	 
	  
	  
	  
	}

}
