package testClasses;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.bouncycastle.util.Properties;
import org.testng.Assert;
import org.testng.annotations.*;

import baseClass.BaseTest;
import pomClasses.HomePage;

public class ProductCompareTest extends BaseTest  {
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
	@Test(priority=1)
	public void verifyAddingTheProductForComparisionFromProductDispalyPage()
	{
		logger.info("***Started_TC001:verifyAdditingProductForComparisionFromProductDisplayPage***");
		try {
		logger.info("Enter Product in searchField");
		homePage.eneterProductName(Properties.getPropertyValue("searchProductName"));
		logger.info("Click on search button");
		searchPage=homePage.clickOnSearchButton();
		logger.info("Click On Product Link");
		productDisplayPage=searchPage.clickOnProductLink();
		logger.info("Verify compareProductButton is visible");
		Assert.assertTrue(productDisplayPage.isCompareThisProductButtonVisible());
		logger.info("Click on CompareThisProduct Button");
		productDisplayPage.clickOnCompareThisProductButton();
		Assert.assertTrue(productDisplayPage.retriveProductComparisionSuccessMessage());
		}
		catch(Exception e)
		{
			logger.error("Test failed------------");
			logger.debug("Debug logs----------");
		}
	}
	@Test(priority=2,description="TC_002:Verify adding the product for comparision from List View of Search Results page")
			
	public void verifyaddingtheproductforcomparisionfromListViewofSearchResultspage()
	{
		logger.info("***Started_TC_002:verifyAdditingProductForComparisionFromListViewOfSearchResultPage***");
		try {
		logger.info("Enter Product in searchField");
		homePage.eneterProductName(Properties.getPropertyValue("searchProductName"));
		logger.info("Click on search button");
	    searchPage=homePage.clickOnSearchButton();
	    searchPage.clickOnListViewButton();
	    searchPage.clickOnCompareThisProductButton();
	    Assert.assertTrue(searchPage.isProductComparisionSuccessMessageDisplayed());
		
	}
    catch(Exception e)
		{
    	logger.error("Test failed------------");
		logger.debug("Debug logs----------");
		}
	}
}
