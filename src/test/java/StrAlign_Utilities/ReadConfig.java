package StrAlign_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
	File src = new File("./Configuration/config.properties");
	try {
	FileInputStream fis = new FileInputStream(src);
	pro = new Properties ();
	pro. load(fis);
	} catch (Exception e) {
	System.out.println("Exception is " + e.getMessage ());
	}
	
	}
	public String SiteUrl() {
		String Url=pro.getProperty("Url");
		return Url;
	}
	public String UserName() {
		String UserName=pro.getProperty("Uname");
		return UserName;
	}
	public String Password() {
		String Password=pro.getProperty("Pass");
		return Password;
	}
	public String FrgtEmail() {
		String ForgotEmail=pro.getProperty("FrgtEmail");
		return ForgotEmail;
	}
	public String ChromePath() {
		String ChromePath=pro.getProperty("ChromePath");
		return ChromePath;
	}
	public String FireFoxPath() {
		String FireFoxPath=pro.getProperty("FireFoxPath");
		return FireFoxPath;
	}
	public String OldPassword() {
		String OldPassword=pro.getProperty("OldPassword");
		return OldPassword;
	}
	public String NewPassword() {
		String NewPassword=pro.getProperty("NewPassword");
		return NewPassword;
	}
	public String ConfirmNewPassword() {
		String ConfirmNewPassword=pro.getProperty("ConfirmNewPassword");
		return ConfirmNewPassword;
	}
	public String GoalDescriptions() {
		String GoalDescriptions=pro.getProperty("GoalDescription");
		return GoalDescriptions;
	}
}
