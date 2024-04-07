package factory;
 
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
public class BaseClass {
 
		 static WebDriver driver;
	     static Properties p;
	     static Logger logger;
	public static WebDriver initilizeBrowser() throws IOException
	{
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//os
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
			    capabilities.setPlatform(Platform.WIN11);
			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
			    capabilities.setPlatform(Platform.MAC);
			} else {
			    System.out.println("No matching OS..");
			      }
			//browser
			if(getProperties().getProperty("browser").toLowerCase().equalsIgnoreCase("chrome"))
				  capabilities.setBrowserName("chrome");
			else if(getProperties().getProperty("browser").toLowerCase().equalsIgnoreCase("MicrosoftEdge"))
				capabilities.setBrowserName("MicrosoftEdge");
			else
			     System.out.println("No matching browser");
			     
	        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
			{
				if(getProperties().getProperty("browser").toLowerCase().equalsIgnoreCase("chrome"))
					driver=new ChromeDriver();
				else if(getProperties().getProperty("browser").toLowerCase().equalsIgnoreCase("edge"))
					driver=new EdgeDriver();
				else
			        System.out.println("No matching browser");
			      
			}
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		 return driver;
	}
	public static WebDriver getDriver() {
			return driver;
		}
 
	public static Properties getProperties() throws IOException
	{		 
        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
        p=new Properties();
		p.load(file);
		return p;
	}
	public static Logger getLogger() 
	{		 
		logger=LogManager.getLogger(); //Log4j
		return logger;
	}

}