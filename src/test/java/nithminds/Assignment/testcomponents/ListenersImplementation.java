package nithminds.Assignment.testcomponents;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import nithminds.Assignment.resources.ExtentReport;



public class ListenersImplementation extends BaseTest implements ITestListener{
	//public class ListenersImplementation extends BaseTest implements ITestListener{
		ExtentTest test ;
		ExtentReports extent=ExtentReport.getReportObject();
		private static ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();
		public static ExtentTest getTest() {
	        return extentTestThreadLocal.get();
	    }

		@Override
		public void onTestStart(ITestResult result) {
			
			test = extent.createTest(result.getMethod().getMethodName());
			 extentTestThreadLocal.set(test);
		}

		@Override
		public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test passed");
			
		}

		@Override
		public void onTestFailure(ITestResult result) {
			test.fail(result.getThrowable());
			try {
				driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String filepath=null;
			try {
				filepath = getScreenshot(result.getMethod().getMethodName(),driver);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			test.addScreenCaptureFromPath(filepath,result.getMethod().getMethodName() );
		}

		

		@Override
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			//ITestListener.super.onTestSkipped(result);
		}

		@Override
		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			//ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
		}

		@Override
		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
			//ITestListener.super.onTestFailedWithTimeout(result);
		}

		@Override
		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			//ITestListener.super.onStart(context);
		}

		@Override
		public void onFinish(ITestContext context) {
			extent.flush();
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return super.equals(obj);
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}

		@Override
		protected void finalize() throws Throwable {
			// TODO Auto-generated method stub
			super.finalize();
		}
		

}
