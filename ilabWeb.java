package ilabWeb;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.TestNG;

import ilabWeb.ilabprofile.report;

public class ilabWeb {

	public static void main(String[] args) {
		
		try {
			
			ilabprofile.getapplicantData();

		
			ilabprofile.jobapplication();
		
		
			ilabprofile.report.startTest();
		
			ilabprofile.report.testcasestatus();
		
			ilabprofile.report.endTest();
		
			ilabprofile.StoretestData();

		
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
