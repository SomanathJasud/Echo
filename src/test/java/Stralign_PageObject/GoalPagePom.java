package Stralign_PageObject;

import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoalPagePom {
	WebDriver ldriver;
	public String TimeStamp;
	public Actions action;

	public GoalPagePom(WebDriver rdriver) {
		ldriver = rdriver;
        action = new Actions(ldriver);
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"goal\"]")
	WebElement Goal;
	
	@FindBy(xpath = "//span[normalize-space()='Add a New Goal']")
	WebElement AddGoalBtn;

	@FindBy(xpath = "//*[@id=\"main\"]/div/h5/span[1]")
	WebElement BacktoGoalBtn;//Back to goals button from add a new goal page
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement GoalNameInput;
	
	@FindBy(id = "description")
	WebElement GoalDescriptionInput;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement SaveGoalButton;
	
	@FindBy(xpath = "//input[@placeholder='Search goal']")
	WebElement SearchExistingGoalsInput;

	@FindBy(xpath = "//h5[@class='ant-typography fw-bolder button-font css-1rwl0x7']")
	WebElement GetTextofSearchedGoal;
	
//	@FindBy(xpath = "//button[@class='ant-btn css-1rwl0x7 ant-btn-text ant-dropdown-trigger ant-dropdown-open']")
//	WebElement GoalOptionBtn;
	//*[@id="rc-tabs-1-panel-1"]/div/div[2]/div[1]/div[1]/div[2]/div/button
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/section[1]/section[1]/main[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/button[1]/span[1]/*[name()='svg'][1]")
	WebElement GoalOptionBtn;
//	@FindBy(xpath = "//span[contains(text(),'Edit')]")
//	WebElement GoalOptionBtn;
	
	//public By Edit=By.xpath("/html/body/div[3]/div/div/ul/li[1]/span/button");
	@FindBy(xpath="//span[contains(text(),'Edit')]")
	List<WebElement> Edit;
	
	@FindBy(xpath = "//span[contains(text(),'Archive Goal')]")
	WebElement ArchiveGoal;
	
	@FindBy(xpath = "//span[contains(text(),'Active Goal')]")
	WebElement ActiveGoal;
	
	public String GetDate() {
		Date dd = new Date();
		String date =dd.toString();
		TimeStamp = date.replace(' ','-').replace(' ', '-');
		return TimeStamp;
	}
	public void Goal() {
		Goal.click();
	}
	public void AddGoalBtn() {
		AddGoalBtn.click();
	}
	public void GoalNameInput() {
		GoalNameInput.sendKeys(TimeStamp);
	}
	public void GoalDescriptionInput(String GD) throws InterruptedException {
		GoalDescriptionInput.sendKeys(GD);;
		Thread.sleep(700);
	}
	public void SaveGoalBtn() throws InterruptedException {
		SaveGoalButton.click();
		Thread.sleep(3000);
	}
	public void NavigateBack() throws InterruptedException {
		ldriver.navigate().back();
		Thread.sleep(3000);
	}
	public void BackToGoalBtn() throws InterruptedException {
		BacktoGoalBtn.click();
		Thread.sleep(3000);
	}
	public void SearchExistingGoals() throws InterruptedException {
		SearchExistingGoalsInput.sendKeys(TimeStamp);
		Thread.sleep(2000);
	}
	public String GetTextofSearchedGoal() throws InterruptedException {
		String SearchedGoal =GetTextofSearchedGoal.getText();
		Thread.sleep(2000);
		return SearchedGoal;
	}
	public void GoalOption() throws InterruptedException {
		GoalOptionBtn.click();
		//action.moveToElement(GoalOptionBtn).build().perform();
		Thread.sleep(2000);
	}
	public void EditGoal() throws InterruptedException {
		//EditGoal.click();
		if (Edit.size() >= 2) {
		    // Click on the second element (index 1)
		    Edit.get(1).click();
		    Thread.sleep(2000);
		} else {
		    System.out.println("Not enough elements in the list to click on the second element.");
		}
	}
	public void ArchiveGoal() {
		ArchiveGoal.click();
	}
}
