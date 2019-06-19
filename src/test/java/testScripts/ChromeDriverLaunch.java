package testScripts;

import io.appium.java_client.android.nativekey.AndroidKey;
import java.net.MalformedURLException;


import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java .net.URL;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.*;



import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDriverLaunch {
	
	public DesiredCapabilities setCapabilities(String appPackage,String appActivity)
	{
		 DesiredCapabilities capabilities = null;
		try {
		 //System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
	    	
         
         System.out.println("==================================1========================================");
         capabilities =DesiredCapabilities.android();       
         capabilities.setCapability("browserName", "");       
         capabilities.setCapability("device", "Android");
         capabilities.setCapability("deviceName", "Mi A1");       
         capabilities.setCapability("platformName", "Android");       
         capabilities.setCapability("platformVersion", "9");             
         capabilities.setCapability("takesScreenshot", true);
         capabilities.setCapability("automationName", "uiautomator2");
         capabilities.setCapability("appPackage", appPackage);
         capabilities.setCapability("appActivity",appActivity); 
         //capabilities.setCapability("app", "D:\\Mobile Testing\\Spencer_co.spencer.proximus.beta.demo.apk");     
         capabilities.setCapability("noReset", "false");
         capabilities.setCapability("appWaitActivity", "*");
         capabilities.setCapability("newCommandTimeout", "30000");
         
 		
		}
       catch(Exception e) {
    		
    		System.out.println(e.getMessage());
    	}
		return capabilities;
	}
	

    public static void main(String[] args)  
    {
    	WebDriver driver;
    	DesiredCapabilities capabilities;
    	
    	try {
           String dataUsagePackage="com.android.settings";
            String dataUsageActivity=".Settings$DataUsageSummaryActivity";
    		capabilities=new ChromeDriverLaunch().setCapabilities(dataUsagePackage,dataUsageActivity);    		 
    		driver=new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);   		
    		Thread.sleep(5000);
    		 System.out.println("Before action 1");  		
    		 driver.findElement(By.xpath("//android.widget.TextView[@text='App data usage']")).click();
             Thread.sleep(5000);   
             String appDataUsed=driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'used')]")).getText();          
             Thread.sleep(5000);                      
             System.out.println("Total data from data usage="+appDataUsed);
             
             String youTubePackage="com.google.android.youtube";
             String youTubeActivity="com.google.android.apps.youtube.app.WatchWhileActivity";
             capabilities=new ChromeDriverLaunch().setCapabilities(youTubePackage,youTubeActivity);
             driver=new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);          
             Thread.sleep(10000);
     		 System.out.println("Before action 2");     		
     		 driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Search']")).click();
              Thread.sleep(5000);
              driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.google.android.youtube:id/search_edit_text']")).sendKeys("proximus epic");
              Thread.sleep(5000);
              driver.findElement(By.xpath("//android.widget.TextView[@text='proximus epic']")).click();
              Thread.sleep(5000);
              driver.findElement(By.xpath("(//android.widget.ImageView[@index='0'])[1]")).click();
              Thread.sleep(30000);   
              
             String epicPackage="com.proximus.millennials.millennialsapp.uat";
             String epicActivity="com.proximus.millennials.millennialsapp.MainActivity";
             System.out.println(epicPackage);
             capabilities=new ChromeDriverLaunch().setCapabilities(epicPackage,epicActivity);
             driver=new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
             Thread.sleep(15000);
             
             new ChromeDriverLaunch().clickOnButton(driver,602,1564);
    		 Thread.sleep(10000); 
    		 new ChromeDriverLaunch().clickOnButton(driver,1007,1771);
    		 Thread.sleep(10000); 
    		 new ChromeDriverLaunch().clickOnButton(driver, 998, 1780);
    		 Thread.sleep(10000);
    		 new ChromeDriverLaunch().clickOnButton(driver, 998, 1780);		 
    		 Thread.sleep(10000);
    		 driver.findElement(By.xpath("//android.widget.TextView[@text='thanks, but I will do it later']")).click(); 
    		 Thread.sleep(10000);
    		 new ChromeDriverLaunch().clickOnButton(driver, 992, 295);
    		 Thread.sleep(10000);
    		 String appDataName=driver.findElement(By.xpath("//android.widget.TextView[@text='Free App data']")).getText(); 
    		 Thread.sleep(10000);
    		 String appData=driver.findElement(By.xpath("//android.view.ViewGroup[6]/android.view.ViewGroup/android.widget.TextView[2]")).getText(); 
    		 Thread.sleep(10000);
    		 
    		 System.out.println("Data usage from epic app="+appData);
            
             
             
             driver.close();
             
    		

    	
    		
    	/*common	
           new ChromeDriverLaunch().swipe(driver);
           System.out.println("Before action 2");
           new ChromeDriverLaunch().swipe(driver);  
           System.out.println("Before action 3");
    		Thread.sleep(10000);
    		
    		 new ChromeDriverLaunch().clickOnButton(driver, 983, 1825);
    		 System.out.println("Before action 4");
    		 Thread.sleep(10000);*/
    	/*	  with xpath
          System.out.println(driver.findElement(By.xpath("//android.widget.TextView[@text='Yes']")).getText());
          driver.findElement(By.xpath("//android.widget.TextView[@text='Yes']")).click();
          Thread.sleep(7000);
          driver.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click(); 
          Thread.sleep(7000);
          driver.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click(); 
          Thread.sleep(7000);
          driver.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click(); 
          Thread.sleep(7000);
          
    		 System.out.println("Before action 5");
    		 new ChromeDriverLaunch().clickOnButton(driver, 992, 295);
    		 Thread.sleep(5000);
    		 String appDataName=driver.findElement(By.xpath("//android.widget.TextView[@text='Free App data']")).getText(); 
    		 Thread.sleep(5000);
    		 String appData=driver.findElement(By.xpath("//android.view.ViewGroup[6]/android.view.ViewGroup/android.widget.TextView[2]")).getText(); 
             
    		 
    		 System.out.println("appDataName="+appDataName+"    appData="+appData);*/
    		 
    		 
    		/* with co-ordinates
    		 new ChromeDriverLaunch().clickOnButton(driver,602,1564);
    		 Thread.sleep(10000); 
    		 new ChromeDriverLaunch().clickOnButton(driver,1007,1771);
    		 Thread.sleep(10000); 
    		 new ChromeDriverLaunch().clickOnButton(driver, 998, 1780);
    		 Thread.sleep(10000);
    		 new ChromeDriverLaunch().clickOnButton(driver, 998, 1780);		 
    		 Thread.sleep(10000);
    		 driver.findElement(By.xpath("//android.widget.TextView[@text='thanks, but I will do it later']")).click(); 
    		 Thread.sleep(10000);
    		 new ChromeDriverLaunch().clickOnButton(driver, 992, 295);
    		 Thread.sleep(10000);
    		 String appDataName=driver.findElement(By.xpath("//android.widget.TextView[@text='Free App data']")).getText(); 
    		 Thread.sleep(10000);
    		 String appData=driver.findElement(By.xpath("//android.view.ViewGroup[6]/android.view.ViewGroup/android.widget.TextView[2]")).getText(); 
    		 Thread.sleep(10000);
    		 
    		 System.out.println("appDataName="+appDataName+"    appData="+appData);*/
    		
    		System.out.println(driver.getPageSource());
    				
    	}
    	catch(Exception e) {
    		
    		System.out.println(e.getMessage());
    	}
    	
 
    }
    
    public void swipe(WebDriver driver)
    {
    	
    	new TouchAction((PerformsTouchActions) driver)
        .press(PointOption.point(1028, 691))
        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
        .moveTo(PointOption.point(10, 654))
        .release()
        .perform();
    }
    
    public void clickOnButton(WebDriver driver,int x,int y)
    {
    	
    	new TouchAction((PerformsTouchActions) driver)
        .tap(PointOption.point(x, y))
        .perform();
    }


	
    public DesiredCapabilities Cloan_setupCapabilities(String appPackage,String appActivity)
	{
		 DesiredCapabilities capabilities = null;
		try {
		 System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
	    	
         
         System.out.println("==================================1========================================");
         capabilities =DesiredCapabilities.android();       
         capabilities.setCapability("browserName", "");       
         capabilities.setCapability("device", "Android");
         capabilities.setCapability("deviceName", "Mi A1");       
         capabilities.setCapability("platformName", "Android");       
         capabilities.setCapability("platformVersion", "9");             
         capabilities.setCapability("takesScreenshot", true);
         capabilities.setCapability("automationName", "uiautomator2");
         capabilities.setCapability("appPackage", "com.android.settings");
         capabilities.setCapability("appActivity", ".Settings$DataUsageSummaryActivity"); 
      //   capabilities.setCapability("app", "D:\\Mobile Testing\\PxUAT Epic 1.3.1_6617.apk");     
         capabilities.setCapability("noReset", "false");
         capabilities.setCapability("appWaitActivity", "*");
         capabilities.setCapability("newCommandTimeout", "30000");
         
 		
		}
       catch(Exception e) {
    		
    		System.out.println(e.getMessage());
    	}
		return capabilities;
	}
 
}