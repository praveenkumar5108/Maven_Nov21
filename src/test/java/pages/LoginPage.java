package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import test.Basecls;

public class LoginPage {
	
	WebDriver driver = Basecls.driver;
	
	ExtentTest test = Basecls.test;
	
	@FindBy(linkText = "Log in")
	WebElement LoginLink;
	
	@FindBy(name = "user_login")
	WebElement UserName;
	
	@FindBy(id = "password")
	WebElement Password;
	
	@FindBy(name = "btn_login")
	WebElement LoginButtton;
	
	@FindBy(id = "msg_box")
	WebElement Error;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void Login(String UserNameVal, String PasswordVal) {
			
	        WebDriverWait wait = new WebDriverWait(driver,30);
			
			wait.until(ExpectedConditions.visibilityOf(LoginLink));
			
			LoginLink.click(); 
			test.log(LogStatus.PASS,"Click On Login Link", "Successfully Clicked The link");
			
			UserName.sendKeys(UserNameVal);
			test.log(LogStatus.PASS,"Enter Username" + UserNameVal, "Successfully entered the username");
			
			Password.sendKeys(PasswordVal);
			test.log(LogStatus.PASS,"Enter Username" + PasswordVal, "Successfully entered the Password");
			
			LoginButtton.click();
			test.log(LogStatus.PASS,"Click On Login Button", "Successfully Clicked The Login button");

			
		}
	
	public void Errorcheck() {
		
		String actualMsg = Error.getText();
		
		String expectedMsg = "The email or password you have entered is invalid.";
		
        //Assert.assertEquals(actualMsg, expectedMsg);		
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualMsg, expectedMsg);
		
		System.out.println("after assertion");
		System.out.println("after assertion");
		System.out.println("after assertion");

		soft.assertAll();
	}
}