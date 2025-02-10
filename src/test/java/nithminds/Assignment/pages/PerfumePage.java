package nithminds.Assignment.pages;
import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import nithminds.Assignment.AbstractComponents;

public class PerfumePage extends AbstractComponents{
	WebDriver driver;
public PerfumePage(WebDriver driver) {
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//div[@class='facet-option__label']/div")
List<WebElement> dropDownOption;


@FindBy(xpath="//button[@class='button button__with-icon--transparent button__normal facet-list__show-more']")
WebElement showMoreButton;
@FindBy(xpath="//button[text()='Weniger Filter anzeigen']")
WebElement showLessButton;
@FindBy(xpath="//div[@class='product-info']")
List<WebElement> listings;
@FindBy(xpath="//a[@data-testid='pagination-arrow-right']")
WebElement nextPageArrow;
@FindBy(xpath="//button[@class='selected-facets__value']")
WebElement appliedFilter;
@FindBy(xpath="//input[@data-testid='preis-from']")
WebElement priceMinRangePlaceHolder;
@FindBy(xpath="//input[@data-testid='preis-to']")
WebElement priceMaxRangePlaceHolder;

public void clickOnShowMoreButton() {
	waitForElement(showMoreButton);
	scrollToElement(showMoreButton);
	clickElement(showMoreButton);
	 waitForElement(showLessButton);
	
}

public List<String> getListingInfo() {
	
	List<String> ProductInfo=new ArrayList<String>();
	
	try {
		do {
	for(WebElement eachListing:listings) {
		waitForElement(eachListing);
		
		Thread.sleep(10);
		scrollToElement(eachListing);
		waitForElement(eachListing);
		ProductInfo.add(eachListing.getText());
		
		 System.out.println(eachListing.getText());
		
	}
	waitForElement(nextPageArrow);
	scrollToElement(nextPageArrow);
	String requiredurl=nextPageArrow.getAttribute("href");
	clickElement(nextPageArrow);
	waitForSubUrl(requiredurl);
	Thread.sleep(2000);
	
		} while (nextPageArrow.isDisplayed());
	}
	catch(Exception e) {
		
		 throw new RuntimeException("Error fetching listing info", e);
	}
	
	finally {
	return ProductInfo;
	}
}
public String selectFilter(String filterCategory,String option) {
	String filterSelected = null;
	try {
		WebElement filterElement = driver.findElement(By.xpath("//div[@class='facet__title' and text()='"+filterCategory+"']"));
	clickElement(filterElement);
	if(!filterCategory.equalsIgnoreCase("Preis")) {
		for(WebElement eachDropDownOption:dropDownOption) {
	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", eachDropDownOption);
	String productRequired = eachDropDownOption.getText();
	if(productRequired.equalsIgnoreCase(option)) {
		clickElement(eachDropDownOption);
		break;
	}
	}
	waitForElement(driver.findElement(By.xpath("//div[@class='selected-facets']/button[@class='selected-facets__value' and text()='"+option+"']")));
	filterSelected=appliedFilter.getText();
	}
	}
	catch(Exception e) {
		throw new RuntimeException("Failed to select filter: " + filterCategory + " - " + option, e);
	}
	return filterSelected; 
}

}
