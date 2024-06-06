package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class information {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"passengers[0].firstName\"]")
	WebElement firstname;
	
	@FindBy(xpath="//*[@id=\"passengers[0].lastName\"]")
	WebElement lastname;
	
	@FindBy(xpath="//*[@id=\"passengers[1].firstName\"]")
	WebElement firstName;
	
	@FindBy(xpath="//*[@id=\"passengers[1].lastName\"]")
	WebElement lastName;
	
	@FindBy(xpath="//*[@id=\"contact.email\"]")
	WebElement email;
	
	public information(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void informtn()
	{
		firstname.sendKeys("Karthika");
		lastname.sendKeys("KB");
		firstName.sendKeys("abc");
		lastName.sendKeys("cg");
		email.sendKeys("abc@gmail.com");	
	}
	

}
