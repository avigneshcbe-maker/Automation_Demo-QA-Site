package Auto_Final;

import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Automation_Demo_BaseClass 

{
	public FileInputStream login;
	public Properties p;
	public ChromeDriver driver;
	
	@BeforeClass
	
	public void openbrowser() throws IOException, InterruptedException
	{
		login = new FileInputStream("./Swag_login/Auto.txt");
		p = new Properties();
		p.load(login);
		String link = p.getProperty("URL");
				
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(link);
		Thread.sleep(3000);
				
	}
	
	@AfterClass
	
	public void	closebrowser()
	{
		driver.quit();
		
	}
	
	
}
