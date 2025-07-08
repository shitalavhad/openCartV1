package testClasses;

import org.testng.annotations.AfterMethod;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Parameters;

import baseClass.BaseTest;
import pomClasses.HomePage;
import utilities.CommonUtiles;

public class SearchProductTest extends  BaseTest{
	@Parameters({"browser","os"})
	@BeforeMethod
	public void openApplication(String browser,String os)
	{
		
		driver=setup(browser,os);
		homePage=new HomePage(driver);
	}
	@AfterMethod
	public void closeBrowser()
	{
		tearDown();
	}
	@Test(priority=1,description="TC--1: Verify Serach prodect isDisplayed ")
	public void verifyProductSearch()
	{
		logger.info("****Started TC_001_Search Product Test*****");
		try {
		homePage.eneterProductName(CommonUtiles.getProperty("searchProductName"));
		searchPage=homePage.clickOnSearchButton();
		searchPage.isProductExist(CommonUtiles.getProperty("searchProductName"));
		Assert.assertEquals(searchPage.isProductExist(CommonUtiles.getProperty("searchProductName")), true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("****Finished TC_001_Search Product Test****");
	}
}
