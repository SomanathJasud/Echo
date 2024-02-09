package StrAlign_Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import StrAlign_TestCases.BaseClass;

public class Reporting extends TestListenerAdapter {
	public ExtentSparkReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	BaseClass Base=new BaseClass();
	public void onStart (ITestContext testContext) {
	String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
	String repName="Test-Report-"+timeStamp+".html";
	htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/test-output/"+repName);//specify location 
	//htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"extent-config.xml");
	extent=new ExtentReports ();
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("Host name", "localhost");
	extent.setSystemInfo("Environemnt", "QA");
	extent.setSystemInfo("User", "Somanath");
	htmlReporter.config().setDocumentTitle("StrAlign Test Project"); // Tile of report 
	htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report 
	//locationofthechart 
	htmlReporter.config().setTheme (Theme. DARK) ;
	}
	public void onTestSuccess (ITestResult tr) {
	logger=extent.createTest(tr.getName ()); // create new entry in th report
	logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName (),ExtentColor.GREEN));
	}
	public void onTestFailure (ITestResult tr) {
	logger=extent.createTest(tr.getName());
	String abc=tr.getName();// create new entry in th report
	logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information 1
	String screenshotPath="./Screenshots/'"+abc+"'.png";
	File f = new File(screenshotPath);
//	Date dd = new Date();
//	String date =dd.toString();
//	System.out.println(date);
//	String abc = date.replace(' ','-').replace(' ', '-');
//	System.out.println(abc);
	
	if(f.exists())
	{
	logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
	}
	}
	public void onTestSkipped(ITestResult tr) {
	logger=extent.createTest(tr.getName ()); // create new entry in th report 
	logger. log(Status.SKIP, MarkupHelper.createLabel (tr. getName (), ExtentColor. ORANGE));
	}
	public void onFinish(ITestContext testContext) {
	extent.flush();
	}
}
