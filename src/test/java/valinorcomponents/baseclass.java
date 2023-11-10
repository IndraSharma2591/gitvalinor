package valinorcomponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {

	public WebDriver d;
	
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\Valinortest\\Valinor\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
			if(browserName.equalsIgnoreCase("chrome")) 
			{
			
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				options.merge(capabilities);
				d = new ChromeDriver(options);
				
				
		   }
			else if(browserName.equalsIgnoreCase("firefox")) 
			{
				WebDriverManager.firefoxdriver().setup();
				d = new FirefoxDriver();
		    }
			else if(browserName.equalsIgnoreCase("edge")) 
			{
				WebDriverManager.edgedriver().setup();
				d = new EdgeDriver();
			}
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			d.manage().window().maximize();
			return d;
			
			
				
	}
	
	
	@BeforeSuite
	public void launchApplication() throws IOException
	{
		d = initializeDriver();
		String baseURL = "https://master.d2xkb4vf53dwpf.amplifyapp.com/";
		
        d.get(baseURL);
        String expectedURL = "https://master.d2xkb4vf53dwpf.amplifyapp.com/";
        String actualURL = d.getCurrentUrl();
     
     	if(actualURL.contentEquals(expectedURL))
     	{
     	  System.out.println("URL Matched user panel");
     	}
     	else
     	{
     	  System.out.println("URL Mismatched user panel");
     	}
		
	}
	
	@AfterSuite
	public void closebrowser()
	{
		//d.quit();
	}
	
	
		
		
}
	

	
		

