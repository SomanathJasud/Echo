package StrAlign_Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import StrAlign_TestCases.BaseClass;

public class Listeners extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test Start");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed");
		Date dd = new Date();
		String date =dd.toString();
		System.out.println(date);
		String TimeStamp = date.replace(' ','-').replace(' ', '-');
		System.out.println(TimeStamp);
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File("./Screenshots/'"+TimeStamp+"'.png"));
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercenatge(ITestResult result) {

	}
}
