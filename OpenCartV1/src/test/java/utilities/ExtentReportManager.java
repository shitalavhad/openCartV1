package utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import baseClass.BaseTest;
public class ExtentReportManager  implements ITestListener{
	
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extent;
	public ExtentTest test;
	String repName;

	@Override
	public void onStart(ITestContext context) {
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName="Test-Report-"+timeStamp+"html";
		sparkreporter=new ExtentSparkReporter( (System.getProperty("user.dir"))+ "\\reports\\" +repName);
		
		sparkreporter.config().setDocumentTitle("opencart Automation Report");
		sparkreporter.config().setReportName("opencart Functinal Report");
		sparkreporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkreporter);
		extent.setSystemInfo("ApplicationName", "OpenCartV1");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("SubModule", "Cumsumer");
		extent.setSystemInfo("Enivorment", "QA");
		extent.setSystemInfo( "UserName",System.getProperty("user.name"));
		extent.setSystemInfo("Application url", CommonUtiles.getProperty("url"));
		
		//operating system name
		 String os=context.getCurrentXmlTest().getParameter("os");
		 extent.setSystemInfo("Oprating System", os);
		 
		 //browserName
		String browser= context.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser",browser);
		
		List<String> includeGroups = context.getCurrentXmlTest().getIncludedGroups();
		if(!includeGroups.isEmpty())
		{
			extent.setSystemInfo("Groups", includeGroups.toString());
		}	
	}


	@Override
	public void onTestSuccess(ITestResult result) {
	test=extent.createTest(result.getTestClass().getName());
	test.assignCategory(result.getMethod().getGroups());
	test.log(Status.PASS, result.getName()+"got sucessfully executed");	
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		
		test.log(Status.FAIL, result.getName()+    "got failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		
		try
		{
			//String imgPath=new TestBase().captureScreen(result.getName());
			String imgPath=new BaseTest().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"got skippled");	
	}

	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
		
		//String extentReportPath=System.getProperty("user.dir")+ "\\reports\\"+repName;
	
		String pathOfExtentReport="C:\\Users\\SAI\\eclipse-workspace\\OpenCart\\reports";
		File extentReport=new File(pathOfExtentReport);
		
		//File extentReport=new File(extentReportPath);
		try {
		Desktop.getDesktop().browse(extentReport.toURI());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}
