package ilabWeb;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;





import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ilabprofile {
	
	public static WebDriver driver;
	
	
	public static class objectReposetry {
		
		public static String iLAB_WEB = "https://www.ilabquality.com/";
		
		public static String careers = "//*[contains(@href,'https://www.ilabquality.com/careers/')]";
		
		public static String South_africa_Careers = "//*[contains(@href,'/careers/south-africa/')]";
		
		public static String South_africa_Careers_positions = "//div[contains(@class,'wpjb-grid-row wpjb-click-area  wpjb-free wpjb-type-full-time wpjb-category-south-africa')]";
		
		
		public static String apply_online = "//*[contains(@class,'wpjb-button wpjb-form-toggle wpjb-form-job-apply')]";
	    
	    
		public static String name = "//input[contains(@id,'applicant_name')]";
	    
		public static String email = "//input[contains(@id,'email')]";
		
		public static String phone = "//input[contains(@id,'phone')]";
	    
		public static String send_application = "//input[contains(@id,'submit')]";
	    
		public static String validation_message =  "//*[contains(text(),'You need to upload at least one file.')]";
		
		public static String Applicantname;
		public static String Email;
		public static String phonenumber;
		public static Writer Auditlog;
		
		public static Writer Auditlog () throws IOException {
			
			Writer Auditlog = new FileWriter("C:\\Koena PC\\data\\logfile.txt");
			
			return Auditlog;
		}
	    
		
	}
	
	
	
	public static WebDriver driverSetUp(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Koena PC\\software\\chromedriver_win32\\chDnv\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
	    
	    return driver;
	}
	
	
	
	public static void getapplicantData() throws IOException {
		
			
			 //Create an object of File class to open xlsx file
		

		    File file =    new File("C:\\Koena PC\\data\\data.xlsx");
		   


		    //Create an object of FileInputStream class to read excel file

		    FileInputStream inputStream;
			try {
				inputStream = new FileInputStream(file);

		    
		    

		    Workbook applicantData = null;

		    //Find the file extension by splitting file name in substring  and getting only extension name

		    String fileExtensionName = file.getName().toString().substring(file.getName().toString().indexOf("."));

		    //Check condition if the file is xlsx file

		    if(fileExtensionName.equals(".xlsx")){

		    //If it is xlsx file then create object of XSSFWorkbook class

		    	
					applicantData = new XSSFWorkbook(inputStream);
			
		    }

		    //Check condition if the file is xls file

		    else if(fileExtensionName.equals(".xls")){

		        //If it is xls file then create object of HSSFWorkbook class

		    	applicantData = new HSSFWorkbook(inputStream);
		    }
		    
		    objectReposetry.Auditlog = objectReposetry.Auditlog();
		    

		    
		    Sheet applicantDataSheet = applicantData.getSheetAt(0);
		    objectReposetry.Auditlog.write("Reading file sheet \n");
		    objectReposetry.Applicantname = applicantDataSheet.getRow(1).getCell(0).toString();
		    objectReposetry.Auditlog.write("Got Applicant Name from file \n");
		    objectReposetry.Email = applicantDataSheet.getRow(1).getCell(1).toString();
		    objectReposetry.Auditlog.write("Got email from file \n");
		    objectReposetry.phonenumber = applicantDataSheet.getRow(1).getCell(2).toString();
		    objectReposetry.Auditlog.write("Got phone number from file \n");
		    
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		
	}
	
	public static void jobapplication()
	
	{
		
		
		try {
			
			
			
			driver = driverSetUp();
			objectReposetry.Auditlog.write("loading selenium server \n");
		
		
		
			driver.navigate().to(objectReposetry.iLAB_WEB);
			objectReposetry.Auditlog.write("loading Ilab website \n");
			
			
		
			JavascriptExecutor scroll = (JavascriptExecutor) driver;
			scroll.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(objectReposetry.careers)));
		
			driver.findElement(By.xpath(objectReposetry.careers)).click();
			objectReposetry.Auditlog.write("chick on careers \n");
			
			driver.manage().window().maximize();
			objectReposetry.Auditlog.write("maximize browsor \n");
		
		
			Thread.sleep(400);
		

		
			scroll.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(objectReposetry.South_africa_Careers)));
			objectReposetry.Auditlog.write("scroll down \n");
			driver.findElement(By.xpath(objectReposetry.South_africa_Careers)).click();
			objectReposetry.Auditlog.write("chick on south african careers \n");
			
			Thread.sleep(400);
			
			List<WebElement> jobs = driver.findElements(By.xpath(objectReposetry.South_africa_Careers_positions));
			
			jobs.get(0).click();
			
			Thread.sleep(700);
			
			scroll.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(objectReposetry.apply_online)));
			objectReposetry.Auditlog.write("Scroll to apply online \n");
			
			Thread.sleep(100);
			
			driver.findElement(By.xpath(objectReposetry.apply_online)).click();
			objectReposetry.Auditlog.write("chick on apply online \n");
			
			Thread.sleep(100);
			
			driver.findElement(By.xpath(objectReposetry.name)).sendKeys(objectReposetry.Applicantname);
			objectReposetry.Auditlog.write("type applicant name \n");
			
			driver.findElement(By.xpath(objectReposetry.email)).sendKeys(objectReposetry.Email);
			
			objectReposetry.Auditlog.write("type email \n");
			
			driver.findElement(By.xpath(objectReposetry.phone)).sendKeys(objectReposetry.phonenumber);
			objectReposetry.Auditlog.write("type pnone number \n");
			
			scroll.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(objectReposetry.send_application)));
			
			driver.findElement(By.xpath(objectReposetry.send_application)).click();
			objectReposetry.Auditlog.write("chick on send application \n");
			

			
			scroll.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(objectReposetry.validation_message)));
			
			
			

				
			
			
		
		} catch (InterruptedException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void StoretestData() throws SQLException {
		
		Connection connection = DriverManager.getConnection("sql10.freesqldatabase.com:3306/sql10419318","sql10419318","X6WkIGPU33");
		
		String SqueryL = "INSERT INTO ilab(email, name, phaonenumber, date) VALUES(?,?,?,?)";
		
		PreparedStatement preparedStmt = connection.prepareStatement(SqueryL);
		preparedStmt.setString (1, objectReposetry.Email);
		preparedStmt.setString (1, objectReposetry.Applicantname);
		preparedStmt.setString (1, objectReposetry.phonenumber);
		preparedStmt.setString(1, java.time.LocalDateTime.now().toString());
		preparedStmt.execute();
		connection.close();
		
		
	}	
	
	public static class report
	{
		
		static ExtentTest test;
		static ExtentReports report;
		
		
		
		
		@BeforeClass
		public static void startTest()
		{
		
		report = new ExtentReports(System.getProperty("C:\\Koena PC\\")+"ExtentReportResults.html");
		test = report.startTest("Extent");
		
		//report.addSystemInfo("Host Name", "SoftwareTestingMaterial")
        //.addSystemInfo("Environment", "Automation Testing")
        //.addSystemInfo("User Name", "ilab");
        //loading the external xml file (i.e., extent-config.xml) which was placed under the base directory
        //You could find the xml file below. Create xml file in your project and copy past the code mentioned below
		report.loadConfig(new File("C:\\Koena PC\\extent-config.xml"));
		}
		
		@Test
		public static void testcasestatus() {
			
			
			
			try {
				
				StoretestData();
			
				if(driver.findElement(By.xpath(objectReposetry.validation_message)).getText().contains("You need to "))
				{
					test.log(LogStatus.PASS, "Job application file validation message");
				
					objectReposetry.Auditlog.write("'You need to upload the file' message is displayed");

				}
				else
					{
					test.log(LogStatus.FAIL, "Job application file validation message");
					objectReposetry.Auditlog.write("'You need to upload the file' message is not found");
					}
				
				objectReposetry.Auditlog.flush();
				objectReposetry.Auditlog.close();
				
				
				
				
			} catch (IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			driver.quit();
		}
		
		@AfterClass
		public static void endTest()
		{
		report.endTest(test);
		report.flush();
		}
	}

}
