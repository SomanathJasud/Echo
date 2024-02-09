package Stralign_PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePagePOM {
	WebDriver ldriver;

	public ProfilePagePOM(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//span[@class='ant-dropdown-trigger cursor-pointer fs-16 capital-text']")
	WebElement ProfileButton;

	@FindBy(xpath = "/html/body/div[3]/div/div/ul/li[1]")
	WebElement MyProfile;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/div[1]/button")
	WebElement ChangePassword;
	
	@FindBy(id = "currentPassword")
	WebElement OldPassInput;
	
	@FindBy(id = "newPassword")
	WebElement NewPassInput;
	
	@FindBy(id = "confirmNewPassword")
	WebElement ConfirmNewPassInput;

	@FindBy(xpath = "//span[normalize-space()='Save']")
	WebElement SaveBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	WebElement CancelBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Close']")
	WebElement Close;
	
	public void ClickOnProfile() throws InterruptedException {
		ProfileButton.click();
		Thread.sleep(2000);
	}
	public void ClickMyProfileBtn() throws InterruptedException {
		MyProfile.click();
		Thread.sleep(2000);
	}
	public void ChangePassword() throws InterruptedException {
		ChangePassword.click();
		Thread.sleep(2000);
	}
	public void OldPassword(String OldPass) throws InterruptedException {
		OldPassInput.sendKeys(OldPass);
		Thread.sleep(2000);
	}
	public void NewPassInput(String OldPass) throws InterruptedException {
		NewPassInput.sendKeys(OldPass);
		Thread.sleep(2000);
	}
	public void ConfirmNewPassInput(String OldPass) throws InterruptedException {
		ConfirmNewPassInput.sendKeys(OldPass);
		Thread.sleep(2000);
	}
	public void SaveBtn() throws InterruptedException {
		SaveBtn.click();
		Thread.sleep(2000);
	}
	public void CancelBtn() throws InterruptedException {
		CancelBtn.click();
		Thread.sleep(1000);
	}
	public void CloseBtn() throws InterruptedException {
		Close.click();
		Thread.sleep(5000);
	}
}
