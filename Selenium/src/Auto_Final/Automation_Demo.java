package Auto_Final;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Automation_Demo extends Automation_Demo_BaseClass

{
	@Test(groups = "Functional") 
	public void TC01_Registerpage() throws InterruptedException, IOException
	
	{
		login = new FileInputStream("./Swag_login/Auto.txt");
		p = new Properties();
		p.load(login);
		String link = p.getProperty("URL");
				
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(link);
		Thread.sleep(3000);
		
		 String emailID = p.getProperty("Email");
		 String FristName = p.getProperty("FN");
		 String LastName = p.getProperty("LN");
		 String Address = p.getProperty("ADD");
		 String Phone = p.getProperty("PH");
		 String Password = p.getProperty("PS");
			
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailID);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@id='enterimg']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(FristName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(LastName);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//textarea[@rows='3']")).sendKeys(Address);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(emailID);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys(Phone);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='checkbox2']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='msdd']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class='ui-corner-all'])[8]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class='ui-corner-all'])[12]")).click();
		Thread.sleep(3000);
		WebElement language = driver.findElement(By.xpath("//select[@id='Skills']"));
		Thread.sleep(3000);
		Select li = new Select(language);
		Thread.sleep(3000);
		li.selectByVisibleText("Java");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select[@id='countries']")).click();
		Thread.sleep(3000);
		WebElement Countries = driver.findElement(By.xpath("//select[@id='country']"));
		Thread.sleep(3000);
		Select Cu = new Select(Countries);
		Cu.selectByVisibleText("Netherlands");
		Thread.sleep(3000);
		WebElement Year = driver.findElement(By.xpath("//select[@id='yearbox']"));
		Thread.sleep(3000);
		Select Yr = new Select(Year);
		Thread.sleep(3000);
		Yr.selectByVisibleText("1990");
		Thread.sleep(3000);
		WebElement Month = driver.findElement(By.xpath("(//select[@type='text'])[4]"));
		Thread.sleep(3000);
		Select Mo = new Select(Month);
		Thread.sleep(3000);
		Mo.selectByVisibleText("June");
		Thread.sleep(3000);
		WebElement Day = driver.findElement(By.xpath("//select[@id='daybox']"));
		Thread.sleep(3000);
		Select Dy = new Select(Day);
		Thread.sleep(3000);
		Dy.selectByVisibleText("25");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='firstpassword']")).sendKeys(Password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='secondpassword']")).sendKeys(Password);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='submitbtn']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='Button1']")).click();
		
		Thread.sleep(3000);
		driver.close();
		
		Reporter.log("Validate search results are displayed",true);
		
		}
	
	@Test(groups = "Smoke")
	public void TS02_Alerts() throws IOException, InterruptedException
	{
		login = new FileInputStream("./Swag_login/Auto.txt");
		p = new Properties();
		p.load(login);
		String link = p.getProperty("URLAlerts");
				
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(link);
		
		driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
   
	    driver.switchTo().defaultContent();
	    //Ref//
	  	
	    // For My Ref->  Alert with OK
	    driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
	    
	    Alert alert1 = driver.switchTo().alert();
	    
	    alert1.accept();

	    // For My Ref-> Alert with OK & Cancel 
	    driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	    
	    Alert alert2 = driver.switchTo().alert();
	    
	    alert2.accept();
	    
	    driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	    
	    Alert alert4 = driver.switchTo().alert();
	    
	    alert4.dismiss();

	    // For My Ref-> Alert with Textbox 
	    driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
	    Thread.sleep(2000);
	    Alert alert3 = driver.switchTo().alert();
	    
	    alert3.sendKeys("Vignesh");
	    
	    alert3.accept();
	    
	    driver.quit();
	    
	    	Reporter.log("Validate all the alerts",true);	
		
	}
	
	@Test(groups = "Smoke")
	public void TC03_Windows() throws IOException, InterruptedException
	{
		
		login = new FileInputStream("./Swag_login/Auto.txt");
		p = new Properties();
		p.load(login);
		String link = p.getProperty("URLWindows");
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(link);
	
		driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
		driver.switchTo().defaultContent();
		
		//Ref//
		// Open New Tab 
		driver.findElement(By.xpath("(//button[@class='btn btn-info'])[1]")).click();
		Thread.sleep(2000);
				
				
		// Open Seprate Window
				
		driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
		Thread.sleep(2000);
				
		// Open Multipe Windows
				
		driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class='btn btn-info'])[2]")).click();
		
		driver.quit();
				
		{
			Reporter.log("Validate all the Windows",true);
		}
					
	}
	
	@Test(groups = "Regression")
	public void TC04_DatePicker () throws InterruptedException, IOException
	{
		
		
			login = new FileInputStream("./Swag_login/Auto.txt");
			p = new Properties();
			p.load(login);
			String link = p.getProperty("URLDate");
					
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(link);
			
			driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
			driver.findElement(By.xpath("(//a[@data-event='click'])[1]")).click();
			driver.findElement(By.xpath("(//a[@class='ui-state-default'])[1]")).click();
			
			driver.findElement(By.xpath("//input[@id='datepicker2']")).click();
			Thread.sleep(3000);
			
			//Month
			driver.findElement(By.xpath("(//select[@class='datepick-month-year'])[1]")).click();
			Thread.sleep(2000);
			WebElement month = driver.findElement(By.xpath("(//select[@class='datepick-month-year'])[1]"));
			Thread.sleep(2000);
			Select Mn = new Select(month);
			Thread.sleep(2000);
			Mn.selectByVisibleText("November");
			Thread.sleep(2000);
			
			//Year
			driver.findElement(By.xpath("(//select[@class='datepick-month-year'])[2]")).click();
			Thread.sleep(2000);
			WebElement Years = driver.findElement(By.xpath("(//select[@class='datepick-month-year'])[2]"));
			Thread.sleep(2000);
			Select Yr = new Select(Years);
			Thread.sleep(2000);
			Yr.selectByVisibleText("2019");
			Thread.sleep(2000);
			
			//Date
			driver.findElement(By.xpath("//a[@title='Select Sunday, Nov 3, 2019']")).click();
			
			driver.quit();
			
			 Reporter.log("Date Selected sucessfully",true);
		
	}
	
	@Test(groups = "Regression")
	public void TC05_AutoComplete() throws InterruptedException
	{
		ChromeDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("https://demo.automationtesting.in/AutoComplete.html");
		 driver.findElement(By.xpath("//input[@id='searchbox']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//input[@id='searchbox']")).sendKeys("ind");
		 driver.findElement(By.xpath("//a[@id='ui-id-41']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@id='ui-id-19']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@id='ui-id-19']")).clear();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[@id='ui-id-34']")).click();
		 
		 driver.quit();
		 
		 Reporter.log("Auto Complete sucessfully updated",true);
		
	}
	
	@Test(groups = "Regression")
	public void TC06_DragAndDrop() throws InterruptedException, IOException
	{
		login = new FileInputStream("./Swag_login/Auto.txt");
		p = new Properties();
		p.load(login);
		String link = p.getProperty("URLStatic");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(link);
			
		//Ref // 
		Actions actions = new Actions(driver);
		//For Logos
        WebElement seleniumLogo = driver.findElement(By.xpath("//img[@id='angular']"));
        WebElement atLogo = driver.findElement(By.xpath("//img[@id='mongo']"));
        WebElement javaLogo = driver.findElement(By.xpath("//img[@id='node']"));

        // For Drop Area
        WebElement dropArea = driver.findElement(By.id("droparea"));

        // for Drag and drop action
        actions.dragAndDrop(seleniumLogo, dropArea).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(atLogo, dropArea).perform();
        Thread.sleep(2000);
        actions.dragAndDrop(javaLogo, dropArea).perform();
	
        //DragAndDrop2//
		
		String links = p.getProperty("URLDynamic1");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(links);
		
		Actions actions1 = new Actions(driver);
		
		//logs
		WebElement slogo = driver.findElement(By.xpath("//img[@id='angular']"));
		WebElement autologo = driver.findElement(By.xpath("//img[@id='mongo']"));
		WebElement Jlogo = driver.findElement(By.xpath("//img[@id='node']"));
		
		// drop area
		WebElement drop = driver.findElement(By.xpath("//div[@id='droparea']"));
		Thread.sleep(2000);
		
		//drag and drop
		actions1.dragAndDrop(slogo, drop).perform();
		Thread.sleep(2000);
		actions1.dragAndDrop(autologo, drop).perform();
		Thread.sleep(2000);
		actions1.dragAndDrop(slogo, drop).perform();
		
		driver.quit();
		
		Reporter.log("Drag & Drop Sucessfully completed",true);	
		
		
		
	}
	
	@Test(groups = "Smoke")
	public void TC07_Selectable() throws IOException, InterruptedException, AWTException
	{
		
		login = new FileInputStream("./Swag_login/Auto.txt");
		p = new Properties();
		p.load(login);
		String link = p.getProperty("URLSelect");
		
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(link);
		
		//Ref//
		
		driver.findElement(By.xpath("//a[@href='#Default']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[@style='text-align: left; height: 32px'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[@style='text-align: left; height: 32px'])[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[@style='text-align: left; height: 32px'])[7]")).click();
		
		//-----//
		driver.findElement(By.xpath("//a[@href='#Serialize']")).click();
		Thread.sleep(1000);
		Robot a = new Robot();
		a.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//li[@style='text-align: left; height: 32px'])[8]")).click();
		Thread.sleep(1000);
		a.keyPress(KeyEvent.VK_CONTROL);
		driver.findElement(By.xpath("(//li[@style='text-align: left; height: 32px'])[10]")).click();
		Thread.sleep(1000);
		a.keyPress(KeyEvent.VK_CONTROL);
		driver.findElement(By.xpath("(//li[@style='text-align: left; height: 32px'])[14]")).click();
		Thread.sleep(1000);
		a.keyPress(KeyEvent.VK_CONTROL);
		driver.findElement(By.xpath("(//li[@style='text-align: left; height: 32px'])[12]")).click();
		Thread.sleep(1000);
		a.keyPress(KeyEvent.VK_CONTROL);
		driver.findElement(By.xpath("(//li[@style='text-align: left; height: 32px'])[11]")).click();
		Thread.sleep(1000);
		a.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(1000);
		
		driver.quit();
		
		Reporter.log("Select & Rearrange are sucessfully displayed",true);
		
	}
		
	@Test(groups = "sanity")
	public void TC08_SummeryNote() throws InterruptedException, IOException, AWTException
	{
		
		login = new FileInputStream("./Swag_login/Auto.txt");
		p = new Properties();
		p.load(login);
		String link = p.getProperty("URLSummeryNote");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(link);
	
		//Ref //
		String notes = p.getProperty("Note");
		
		driver.findElement(By.xpath("//i[@class='note-icon-arrows-alt']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='note-editable panel-body']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='note-editable panel-body']")).sendKeys(notes);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@class='note-icon-magic']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-value='blockquote']")).click();
		Thread.sleep(2000);
		Robot a = new Robot();
		a.keyPress(KeyEvent.VK_CONTROL);
		Robot b = new Robot();
		b.keyPress(KeyEvent.VK_SHIFT);
		Robot c = new Robot();
		c.keyPress(KeyEvent.VK_E);
		
		driver.quit();
		Reporter.log("Notes updated and sucessfully displayed",true);
		
	}
	
	@Test(groups = "sanity")
	public void TC09_More_FileDownload() throws InterruptedException, IOException
	{
		
		login = new FileInputStream("./Swag_login/Auto.txt");
		p = new Properties();
		p.load(login);
		String link = p.getProperty("URLDownload");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(link);	
	
		//Ref//
		String note = p.getProperty("Cmt1");
		
		driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@id='textbox']")).sendKeys(note);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='createTxt']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='link-to-download']")).click();
	
		//Ref//
		String note1 = p.getProperty("Cmt2");
				
		driver.findElement(By.xpath("//textarea[@id='pdfbox']")).sendKeys(note1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='createPdf']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='pdf-link-to-download']")).click();
		Thread.sleep(2000);
		
		driver.quit();
		
		Reporter.log("Note & PFD downladed sucessfully",true);
	}
	
	@Test(groups = "sanity")
	public void TC10_More_DynamicData() throws IOException, InterruptedException
	{
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			
		FileInputStream login = new FileInputStream("./Swag_login/Auto.txt");
		Properties p = new Properties();
		p.load(login);
		String link = p.getProperty("URLDynamic");
		driver.get(link);	
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='save']")).click();
		Thread.sleep(2000);
		
		driver.quit();
			
		Reporter.log("Dynamic Data sucessfully diaplayed",true);
			
		}
		
		@Test(groups = "sanity")
		public void TC11_JqueryProgressBar() throws IOException, InterruptedException
		{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		FileInputStream login1 = new FileInputStream("./Swag_login/Auto.txt");
		Properties p1 = new Properties();
		p1.load(login1);
		String link1 = p1.getProperty("URLjQuery");
		driver.get(link1);	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='downloadButton']")).click();	
		Thread.sleep(6000);		
			
		driver.quit();
		
		Reporter.log("Jquery Progress Bar sucessfully diaplayed Downloaded",true);
			
		}
		
		@Test(groups = "sanity")
		public void TC12_Loader() throws IOException, InterruptedException
		{
			
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		FileInputStream login2 = new FileInputStream("./Swag_login/Auto.txt");
		Properties p2 = new Properties();
		p2.load(login2);
		String link2 = p2.getProperty("URlLoader");
		driver.get(link2);	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='loader']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();	
		Thread.sleep(6000);
			
		driver.quit();
		
		Reporter.log("Sucessfully diaplayed Loader",true);
		}
				
		@Test(groups = "sanity")
		public void TC13_URLProgressBar() throws InterruptedException, IOException
		{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		FileInputStream login3 = new FileInputStream("./Swag_login/Auto.txt");
		Properties p3 = new Properties();
		p3.load(login3);
		String link3 = p3.getProperty("URLProgressBar");
		driver.get(link3);	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='cricle-btn']")).click();
		Thread.sleep(10000);
		
		driver.quit();
		
		Reporter.log("Sucessfully ProgressBar Loaded",true);
	}
	

}
