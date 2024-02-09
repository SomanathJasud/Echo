package StrAlign_TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Stralign_PageObject.GoalPagePom;
import Stralign_PageObject.HomePagePom;
import Stralign_PageObject.ProfilePagePOM;

public class HomePage extends BaseClass {
	public HomePagePom hp;
	public ProfilePagePOM ProfilePage;
	public GoalPagePom GoalPage;
	@Test(priority=1)
	public void LoginInHome() throws InterruptedException {
	hp = new HomePagePom(driver);
	hp.Opensite(Url);
	hp.Email(Uname);
	hp.Password(Pass);
	hp.Submit();
	//hp.ClickMyScenarios();
	
	}
	@Test(priority=2)//(enabled=false)
	public void HomepageActions() throws InterruptedException {
	hp.ClickMyScenarios();
	hp.ClickMyScenarios();
	hp.MyScenariosTxt();
	hp.Navigate();
	hp.ClickMyGoals();
	hp.ScrollDown();
	hp.MyGoalsTxt();
	hp.Navigate();
	hp.ViewAllBtn();
	hp.Navigate();
	}
	@Test(priority=3)//(enabled=false)//
	public void ProfileActions() throws InterruptedException {
	ProfilePage =new ProfilePagePOM(driver);
	ProfilePage.ClickOnProfile();
	ProfilePage.ClickMyProfileBtn();
	Thread.sleep(1500);
	ProfilePage.ChangePassword();
	Thread.sleep(1000);
	ProfilePage.OldPassword(OldPassword);
	ProfilePage.NewPassInput(NewPassword);
	ProfilePage.ConfirmNewPassInput(ConfirmNewPassword);
	ProfilePage.SaveBtn();
	//ProfilePage.CancelBtn();
	ProfilePage.CloseBtn();
	}
	@Test(priority = 4)
	public void GoalPageActions() throws InterruptedException, IOException {
	GoalPage = new GoalPagePom(driver);
	String ActTimeStamp=GoalPage.GetDate();
	GoalPage.Goal();
	GoalPage.AddGoalBtn();
	GoalPage.GoalNameInput();
	GoalPage.GoalDescriptionInput(GoalDescriptions);
	System.out.println("Goal input given");
	GoalPage.SaveGoalBtn();
	//GoalPage.NavigateBack();
	//GoalPage.BackToGoalBtn();
	GoalPage.SearchExistingGoals();
	String GoalText=GoalPage.GetTextofSearchedGoal();
	if (ActTimeStamp.equalsIgnoreCase(GoalText)){
		Assert.assertTrue(true, "Goal is Matched");
		System.out.println("Goal is added successfully : "+GoalText);
	}
	else {
		captureScreen (driver, "GoalPageActions");
		Assert.assertTrue(false);
	}
	GoalPage.Goal();
	GoalPage.GoalOption();
	GoalPage.EditGoal();
	GoalPage.NavigateBack();
	Thread.sleep(4000);
	//GoalPage.GoalOption();
	
	}
}
