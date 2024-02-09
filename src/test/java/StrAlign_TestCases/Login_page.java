package StrAlign_TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import Stralign_PageObject.LoginPagePom;

public class Login_page extends BaseClass {

	@Test
	public void Logintest() throws InterruptedException, IOException {
		LoginPagePom lp = new LoginPagePom(driver);
		lp.Opensite(Url);
		logger.info("Entered The URL");
		System.out.println(driver.getTitle());

		
		lp.Email(Uname);
		logger.info("Entered The Email");
		
		lp.Password(Pass);
		logger.info("Entered The Password");
		
		lp.Submit();
		String ActualHome = lp.HomeText();
		System.out.println(ActualHome);
		
		if(ActualHome.equals("Home")) {
			Assert.assertTrue(true);
		}
		else {
			captureScreen (driver, "Logintest");
			Assert.assertTrue(false);
		}
		
		lp.ProfileButton();
		
		lp.Logout();
		logger.info("User is logged out successfully");
		
		lp.FrgPass();
		
		lp.FrgtEmailInput(FrgtEmail);
		logger.info("User input done in foreget password input box");
		
		lp.ResetPassword();
		
		lp.EmailSendSuccess();
		logger.info("Password reset link send");
	
	}
}
