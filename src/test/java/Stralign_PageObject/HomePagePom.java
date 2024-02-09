package Stralign_PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePagePom {
	WebDriver ldriver;

	public HomePagePom(WebDriver rdriver) {
		
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
	
	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[1]/div")
	WebElement MyGoals;
	
	@FindBy(xpath = "//*[@id=\"main\"]/div[1]/div[2]/div/div")
	WebElement MyScenarios;
	
	@FindBy(xpath = "//a[@class='fw-bold p']")
	WebElement ViewAllBtn;

	@FindBy(xpath = "//span[@class='ant-dropdown-trigger cursor-pointer fs-16 capital-text']")
	WebElement ProfileButton;

	@FindBy(xpath = "/html/body/div[3]/div/div/ul/li[2]")
	WebElement Logout;

	WebElement MyGoalsText=null;
	
	WebElement MyScenariostxt=null;
	
	By FindMyGoalsText= By.xpath("//*[@id=\"root\"]/div/section/section/header/div/div[1]/h4");
	
	By FindMyScenariosTxt=By.xpath("//*[@id=\"root\"]/div/section/section/header/div/div[1]/h4");
	
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
		Thread.sleep(15000);
	}
	public String HomeText() throws InterruptedException {
		String ActualHome = HomeText.getText();
		Thread.sleep(1000);
		return ActualHome;
	}
	public void ClickMyScenarios() throws InterruptedException {
		MyScenarios.click();
		Thread.sleep(3000);

	}
	public void ViewAllBtn() throws InterruptedException {
		ViewAllBtn.click();
		Thread.sleep(3000);

	}
	public void ClickMyGoals() throws InterruptedException {
		Thread.sleep(3000);
		MyGoals.click();
	}
	public void ProfileButton() throws InterruptedException {
		ProfileButton.click();
		Thread.sleep(3000);
	}
	public void MyScenariosTxt() {
		try {
			MyScenariostxt = ldriver.findElement(FindMyScenariosTxt);
            System.out.println("My Scenario Page is opened");
            Assert.assertTrue(true);

        } catch (InvalidSelectorException e) {
            System.out.println("Scenarios Button not clicked");
            Assert.assertTrue(false);
      }
	}
	public void MyGoalsTxt() throws InterruptedException {
		try {
			MyGoalsText = ldriver.findElement(FindMyGoalsText);
            System.out.println("My Goals Page is opened");
            Assert.assertTrue(true);

        } catch (InvalidSelectorException e) {
            System.out.println("Goals Button not clicked");
            Assert.assertTrue(false);
      }
		Thread.sleep(1000);
	}
	public void Navigate() {
		ldriver.navigate().back();
	}
	public void ScrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) ldriver;
        // Scroll down by 500 pixels vertically
        js.executeScript("window.scrollBy(0,400)");
	}
	
}
