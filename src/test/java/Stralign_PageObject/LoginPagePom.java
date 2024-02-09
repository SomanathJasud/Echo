package Stralign_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPagePom {
	WebDriver ldriver;

	public LoginPagePom(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//input[@id='userName']")
	WebElement Emailinput;

	@FindBy(id = "password")
	WebElement Password;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement Submit;

	@FindBy(xpath = "//span[@class='ant-menu-title-content']")
	WebElement HomeText;

	@FindBy(xpath = "//span[@class='ant-dropdown-trigger cursor-pointer fs-16 capital-text']")
	WebElement ProfileButton;

	@FindBy(xpath = "/html/body/div[3]/div/div/ul/li[2]")
	WebElement Logout;

	@FindBy(xpath= "//a[@href='/forgot-password']")
	WebElement FrgPass;
	
	@FindBy(id="email")
	WebElement ForgetEmail;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement ResetPassword;
	
	@FindBy(id = "password")
	WebElement FrgtPswrdInptbx=null;
	
	By Id = By.id("password");
	public void Opensite(String Site) {
		ldriver.get(Site);
	}
	public void Email(String Username) {
		Emailinput.sendKeys(Username);
	}
	public void Password(String Passw) {
		Password.sendKeys(Passw);
	}
	public void Submit() throws InterruptedException {
		Submit.click();
		Thread.sleep(5000);
	}
	public String HomeText() throws InterruptedException {
		String ActualHome = HomeText.getText();
		return ActualHome;
	}
	public void ProfileButton() throws InterruptedException {
		ProfileButton.click();
		
		Thread.sleep(2000);
	}
	public void Logout() {
		Logout.click();
	}
	public void FrgPass() {
		FrgPass.click();
	}
	public void FrgtEmailInput(String FrgEmail) {
		ForgetEmail.sendKeys(FrgEmail);
	}
	public void ResetPassword() {
		ResetPassword.click();
	}
	public void EmailSendSuccess() {
		try {
			FrgtPswrdInptbx = ldriver.findElement(Id);
            System.out.println("Reset Password ");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Reset Password is not sent");
      }
	}
}
