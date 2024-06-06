package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.information;
import page.login;
import page.searchFlight;
import utilities.excelutilities;

public class testpg {

	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		driver = new FirefoxDriver();
		driver.get("https://www.airpaz.com");
		driver.manage().window().maximize();
	}
	@Test(priority=1, enabled=false)
	public void logintest() throws Exception
	{
		login p1= new login(driver);
		p1.sigin();
		Thread.sleep(5000);
		p1.glink();
		String xl = "C:\\Users\\karth\\Desktop\\password.xlsx";
        String Sheet1="Sheet1";
        int rowCount = excelutilities.getRowCount(xl,Sheet1);

        for (int i=1;i<=rowCount;i++)
        {
        	String username=excelutilities.getCellValue(xl, Sheet1, i, 0);
            System.out.println("username---"+username);

        	String password=excelutilities.getCellValue(xl, Sheet1, i, 1); 
            System.out.println("password---"+password);
            
	          p1.loggmail(username);
	          Thread.sleep(3000);
	          p1.enterpsw(password);	
	         
		}
	}
	
	@Test(priority=2, enabled=false)
	public void searchflight() throws Exception
	{
		searchFlight p2= new searchFlight(driver); 
		p2.tripmode();
		Thread.sleep(2000);
		p2.passenger();
		Thread.sleep(1000);
		p2.from();
		Thread.sleep(2000);
		p2.to();
		Thread.sleep(1000);
		p2.datepick();
		Thread.sleep(2000);
		p2.bookFlight();
			
	}
	
	@Test(priority=3, enabled=false)
	public void informations()
	{
		information p3 = new information(driver);
		p3.informtn();
	}   

}
