package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Basecls {
	
	 XSSFWorkbook wbook;
	 XSSFSheet sheet;
	
	public static WebDriver driver;
	
	public static ExtentReports report;
	public static ExtentTest test;
	@BeforeTest
	public void ReportSetUp() throws IOException {
		
	     report =  new ExtentReports("ExtentReport.html");
	     FileInputStream fis = new FileInputStream("exceldata.xlsx");
	     wbook = new XSSFWorkbook(fis);
	     sheet = wbook.getSheet("data");
		
	}
	
	
	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver","chromedriver");
		
		//System.setProperty("webdriver.firefox.driver","firefoxdriver");
		
		driver = new ChromeDriver();
		
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();  

		
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	@AfterTest
	public void ReportTeardown() throws IOException {
		wbook.close();
		report.flush();
		report.close();
	}

}
