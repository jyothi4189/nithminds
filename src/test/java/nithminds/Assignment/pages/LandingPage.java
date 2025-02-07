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
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(id="usercentrics-root")
WebElement shadowHost;
@FindBy(xpath="//li[@class='navigation-main-entry']/a")
List<WebElement> AllCategory;

public void goTo() throws IOException {
	String url = getUrl("url");
	driver.get(url);
}
public void handleCookieConsent() throws InterruptedException {

	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	
	
	 SearchContext shadowrootElement = shadowHost.getShadowRoot();
	
		WebElement acceptbutton = shadowrootElement.findElement(By.cssSelector("button[class='sc-dcJsrY eIFzaz']"));
	
	wait.until(ExpectedConditions.elementToBeClickable(acceptbutton));
		acceptbutton.click();
}
public void selectCategory(String Option) throws InterruptedException {

	System.out.println(driver.getWindowHandles().size());
	
	String tragetUrl=null;
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	
	for(WebElement eachCategory:AllCategory) {
		String text = eachCategory.getText();
		
		if(text.equalsIgnoreCase(Option)) {
			tragetUrl=eachCategory.getAttribute("href");
			eachCategory.click();
			break;
		}
	}
	wait.until(ExpectedConditions.urlContains(tragetUrl));
}
}
