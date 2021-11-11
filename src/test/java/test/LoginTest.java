package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.LoginPage;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest extends Basecls{
	
 
    
	
	@Parameters({"UserName" , "Password"})
	@Test
	public void NegativeLogin(String UserNameVal, String PasswordVal) {
		
		test = report.startTest("Negative Login Test");
		LoginPage login = new LoginPage();
        login.Login(UserNameVal, PasswordVal);		
		//WebElement ForgotPassword = driver.findElement(By.linkText("Forgot Password?"));		
		//ForgotPassword.click();
		
		login.Errorcheck();
		
		report.endTest(test);
		
	}
	
	@Parameters({"UserName" , "CorrectPassword"})
	@Test
	public void PositiveLogin(String UserNameVal, String PasswordVal) {
		test = report.startTest("Positive Login Test");
		LoginPage login = new LoginPage();

		login.Login(UserNameVal, PasswordVal);

		report.endTest(test);
		
	}
	@Test
	public void ExcelTest() throws IOException {
		
		
		
		String UserNameVal = sheet.getRow(1).getCell(0).getStringCellValue();
		String PasswordVal = sheet.getRow(1).getCell(1).getStringCellValue();
		test = report.startTest("Positive Login Test");
		LoginPage login = new LoginPage();

		login.Login(UserNameVal, PasswordVal);

		report.endTest(test);
		
	}
	

}
