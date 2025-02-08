package nithminds.Assignment.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nithminds.Assignment.AbstractComponents;

public class PerfumePage extends AbstractComponents{
	WebDriver driver;
public PerfumePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(xpath="//div[@class='facet__title' and @data-testid='classificationClassName']")
WebElement productFilter;
@FindBy(xpath="//div[@class='facet-option__label']/div")
List<WebElement> dropdownoption;
@FindBy(xpath="//button[@class='selected-facets__value']")
WebElement AppliedFilter;
@FindBy(xpath="//div[@data-testid='brand']")
WebElement Brandfilter;
@FindBy(xpath="//button[@class='button button__with-icon--transparent button__normal facet-list__show-more']")
WebElement showmoreButton;
@FindBy(xpath="//button[text()='Weniger Filter anzeigen']")
WebElement showlessButton;
@FindBy(xpath="//div[@data-testid='gender']")
WebElement ForWhomFilter;
@FindBy(xpath="//div[@data-testid='Duftnote neu']")
WebElement FragranceFilter;
@FindBy(xpath="//div[@data-testid='responsibility']")
WebElement ResponsibilityFilter;
@FindBy(xpath="//div[@data-testid='additives']")
WebElement AdditivesFilter;
@FindBy(xpath="//div[@data-testid='flags']")
WebElement ActionFilter;
@FindBy(xpath="//div[@data-testid='Geschenk für']")
WebElement GiftForFilter;
@FindBy(xpath="//div[@class='product-info']")
List<WebElement> Listings;
@FindBy(xpath="//a[@data-testid='pagination-arrow-right']")
WebElement NextPageArrow;

public void clickOnShowMoreButton() {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(100));
	wait.until(ExpectedConditions.visibilityOf(showmoreButton));
	JavascriptExecutor js=(JavascriptExecutor)driver;	
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", showmoreButton);
	wait.until(ExpectedConditions.visibilityOf(showmoreButton));
	showmoreButton.click();
	wait.until(ExpectedConditions.visibilityOf(showlessButton));
}
public void selectProduktart(String Product) {
	productFilter.click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(100));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	for(WebElement eachdropdownoption:dropdownoption) {
		//js.executeScript("arguments[0].scrollIntoView({block: 'center'});", TotalListingPages);
		wait.until(ExpectedConditions.visibilityOf(eachdropdownoption));
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", eachdropdownoption);
	String productRequired = eachdropdownoption.getText();
	if(productRequired.equalsIgnoreCase(Product)) {
		eachdropdownoption.click();
		break;
	}
	}
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='selected-facets']/button[@class='selected-facets__value' and text()='"+Product+"']")));
	
	
	
}
public void selectMarke(String Brand) {
	Brandfilter.click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	for(WebElement eachdropdownoption:dropdownoption) {
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", eachdropdownoption);
	String productRequired = eachdropdownoption.getText();
	if(productRequired.equalsIgnoreCase(Brand)) {
		eachdropdownoption.click();
		break;
	}
	}
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='selected-facets']/button[@class='selected-facets__value' and text()='"+Brand+"']")));
	
	
	
}
public void selectFürWen(String ForWhom) {
	ForWhomFilter.click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	for(WebElement eachdropdownoption:dropdownoption) {
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", eachdropdownoption);
	String productRequired = eachdropdownoption.getText();
	if(productRequired.equalsIgnoreCase(ForWhom)) {
		eachdropdownoption.click();
		break;
	}
	}
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='selected-facets']/button[@class='selected-facets__value' and text()='"+ForWhom+"']")));
	
	
	
}
public void selectDuftnote(String Fragrance) {
	FragranceFilter.click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	for(WebElement eachdropdownoption:dropdownoption) {
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", eachdropdownoption);
	String productRequired = eachdropdownoption.getText();
	if(productRequired.equalsIgnoreCase(Fragrance)) {
		eachdropdownoption.click();
		break;
	}
	}
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='selected-facets']/button[@class='selected-facets__value' and text()='"+Fragrance+"']")));
	
	
	
}
public void selectVerantwortung(String Responsibility) {
	ResponsibilityFilter.click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	for(WebElement eachdropdownoption:dropdownoption) {
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", eachdropdownoption);
	String productRequired = eachdropdownoption.getText();
	if(productRequired.equalsIgnoreCase(Responsibility)) {
		eachdropdownoption.click();
		break;
	}
	}
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='selected-facets']/button[@class='selected-facets__value' and text()='"+Responsibility+"']")));
	
	
	
}
public void selectZusatzstoffe(String Additives) {
	AdditivesFilter.click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	for(WebElement eachdropdownoption:dropdownoption) {
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", eachdropdownoption);
	String productRequired = eachdropdownoption.getText();
	if(productRequired.equalsIgnoreCase(Additives)) {
		eachdropdownoption.click();
		break;
	}
	}
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='selected-facets']/button[@class='selected-facets__value' and text()='"+Additives+"']")));
	
	
	
}
public void selectAktionen(String Action) {
	ActionFilter.click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	for(WebElement eachdropdownoption:dropdownoption) {
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", eachdropdownoption);
	String productRequired = eachdropdownoption.getText();
	if(productRequired.equalsIgnoreCase(Action)) {
		eachdropdownoption.click();
		break;
	}
	}
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='selected-facets']/button[@class='selected-facets__value' and text()='"+Action+"']")));
	
	
	
}
public void selectGeschenkfür(String GiftFor) {
	GiftForFilter.click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	for(WebElement eachdropdownoption:dropdownoption) {
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", eachdropdownoption);
	String productRequired = eachdropdownoption.getText();
	if(productRequired.equalsIgnoreCase(GiftFor)) {
		eachdropdownoption.click();
		break;
	}
	}
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='selected-facets']/button[@class='selected-facets__value' and text()='"+GiftFor+"']")));
	
	
	
}
public List<String> getListingInfo() {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(100));
	
	List<String> ProductInfo=new ArrayList<String>();
	
	try {
		do {
	for(WebElement eachListing:Listings) {
		
		wait.until(ExpectedConditions.visibilityOf(eachListing));
		Thread.sleep(10);
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", eachListing);
		
		wait.until(ExpectedConditions.visibilityOf(eachListing));
		
		ProductInfo.add(eachListing.getText());
		
		 System.out.println(eachListing.getText());
		
	}
	 
	Thread.sleep(500);
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", NextPageArrow);
	Thread.sleep(500);
	String requiredurl=NextPageArrow.getAttribute("href");
	NextPageArrow.click();
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.urlContains(requiredurl));
		}while(true);
	}
	catch(Exception e) {
	//e.printStackTrace();	
	}
	
	
	return ProductInfo;
}
public String selectFilter(String FilterCategory,String option) {
	try {
	if(FilterCategory.equalsIgnoreCase("Produktart")) {
		productFilter.click();
	}
	else if(FilterCategory.equalsIgnoreCase("Marke")) {
		Brandfilter.click();
	}
else if(FilterCategory.equalsIgnoreCase("Für Wen")) {
	ForWhomFilter.click();
	}
else if(FilterCategory.equalsIgnoreCase("Duftnote")) {
	FragranceFilter.click();
}
else if(FilterCategory.equalsIgnoreCase("Verantwortung")) {
	ResponsibilityFilter.click();
}
else if(FilterCategory.equalsIgnoreCase("Zusatzstoffe")) {
	AdditivesFilter.click();
}
else if(FilterCategory.equalsIgnoreCase("Aktionen")) {
	ActionFilter.click();
}
else if(FilterCategory.equalsIgnoreCase("Geschenk für")) {
	GiftForFilter.click();
}
else {
	System.out.println("Selected filter option not available");
}
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	for(WebElement eachdropdownoption:dropdownoption) {
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", eachdropdownoption);
	String productRequired = eachdropdownoption.getText();
	if(productRequired.equalsIgnoreCase(option)) {
		eachdropdownoption.click();
		break;
	}
	}
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='selected-facets']/button[@class='selected-facets__value' and text()='"+option+"']")));
	}
	catch(Exception e) {
		//e.printStackTrace();
	}
	return AppliedFilter.getText();
}

}
