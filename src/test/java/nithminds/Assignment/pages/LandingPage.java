package nithminds.Assignment.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import nithminds.Assignment.AbstractComponents;

public class LandingPage extends AbstractComponents{
WebDriver driver;

public LandingPage(WebDriver driver){
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(id="usercentrics-root")
WebElement shadowHost;
@FindBy(xpath="//li[@class='navigation-main-entry']/a")
List<WebElement> allCategory;

public void goTo() throws IOException {
	String url = getUrl("url");
	driver.get(url);
}
public void handleCookieConsent() throws InterruptedException {
	
	
	 SearchContext shadowrootElement = shadowHost.getShadowRoot();
	
		WebElement acceptButton = shadowrootElement.findElement(By.cssSelector("button[class='sc-dcJsrY eIFzaz']"));
	
	wait.until(ExpectedConditions.elementToBeClickable(acceptButton));
	clickElement(acceptButton);
		
}
public void selectCategory(String option) throws InterruptedException {

	
	String tragetUrl=null;
	
	
	for(WebElement eachCategory:allCategory) {
		String text = eachCategory.getText();
		
		if(text.equalsIgnoreCase(option)) {
			tragetUrl=eachCategory.getAttribute("href");
			clickElement(eachCategory);
			
			break;
		}
	}
	waitForSubUrl(tragetUrl);
}
}
