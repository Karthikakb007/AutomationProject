package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class searchFlight {
	WebDriver driver;	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	@FindBy(xpath="/html/body/div[2]/div/main/div[2]/div/div[2]/div/div[1]/div/div[1]/button")
	WebElement tripMode;
	
	@FindBy(xpath="//*[@id=\"headlessui-listbox.option-37\"]")
	WebElement clik;
	
	@FindBy(xpath="/html/body/div[2]/div/main/div[2]/div/div[2]/div/div[1]/div/div[2]/button")
	WebElement passngr;
	
	@FindBy(xpath="//*[@id=\"headlessui-popover-panel-10\"]/div/div[1]/div[2]/div")
	WebElement adult_count; 
	
	@FindBy(xpath="//*[@id=\"headlessui-popover-panel-10\"]/div/div[1]/div[2]/button[2]")
	WebElement incCount;
	
	@FindBy(xpath="//*[@id=\"headlessui-popover-panel-10\"]/div/div[4]/button")
	WebElement done;
	
	@FindBy(xpath="/html/body/div[2]/div/main/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div/div[1]/input")
	WebElement from_city;
	
	@FindBy(xpath="/html/body/div[2]/div/main/div[2]/div/div[2]/div/div[2]/div[1]/div[1]/div/div[2]/div[2]/div")
	WebElement city;
	
	@FindBy(xpath="/html/body/div[2]/div/main/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div/div[1]/input")
	WebElement to_city;
	
	@FindBy(xpath="/html/body/div[2]/div/main/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[2]")
	WebElement city2;
	
	@FindBy(xpath="/html/body/div[2]/div/main/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div/button")
	WebElement departure;
	
	@FindBy(xpath="/html/body/div[2]/div/main/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[2]/div/div[2]/button[2]")
	WebElement next;
	
	@FindBy(xpath="/html/body/div[2]/div/main/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[2]/div/div[1]/div[2]/div[3]/div/button/div/div[1]")
	List<WebElement>alldates;
	
	@FindBy(xpath="/html/body/div[2]/div/main/div[2]/div/div[2]/div/div[2]/div[2]/div[1]/div[2]/div/div[3]/button")
	WebElement dateDone;
	
	@FindBy(xpath="/html/body/div[2]/div/main/div[2]/div/div[2]/div/div[2]/button")
	WebElement search;
	
	@FindBy(xpath="/html/body/div[2]/div/main/section[3]/div/div[1]/div[2]/div[2]/div[2]/div")
	WebElement cheapest;
	
	@FindBy(xpath="/html/body/div[2]/div/main/section[3]/div/div[2]/div[1]/div/div/div[2]/div[3]/button")
	WebElement selectFlight;
	
	@FindBy(xpath="/html/body/div[2]/div/main/section[3]/div/div[2]/div[1]/div/div[2]/div/div/button")
	WebElement bookflight;
	
	@FindBy(xpath="/html/body/div[2]/div/main/aside/div/button")
	WebElement checkout;
	
	public searchFlight(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void tripmode()
	{
	Actions select = new Actions (driver);
	select.moveToElement(tripMode);
	select.click().perform();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(clik));
	clik.click();
	
	}
	
	public void passenger()
	{
		passngr.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String count = adult_count.getText();
		while(!count.equalsIgnoreCase("3"))
		{
			incCount.click();
			break;
		}
		done.click();
	}
	
	public void from()
	{
		Actions act = new Actions (driver);
		act.click(from_city).perform();
	    act.sendKeys(from_city,"Kochi").perform();
	    act.pause(3000).perform();
		act.sendKeys(from_city, Keys.ARROW_DOWN).perform();
	    act.moveToElement(city).perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(city));
		city.click();
	}
	
	public void to()
	{
		Actions act = new Actions (driver);
	    act.click(to_city).perform();
	    act.sendKeys(to_city,"Kuala Lumpur").perform();
	    act.pause(3000).perform();
	    act.sendKeys(to_city, Keys.ARROW_DOWN).perform();
	    act.moveToElement(city2).perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(city2));
		city2.click();
	}
	
	public void datepick()
	{
		departure.click();
		next.click();
		for(WebElement dateelement: alldates)
		{
			String date = dateelement.getText();
			if(date.equals("13"))
			{
				dateelement.click();
				break;
			}
		
		}
		dateDone.click();
		 Actions actions = new Actions(driver);
		 actions.sendKeys(Keys.PAGE_UP).build().perform();
	     actions.moveToElement(search);
	     actions.click().perform();
	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	     wait.until(ExpectedConditions.visibilityOf(search));
		 search.click();

	  }
	
	public void bookFlight()
	{
		 cheapest.click();
	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	     wait.until(ExpectedConditions.visibilityOf(selectFlight));
	     selectFlight.click();
	     Actions action = new Actions(driver);
	     action.scrollToElement(bookflight);
	     bookflight.click();
	     checkout.click();
	     
	}
}