package testClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import baseClass.BaseTest;
import pomClasses.HomePage;
import utilities.DataProviderUtilities;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginDataDrivenTest  extends BaseTest{
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
	@Test(priority=1,description="TC-001: Verify Login With Multiple Set Of Data ",dataProvider = "loginData",dataProviderClass = DataProviderUtilities .class)
	public void verifyLoginWithMultipleSetOfData(String email,String pwd,String result)
	{
		/*Data valid=>sucessful-->tcpassed--->logout
		 *                        unscuessful-->tcfaild
		 * Data invalid=>sucessful-->faild--->logout
		 *                            unscuessful-->passed
		 *                            
		 */
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(pwd);
		myAccountPage=loginPage.clickOnLoginButton();
		
		boolean targetPage = myAccountPage.isUserLoggedIn();
		//validation
		if(result.equalsIgnoreCase("valid"))
		{
			if(targetPage==true)
			{
				Assert.assertTrue(true);
				myAccountPage.clickOnLogOutLink();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(result.equalsIgnoreCase("Invalid"))	
	  	{
	  		if(targetPage==true)
	  		{
	  			myAccountPage.clickOnLogOutLink();
	        	 Assert.assertTrue(true);
	  		}
	  		else
	  		{
	  			Assert.assertTrue(false);
	  		}
	  	}
	}

}
