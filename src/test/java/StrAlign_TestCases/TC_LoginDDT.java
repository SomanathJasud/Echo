package StrAlign_TestCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import StrAlign_Utilities.XLUtils;
import Stralign_PageObject.LoginPagePom;

import java.io.IOException;

public class TC_LoginDDT extends BaseClass {

    @Test(dataProvider ="Dt")
    public void loginDDT(String user, String pwd) throws InterruptedException {
        LoginPagePom lp = new LoginPagePom(driver);
        lp.Opensite(Url);
        lp.Email(user);
        lp.Password(pwd);
        lp.Submit();
    }
//This is for the Taking Data From the excel
//    @DataProvider(name ="LoginData")
//    public Object[][] getLoginData() throws IOException {
//        String excelFilePath = "/Users/somanathjasud/eclipse-workspace/Echo_Consulting/src/test/java/StrAlign_TestData/TestData.xlsx";
//        String sheetName = "Sheet1";
//
//        int rownum = XLUtils.getRowCount(excelFilePath, sheetName);
//        int colcount = XLUtils.getCellCount(excelFilePath, sheetName, 1);
//
//        Object[][] logindata = new Object[rownum][colcount];
//        
//        for (int i = 1; i <= rownum; i++) {
//            for (int j = 0; j < colcount; j++) {
//                logindata[i - 1][j] = XLUtils.getCellData(excelFilePath, sheetName, i, j);
//            }
//        }
//
//        return logindata;
//    }
    @DataProvider(name = "Dt")
    public Object[][] tdata(){
    	return new Object[][]
		{
    		{"User1","Password3"},
    		{"User2","Password3"},
    		{"User3","Password3"},
		};
    }
}

