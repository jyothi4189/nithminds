package nithminds.Assignment.testscripts;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import nithminds.Assignment.pages.LandingPage;
import nithminds.Assignment.pages.PerfumePage;
import nithminds.Assignment.testcomponents.BaseTest;
import nithminds.Assignment.testcomponents.ListenersImplementation;
@Listeners(ListenersImplementation.class)
public class Filter extends BaseTest{
@Test(dataProvider="filterChoice")
public void Parfum(String filterType,String option) throws InterruptedException {
	ExtentTest test=ListenersImplementation.getTest();
	LandingPage landingPage=new LandingPage(driver);
	try {
	String Category="PARFUM";
	landingPage.handleCookieConsent();
	test.log(Status.PASS, "Cookie consent handled succesfully");
	landingPage.selectCategory(Category);
	test.log(Status.PASS, "Clicked on "+Category+" succesfully");
	
	PerfumePage perfumePage=new PerfumePage(driver);
	perfumePage.clickOnShowMoreButton();
	String filterApplied = perfumePage.selectFilter(filterType, option);
	Assert.assertEquals(filterApplied, option);
	 test.log(Status.PASS, "Filter '" + filterType + "' applied successfully: " + filterApplied);
        List<String> allListingProductDetails = perfumePage.getListingInfo();
     
	
		
		
		for(int i=0;i<allListingProductDetails.size();i++) {
		test.log(Status.INFO, "Info:"+allListingProductDetails.get(i));
		}
	}
	catch(Exception e) {
		 test.log(Status.FAIL, "Test failed due to exception: " + e.getMessage());
         Assert.fail("Test execution failed", e);
	}
     

}




@DataProvider(name="filterChoice")
public Object[] selectFilterOptions() {
	return new Object[][]{{"Aktionen","Geschenk"},
	{"Marke","Acca Kappa"}
		
	};
}
}
