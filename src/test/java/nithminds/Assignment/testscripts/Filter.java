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
public void Parfum(String filtertype,String option) throws InterruptedException {
	ExtentTest test=ListenersImplementation.getTest();
	LandingPage landingPage=new LandingPage(driver);
	String Category="PARFUM";
	landingPage.handleCookieConsent();
	test.log(Status.PASS, "Cookie consent handled succesfully");
	landingPage.selectCategory(Category);
	test.log(Status.PASS, "Clicked on "+Category+" succesfully");
	
	PerfumePage PerfumePage=new PerfumePage(driver);
	PerfumePage.clickOnShowMoreButton();
	if(filtertype.equalsIgnoreCase("Produktart")) {
	PerfumePage.selectProduktart(option);
	}
	if(filtertype.equalsIgnoreCase("Marke")) {
	PerfumePage.selectMarke(option);;
	}
	if(filtertype.equalsIgnoreCase("Für Wen")) {
	PerfumePage.selectFürWen(option);;
	}
	if(filtertype.equalsIgnoreCase("Duftnote")) {
	PerfumePage.selectDuftnote(option);;
	}
	if(filtertype.equalsIgnoreCase("Verantwortung")) {
	PerfumePage.selectVerantwortung(option);;
	}
	if(filtertype.equalsIgnoreCase("Zusatzstoffe")) {
	PerfumePage.selectZusatzstoffe(option);
	}
	if(filtertype.equalsIgnoreCase("Aktionen")) {
	PerfumePage.selectAktionen(option);
	}
	if(filtertype.equalsIgnoreCase("Geschenk für")){
	PerfumePage.selectGeschenkfür(option);
	}
        Map<String, String> AllListingProductDetails = PerfumePage.getListingInfo();
     
	for(Map.Entry<String, String> eachlisting:AllListingProductDetails.entrySet()) {
		String brand = eachlisting.getKey();
		String price = eachlisting.getValue();
		test.log(Status.INFO, "brand: "+brand+"<br>price: "+price);
	}
     
	
}




@DataProvider(name="filterChoice")
public Object[] selectFilterOptions() {
	return new Object[][]{{"Produktart","Eau de Parfum"}
		
		
	};
}//{"Marke","Abercrombie & Fitch"}
}
