package StrAlign_TestCases;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import StrAlign_Utilities.ReadConfig;

public class BaseClass {
	ReadConfig ReadConfigfile= new ReadConfig();
	public String Uname=ReadConfigfile.UserName();
	public String Pass= ReadConfigfile.Password();
	public String Url= ReadConfigfile.SiteUrl();
	public String FrgtEmail=ReadConfigfile.FrgtEmail();
	public String OldPassword = ReadConfigfile.OldPassword();
	public String NewPassword = ReadConfigfile.NewPassword();
	public String ConfirmNewPassword = ReadConfigfile.ConfirmNewPassword();
	public String GoalDescriptions= ReadConfigfile.GoalDescriptions();
	public static WebDriver driver;
	public static Logger logger;
	@SuppressWarnings("deprecation")
	@Parameters("Crossbrowser")
	@BeforeClass
	public void setup(String Crossbrowser) {
	if (Crossbrowser.contains("f")||Crossbrowser.contains("F")) {
		logger=LogManager.getLogger(BaseClass.class);
		System.setProperty("webdriver.gecko.driver",ReadConfigfile.FireFoxPath());
		driver =new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	else if (Crossbrowser.contains("c")||Crossbrowser.contains("C")){
		logger=LogManager.getLogger(BaseClass.class);
		System.setProperty("webdriver.chrome.driver",ReadConfigfile.ChromePath());
		driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	}
	@AfterClass
	public void Teardown() {
		driver.quit();
	}
	public void captureScreen (WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs (OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}