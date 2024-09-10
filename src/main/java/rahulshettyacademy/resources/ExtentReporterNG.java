package rahulshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("Web Automation Results");
		report.config().setDocumentTitle("TestResults");	
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Tester", "Srushti");
		return extent;
	}

	

}