package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login {
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[2]/div/main/header/div/div/a[2]/span")	
	WebElement signin;
	
	@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/div/div/div/button[2]")
	WebElement googlelink;
	
	@FindBy(id="identifierId")
	WebElement gmail;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button/span")
	WebElement gmailNext;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[2]/div/div/div[1]/form/span/section[2]/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")
	WebElement passwd;
	
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/c-wiz/div/div[3]/div/div[1]/div/div/button/span")
	WebElement pswNext;
	
	public login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void sigin()
	{
		signin.click();
	}
	public void glink()
	{
		googlelink.click();
	}
	
	public void loggmail(String userName)
	{
		
		gmail.sendKeys(userName);
		gmailNext.click();

	}
	
	public void enterpsw(String passWord)
	{
		passwd.sendKeys(passWord);
		pswNext.click();
	}

}
