package nithminds.Assignment.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	static String path = System.getProperty("user.dir")+"//reports//index.html";
	public static ExtentReports getReportObject() {
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("oneclickdrive live");
		reporter.config().setDocumentTitle("TestResults");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Testing_team");
		return extent;
}
}
