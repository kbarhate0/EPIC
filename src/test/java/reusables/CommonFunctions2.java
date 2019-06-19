


package reusables;

import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import java .net.URL;
import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.screenrecording.CanRecordScreen;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.Popup;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.condition.And;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import testScripts.ExcelData;
import testScripts.ExcelRead;

public class CommonFunctions2 implements ExcelData {

                private static Properties objectMapProps;
             //   public static ThreadLocal<WebDriver> driverobj = new ThreadLocal<WebDriver>();
                private static String baseUrl;
                public static WebElement eleSearched;
                public static Robot robot;
                static WebDriver driver;
              
                           
                public DesiredCapabilities setCapabilities(String appPackage,String appActivity)
            	{
            		 DesiredCapabilities capabilities = null;
            		try {
            			//System.out.println("testtttttttttttttttt");
           
                     System.out.println("==================================1========================================");
                     capabilities =DesiredCapabilities.android();       
                   //  System.out.println("testtttttttttttttttt1111111111");
                     capabilities.setCapability("browserName", "");       
                     capabilities.setCapability("device", "Android");
                     capabilities.setCapability("deviceName", "Mi A1");       
                     capabilities.setCapability("platformName", "Android");       
                     capabilities.setCapability("platformVersion", "9");             
                     capabilities.setCapability("takesScreenshot", true);
                     capabilities.setCapability("automationName", "uiautomator2");
                     System.out.println(appPackage);
                     System.out.println(appActivity);
                     capabilities.setCapability("appPackage", appPackage);
                     capabilities.setCapability("appActivity",appActivity); 
                  //   capabilities.setCapability("app", "D:\\Mobile Testing\\PxUAT Epic 1.3.1_6617.apk");     
                     capabilities.setCapability("noReset", "false");
                     capabilities.setCapability("appWaitActivity", "*");
                     capabilities.setCapability("newCommandTimeout", "30000");
                     
                    // captureScreenshot("app", driver);
                     
                    // System.out.println("testtttttttttttttttt1111111111");
                     ExcelRead.testCaseStatus = "pass";
             		
            		}
                   catch(Exception e) {
                	   
                	   ExcelRead.testCaseStatus = "fail";
                		
                		System.out.println(e.getMessage());
                	}
            		return capabilities;
            	}
            	
                public DesiredCapabilities setCapabilitiesWithAPK(String apk)
            	{
            		 DesiredCapabilities capabilities = null;
            		try {
            			//System.out.println("testtttttttttttttttt");
           
                     System.out.println("==================================1========================================");
                     capabilities =DesiredCapabilities.android();       
                   //  System.out.println("testtttttttttttttttt1111111111");
                     capabilities.setCapability("browserName", "");       
                     capabilities.setCapability("device", "Android");
                     capabilities.setCapability("deviceName", "Mi A1");       
                     capabilities.setCapability("platformName", "Android");       
                     capabilities.setCapability("platformVersion", "9");             
                     capabilities.setCapability("takesScreenshot", true);
                     capabilities.setCapability("automationName", "uiautomator2");
                   //  System.out.println(appPackage);
                   //  System.out.println(appActivity);
                   //  capabilities.setCapability("appPackage", appPackage);
                    // capabilities.setCapability("appActivity",appActivity); 
                     capabilities.setCapability("app", apk);     
                     capabilities.setCapability("noReset", "false");
                     capabilities.setCapability("appWaitActivity", "6000000");
                     capabilities.setCapability("newCommandTimeout", "300000");
                     
                    // captureScreenshot("app", driver);
                 
                    // System.out.println("testtttttttttttttttt1111111111");
                     ExcelRead.testCaseStatus = "pass";
             		
            		}
                   catch(Exception e) {
                	   
                	   ExcelRead.testCaseStatus = "fail";
                		
                		System.out.println(e.getMessage());
                	}
            		return capabilities;
            	}
                public static void setupMobileDriverWithAPK(String apk)
                {
                	try {
                  // WebDriver driver;
                		
                  
                	DesiredCapabilities capabilities=new CommonFunctions2().setCapabilitiesWithAPK(apk); 
                	
            		driver=new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            	  Thread.sleep(2000000);
            		// System.out.println("testtttttttttttttttt");
            	  
            	  
            		 ExcelRead.testCaseStatus = "pass";
            		 
                	}
                	catch(Exception e) {
                		ExcelRead.testCaseStatus = "fail";
                		System.out.println(e.getMessage());
                	}
                }
                
                
                public static void setupMobileDriver(String dataUsagePackage,String dataUsageActivity)
                {
                	try {
                  // WebDriver driver;
                		
                  
                	DesiredCapabilities capabilities=new CommonFunctions2().setCapabilities(dataUsagePackage,dataUsageActivity); 
                	
            		driver=new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
            	  Thread.sleep(20000);
            		 System.out.println("testtttttttttttttttt");
              	//captureScreenshot(UUID.randomUUID().toString(), driver);
            		 CommonFunctions2.clickOnButton(driver, "530", "125");
              
              	 System.out.println("testtttttttttttttttt1111111111111");
            		 ExcelRead.testCaseStatus = "pass";
            		 
                	}
                	catch(Exception e) {
                		ExcelRead.testCaseStatus = "fail";
                		System.out.println(e.getMessage());
                	}
                }
                
                public static void swipe(WebDriver driver1)
                {
                	try {
                	
                	 new TouchAction((PerformsTouchActions) driver)
                    .press(PointOption.point(1028, 691))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                    .moveTo(PointOption.point(10, 654))
                    .release()
                    .perform();
                	
                 	captureScreenshot(UUID.randomUUID().toString(), driver);
                	 ExcelRead.testCaseStatus = "pass";
                	}
                	catch(Exception e)
                	{
                		ExcelRead.testCaseStatus = "fail";
                		System.out.println(e.getMessage());
                	}
                }
                public static void clickOnButton(WebDriver driver1,String x,String y)
                {
                	try {
                	int xCordinate=Integer.parseInt(x);
                	int yCordinate=Integer.parseInt(y);
                	new TouchAction((PerformsTouchActions) driver)
                    .tap(PointOption.point(xCordinate, yCordinate))
                    .perform();
                	captureScreenshot(UUID.randomUUID().toString(), driver);
                	ExcelRead.testCaseStatus = "pass";
                	}
                	catch(Exception e)
                	{
                		ExcelRead.testCaseStatus = "fail";
                		System.out.println(e.getMessage());
                	}
                }
                

                public static void sleep(String millSecs) {
                                long millSec = Integer.parseInt(millSecs) * 1000;
                                try {
                                                Thread.sleep(millSec);
                                                ExcelRead.testCaseStatus = "pass";
                                } catch (NumberFormatException e) {
                                                e.printStackTrace();
                                } catch (InterruptedException e) {
                                                e.getMessage();
                                }
                }

               
                public static void waitForAction() {
                                try {
                                                System.out.println("Before waitForACtion");
                                                JOptionPane.showMessageDialog(null, "To Continue Press OK.");
                                                System.out.println("After waitForACtion");
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception e) {
                                                e.printStackTrace();
                                }
                }
                
                public static void getDifference(String s1, String s2, String s3) {
                    try {
                    	double i = Double.parseDouble(s1.substring(0,s1.indexOf(" ")));
                    	double j = Double.parseDouble(s2.substring(0,s2.indexOf(" ")));
                    	 ExcelRead.runTimeVar.put(s3, (j-i) +"");
                    	 System.out.println(ExcelRead.runTimeVar.get(s3));
                    	 //System.out.println(ExcelRead.retRunTimeVar("::TCIP "));
                    	 
                    	 ExcelRead.testCaseStatus="Pass";
  
                    }catch (Exception ex) {
                    	ExcelRead.testCaseStatus="Fail";
                        ExcelRead.testCaseError =ex.getMessage();
                    }
    }

                public static void replaceToVariable(String xmlValue, String keys, String values, String variableName)
                                                throws IOException {
                                if (xmlValue.contains("TEMP")) {
                                                xmlValue = ExcelRead.runTimeVar.get(xmlValue);
                                } else {
                                                System.out.println("in conversion");
                                                File loadFile = new File(xmlValue);
                                                StringBuffer fileContents = new StringBuffer();
                                                @SuppressWarnings("resource")
                                                BufferedReader input = new BufferedReader(new FileReader(loadFile));
                                                String line = null;
                                                while ((line = input.readLine()) != null) {
                                                                Matcher junkMatcher = (Pattern.compile("^([\\W]+)<")).matcher(line.trim());
                                                                line = junkMatcher.replaceFirst("<");
                                                                fileContents.append(line);
                                                }
                                                xmlValue = fileContents.toString();
                                }
                                System.out.println("Before conversion : " + xmlValue);
                                String keys1[] = keys.split(",");
                                String values1[] = values.split(",");
                                for (int i = 0; i < keys1.length; i++) {
                                                if (values1[i].contains("TEMP")) {
                                                                xmlValue = xmlValue.replaceAll(keys1[i], ExcelRead.runTimeVar.get(values1[i]));
                                                                System.out.println(xmlValue);
                                                } else {
                                                                xmlValue = xmlValue.replaceAll(keys1[i], values1[i]);
                                                                System.out.println(xmlValue);
                                                }
                                }
                                ExcelRead.runTimeVar.put(variableName, xmlValue);
                }

          
                public static void printValue(String Message, String value) {

                                try {
                                                System.out.println(Message + " : " + value);
                                                ExcelRead.testCaseStatus = "pass";
                                                ExcelRead.testCasePrint = Message + " : " + value;
                                                CommonFunctions2.rfWriteToExcel2(ExcelRead.currTestCaseId, value);
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception e) {
                                                // TODO Auto-generated catch block
                                                e.getMessage();
                                                ExcelRead.testCaseError = e.getMessage();
                                                CommonFunctions2.rfWriteToExcel2(ExcelRead.currTestCaseId, e.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                }
                }

               
               

                public static void selectAutoComplete(String elename, String value, WebDriver driver1) {
                                try {
                                                String rfElemenntSearch = null;
                                               // captureScreenshot(elename, driver);
                                                rfElemenntSearch = elementSearch(driver1, elename);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                ExcelRead.testCaseStatus = "pass";
                                                                eleSearched.clear();
                                                                System.out.println("Sending this :  " + value + " to " + elename);
                                                                eleSearched.sendKeys(value);
                                                                System.out.println("Sent this : " + value + " to " + elename);
                                                                Thread.sleep(8000);
                                                                eleSearched.sendKeys(Keys.DOWN);
                                                                Thread.sleep(5000);
                                                                eleSearched.sendKeys(Keys.TAB);
                                                                System.out.println("Selected the value from auto complete checkbox");
                                                } else {
                                                                ExcelRead.testCaseStatus = "fail";
                                                                // need to write
                                                                System.out.println("Element not found " + rfElemenntSearch);
                                                }
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception ex) {
                                                // need to write
                                                ExcelRead.testCaseError = ex.getMessage();
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ex.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                }
                }

               

                public static void setPropFile(String configpath) {
                                objectMapProps = new Properties();

                                InputStream fis;
                                try {
                                                fis = new FileInputStream(configpath);
                                                objectMapProps.load(fis);
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (IOException e) {
                                                e.getMessage();
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, e.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                }
                }

                public static String getObjectValue(String objectName) {
                                String propValue = objectMapProps.getProperty(objectName);
                                System.out.println("Property value of element" + objectName + " is " + propValue);
                                return propValue;
                }

                public static String[] getObjectValue2(String objectName) {
                                String arr[] = null;
                                try {
                                                arr = objectMapProps.getProperty(objectName).split(":");
                                                System.out.println("Element name is : " + arr[0] + " Element type is : " + arr[1]);
                                }catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                } catch (Exception e) {
                                                // need to write
                                                e.printStackTrace();
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, "Element not present in the property file");
                                                ExcelRead.testCaseStatus = "fail";
                                                ExcelRead.testCaseError = "Element not present in the property file";
                                }
                                return arr;
                }

                public static void captureScreenshot(String screenshotFileName, WebDriver driver1) {

                                try {
                                                File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                                                System.out.println("Source file:-"+scrFile);
                                                System.out.println("screenshotFileName:-"+screenshotFileName);
                                                FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\WWS_GUI\\errorScreens\\"
                                                                                + LocalDate.now() + "\\" + ExcelRead.currTestCaseName + "\\" + screenshotFileName + ".jpg"));
                                                ExcelRead.screenshotPath = System.getProperty("user.dir") + "\\WWS_GUI\\errorScreens\\" + LocalDate.now()
                                                                                + "\\" + ExcelRead.currTestCaseName + "\\" + screenshotFileName + ".jpg";
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (IOException e1) {
                                                e1.printStackTrace();
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, e1.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                } catch (NullPointerException npe) {
                                                ExcelRead.screenshotPath = System.getProperty("user.dir") + "\\WWS_GUI\\errorScreens\\" + LocalDate.now()
                                                                                + "\\" + ExcelRead.currTestCaseName + "\\" + screenshotFileName + ".jpg";
                                                npe.printStackTrace();
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, npe.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                }

                }

                public static void goToBaseUrl(WebDriver driver1) {
                                driver1.get(baseUrl);
                }

                public static String elementSearch(WebDriver driver1, String locator) throws InterruptedException {
                                try {
                                                String element[] = null;
                                                element = getObjectValue2(locator);
                                                // System.out.println(element);
                                                WebDriverWait wait = new WebDriverWait(driver, 50);
                                                Thread.sleep(500);
                                                if (element[1].trim().equalsIgnoreCase("id")) {
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element[0])));
                                                                eleSearched = driver.findElement(By.id(element[0]));
                                                                return "Pass";
                                                } else if (element[1].trim().equalsIgnoreCase("xpath")) {
                                                                System.out.println("in xpath");
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element[0])));
                                                                eleSearched = driver.findElement(By.xpath(element[0]));
                                                                return "Pass";
                                                } else if (element[1].trim().equalsIgnoreCase("name")) {
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(element[0])));
                                                                eleSearched = driver.findElement(By.name(element[0]));
                                                                return "Pass";
                                                } else if (element[1].trim().equalsIgnoreCase("linkText")) {
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(element[0])));
                                                                eleSearched = driver.findElement(By.linkText(element[0]));
                                                                return "Pass";
                                                } else if (element[1].trim().equalsIgnoreCase("cssSelector")) {
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element[0])));
                                                                eleSearched = driver.findElement(By.cssSelector(element[0]));
                                                                return "Pass";
                                                } else if (element[1].trim().equalsIgnoreCase("partialLinkText")) {
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element[0])));
                                                                eleSearched = driver.findElement(By.partialLinkText(element[0]));
                                                                return "Pass";
                                                } else if (element[1].trim().equalsIgnoreCase("tagName")) {
                                                                wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(element[0])));
                                                                eleSearched = driver.findElement(By.partialLinkText(element[0]));
                                                                return "Pass";
                                                } else {
                                                                return "Fail@" + "please select valid locator type";
                                                }
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                                return "Fail";
                                }catch (Exception ex) {
                                              //  captureScreenshot(locator, driverobj.get());
                                                ExcelRead.testCaseError = "Not able to find element on screen due to exception >>> " + ex.getMessage()
                                                                                + " Please check element name";
                                                System.out.println(ExcelRead.testCaseError);
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ExcelRead.testCaseError);
                                                ExcelRead.testCaseStatus = "fail";
                                                return "Fail@" + ex.getMessage();

                                }

                }

               
                public static void elementclick(String locator, WebDriver driver1) {
                                try {
                                                String rfElemenntSearch = null;
                                                rfElemenntSearch = elementSearch(driver1, locator);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                ExcelRead.testCaseStatus = "pass";
                                                                System.out.println("Clicking on :  " + locator);
                                                                System.out.println(eleSearched.getText());
                                                                 WebDriverWait wait = new WebDriverWait(driver1, 10);
                                                                 wait.until(ExpectedConditions.elementToBeClickable(eleSearched));
                                                                // ((JavascriptExecutor)
                                                                // driver1).executeScript("arguments[0].click();", eleSearched);
                                                               // Alert alert = driver1.switchTo().alert();
                                                                
                                                              //  System.out.println("Alert              "+alert);
                                                                

                                                                
                                                                JavascriptExecutor executor = (JavascriptExecutor)driver1;
                                                                executor.executeScript("arguments[0].click();", eleSearched);
                                                                
                                                                //eleSearched.click();
                                                               
                                                                Thread.sleep(200);
                                                                System.out.println("Clicked on : " + locator);
                                                } else {
                                                                // need to write
                                                                ExcelRead.testCaseStatus = "fail";
                                                                System.out.println("Status is : " + rfElemenntSearch);
                                                                System.out.println("Element not found " + locator);
                                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ExcelRead.testCaseError);
                                                }
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception ex) {
                                                // need to write
                                                ExcelRead.testCaseError = ex.getMessage();
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ex.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                                System.out.println("Element not clickable ");
                                }
                }

                public static void elementclickWithoutJS(String locator, WebDriver driver1) {
                	
                	
                    try {
                                    String rfElemenntSearch = null;
                                    
                                    rfElemenntSearch = elementSearch(driver, locator);
                                    if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                    ExcelRead.testCaseStatus = "pass";
                                                    System.out.println("Clicking on :  " + locator);
                                                    System.out.println(eleSearched.getText());
                                                     WebDriverWait wait = new WebDriverWait(driver, 10);
                                                     wait.until(ExpectedConditions.elementToBeClickable(eleSearched));
                                                    // ((JavascriptExecutor)
                                                    // driver1).executeScript("arguments[0].click();", eleSearched);
                                                   // JavascriptExecutor executor = (JavascriptExecutor)driver1;
                                                   // executor.executeScript("arguments[0].click();", eleSearched);
                                                  //  Alert alert = driver1.switchTo().alert();
                                                   // System.out.println("Alert              "+alert);
                                                     Thread.sleep(10000);
                                                    eleSearched.click();
                                                    
                                                    //eleSearched.submit();
                                                   
                                                    Thread.sleep(200);
                                                    System.out.println("Clicked on : " + locator);
                                                    captureScreenshot(locator, driver);
                                                    ExcelRead.testCaseStatus = "pass";
                                    } else {
                                                    // need to write
                                    	  captureScreenshot(locator, driver);
                                                    ExcelRead.testCaseStatus = "fail";
                                                    System.out.println("Status is : " + rfElemenntSearch);
                                                    System.out.println("Element not found " + locator);
                                                    CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ExcelRead.testCaseError);
                                    }
                    } catch(NoClassDefFoundError ex){
                    	 //captureScreenshot(locator, driver);
                                    ExcelRead.testCaseStatus="Fail";
                                    ExcelRead.testCaseError =ex.getMessage();
                    }catch (Exception ex) {
                    	// captureScreenshot(locator, driver);
                                    // need to write
                                    ExcelRead.testCaseError = ex.getMessage();
                                    CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ex.getMessage());
                                    ExcelRead.testCaseStatus = "fail";
                                    System.out.println("Element not clickable ");
                    }
    }
                

                public static void handleAlertBox(WebDriver driver1) {
                    try {
                                    String rfElemenntSearch = null;
                                 
                                   
                                                    ExcelRead.testCaseStatus = "pass";
                                                    
                                                   // System.out.println(eleSearched.getText());
                                                  //  ((JavascriptExecutor) driver1).executeScript("window.confirm = function(msg) { return true; }");
                                                  // WebDriverWait wait = new WebDriverWait(driver1, 10);
                                                   // wait.until(ExpectedConditions.alertIsPresent());
                                                    
                                                    Alert alert = driver1.switchTo().alert();
                                                   // System.out.println("Alert              "+alert.getText());
                                                    alert.accept();

                                 
                                                    
                                            
                    } catch(UnhandledAlertException ex){
                    	 Alert alert = driver1.switchTo().alert();
                         // System.out.println("Alert              "+alert.getText());
                          alert.accept();
                                   
                    }catch (Exception ex) {
                                    // need to write
                    			ExcelRead.testCaseStatus="Fail";
                    			ExcelRead.testCaseError =ex.getMessage();
                                    ExcelRead.testCaseError = ex.getMessage();
                                    CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ex.getMessage());
                                    ExcelRead.testCaseStatus = "fail";
                                    System.out.println("Element not clickable ");
                    }
    }
                
                public static void linkClick(String locator, WebDriver driver1) {
                    try {
                                    String rfElemenntSearch = null;
                                    rfElemenntSearch = elementSearch(driver1, locator);
                                    if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                    ExcelRead.testCaseStatus = "pass";
                                                    System.out.println("Clicking on :  " + locator);
                                                    System.out.println(eleSearched.getText());
                                                    // WebDriverWait wait = new WebDriverWait(driver1, 10);
                                                    // wait.until(ExpectedConditions.elementToBeClickable(eleSearched));
                                                    // ((JavascriptExecutor)
                                                    // driver1).executeScript("arguments[0].click();", eleSearched);
                                                    eleSearched.click();
                                                    Thread.sleep(200);
                                                    System.out.println("Clicked on : " + locator);
                                    } else {
                                                    // need to write
                                                    ExcelRead.testCaseStatus = "fail";
                                                    System.out.println("Status is : " + rfElemenntSearch);
                                                    System.out.println("Element not found " + locator);
                                                    CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ExcelRead.testCaseError);
                                    }
                    } catch(NoClassDefFoundError ex){
                                    ExcelRead.testCaseStatus="Fail";
                                    ExcelRead.testCaseError =ex.getMessage();
                    }catch (Exception ex) {
                                    // need to write
                                    ExcelRead.testCaseError = ex.getMessage();
                                    CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ex.getMessage());
                                    ExcelRead.testCaseStatus = "fail";
                                    System.out.println("Element not clickable ");
                    }
    }
                
                
                public static void drawLine(String locator, WebDriver driver1) {
                    try {
                                    
                    	
                    	String rfElemenntSearch = null;
                        rfElemenntSearch = elementSearch(driver1, locator);
                        if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                        ExcelRead.testCaseStatus = "pass";
                                        System.out.println("Clicking on :  " + locator);
                                        System.out.println(eleSearched.getText());
                                       
                                        Actions builder = new Actions(driver1);
                                   	     Action drawAction = builder.moveToElement(eleSearched,135,15) 
                                   	     .click()
                                   	     .moveByOffset(200, 60) 
                                   	     .click()
                                   	     .moveByOffset(100, 70) 
                                   	     .doubleClick()
                                   	     .build();
                                   	    drawAction.perform();
                                        Thread.sleep(200);
                                       
                        } else {
                                        
                                        ExcelRead.testCaseStatus = "fail";
                                        System.out.println("Status is : " + rfElemenntSearch);
                                        System.out.println("Element not found " + locator);
                                        CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ExcelRead.testCaseError);
                        }
                    	
                    	
                    } catch(NoClassDefFoundError ex){
                                    ExcelRead.testCaseStatus="Fail";
                                    ExcelRead.testCaseError =ex.getMessage();
                    }catch (Exception ex) {
                                    // need to write
                                    ExcelRead.testCaseError = ex.getMessage();
                                    CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ex.getMessage());
                                    ExcelRead.testCaseStatus = "fail";
                                    System.out.println("Element not clickable ");
                    }
    }

                /*
                * Method : multipleClicks Input : Elements names separated by comma It will
                * click the non of elements passed to the method Editor : PranayKumar
                * Infosys ltd
                */
                public static void multipleClicks(String elements, WebDriver driver1) {
                                try {
                                                String rfElemenntSearch = null;

                                                String[] elementList = new String[20];
                                                elementList = elements.split(",");
                                                int size = elementList.length;
                                                for (int i = 0; i < size; i++) {
                                                                rfElemenntSearch = elementSearch(driver1, elementList[i]);
                                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                                ExcelRead.testCaseStatus = "pass";
                                                                                System.out.println("Clicking on :  " + elementList[i]);
                                                                                System.out.println(eleSearched.getText());
                                                                                WebDriverWait wait = new WebDriverWait(driver1, 10);
                                                                                wait.until(ExpectedConditions.elementToBeClickable(eleSearched));
                                                                                ((JavascriptExecutor) driver1).executeScript("arguments[0].click();", eleSearched);
                                                                                Thread.sleep(200);
                                                                                System.out.println("Clicked on : " + elementList[i]);
                                                                } else {
                                                                                ExcelRead.testCaseStatus = "fail";
                                                                                System.out.println("Status is : " + rfElemenntSearch);
                                                                                System.out.println("Element not found " + elementList[i]);
                                                                }
                                                }

                                }catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                } catch (Exception ex) {
                                                // need to write
                                                ExcelRead.testCaseError = ex.getMessage();
                                                ex.getMessage();
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ex.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                                System.out.println("Element not clickable ");
                                }
                }

                /*
                * Method : doubleClick Input : Element name Double clicks on the given
                * element using Action class Editor : PranayKumar Infosys ltd
                */
                public static void doubleClick(String locator, WebDriver driver1) {
                                try {
                                                String rfElemenntSearch = null;
                                                rfElemenntSearch = elementSearch(driver1, locator);

                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                ExcelRead.testCaseStatus = "pass";
                                                                System.out.println("Double Clicking on :  " + locator);
                                                                System.out.println(eleSearched.getText());
                                                                WebDriverWait wait = new WebDriverWait(driver1, 10);
                                                                wait.until(ExpectedConditions.elementToBeClickable(eleSearched));
                                                                Actions action = new Actions(driver1);
                                                                action.moveToElement(eleSearched).doubleClick().perform();
                                                                Thread.sleep(200);
                                                                System.out.println("Double Clicked on : " + locator);
                                                } else {
                                                                // need to write
                                                                ExcelRead.testCaseStatus = "fail";
                                                                System.out.println("Status is : " + rfElemenntSearch);
                                                                System.out.println("Element not found " + locator);
                                                }
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception ex) {
                                                // need to write
                                                ExcelRead.testCaseError = ex.getMessage();
                                                ex.getMessage();
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ex.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                                System.out.println("Element not clickable ");
                                }
                }

                /*
                * Method : highlightElement Inputs : Locator and WebDriver It will locate
                * the element and set the property of the elements to background yellow and
                * give border using JavascriptExecutor
                */
                public static void highlightElement(String locator, WebDriver driver1) {
                                try {
                                                String rfElemenntSearch = null;
                                                rfElemenntSearch = elementSearch(driver1, locator);

                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                ExcelRead.testCaseStatus = "pass";
                                                                JavascriptExecutor js = (JavascriptExecutor) driver1;
                                                                js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');",
                                                                                                eleSearched);

                                                } else {
                                                                // need to write
                                                                ExcelRead.testCaseStatus = "fail";
                                                                System.out.println("Status is : " + rfElemenntSearch);
                                                                System.out.println("Element not found " + locator);
                                                }
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception ex) {
                                                // need to write
                                                ExcelRead.testCaseError = ex.getMessage();
                                                ex.getMessage();
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ex.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                                System.out.println("Element not clickable ");
                                }
                }

                public static void sendValue(String elename, String value, WebDriver driver1) {
                
                                try {
                                                String rfElemenntSearch = null;
                                                
                                                rfElemenntSearch = elementSearch(driver, elename);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                ExcelRead.testCaseStatus = "pass";
                                                                System.out.println("Sending this :  " + value + " to " + elename);
                                                                eleSearched.clear();
                                                                Thread.sleep(10000);
                                                                eleSearched.sendKeys(value);
                                                                Thread.sleep(5000);
                                                                //eleSearched.sendKeys(Keys.TAB);
                                                              //  captureScreenshot(elename, driver);
                                                                System.out.println("Sent this : " + value + " to " + elename);
                                                            	//captureScreenshot(elename, driver);
                                                                ExcelRead.testCaseStatus = "pass";
                                                } else {
                                                                ExcelRead.testCaseStatus = "fail";
                                                                // need to write
                                                                System.out.println("Element not found " + rfElemenntSearch);
                                                }
                                } catch(NoClassDefFoundError ex){
                                	captureScreenshot(elename, driver);
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception ex) {
                                                // need to write
                                	captureScreenshot(elename, driver);
                                                ExcelRead.testCaseError = ex.getMessage();
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ex.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                                System.out.println(ex.getMessage());
                                }
                }

                public static void clear(String elename, WebDriver driver1) {
                                try {
                                                String rfElemenntSearch = null;
                                                rfElemenntSearch = elementSearch(driver1, elename);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                System.out.println("Clearing the field " + elename);
                                                                eleSearched.clear();
                                                                System.out.println("Cleared the field " + elename);
                                                } else {
                                                                ExcelRead.testCaseStatus = "fail";
                                                                // need to write
                                                                System.out.println("Element not found " + rfElemenntSearch);
                                                                // need to write
                                                }
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception ex) {
                                                ExcelRead.testCaseError = ex.getMessage();
                                                ex.getMessage();
                                                // need to write
                                }
                }

                public static void selectDate(String elename, String dateValue, WebDriver driver1) {

                                try {
                                                SimpleDateFormat formatter = new SimpleDateFormat("yyyyddMM");
                                                Date date = formatter.parse(dateValue);
                                                // System.out.println(date.toString());

                                                // Get all the data of the date
                                                String strYear = (new SimpleDateFormat("yyyy")).format(date);
                                                System.out.println(strYear);
                                                String strMonth = (new SimpleDateFormat("MMM")).format(date);
                                                System.out.println(strMonth);
                                                String strDate = (new SimpleDateFormat("d")).format(date);
                                                System.out.println(strDate);

                                                String rfElemenntSearch = null;
                                                rfElemenntSearch = elementSearch(driver1, elename);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                System.out.println("Pass");

                                                                // click the calender icon of the calender field
                                                                WebDriverWait wait = new WebDriverWait(driver1, 10);
                                                                wait.until(ExpectedConditions.elementToBeClickable(eleSearched));
                                                                ((JavascriptExecutor) driver1).executeScript("arguments[0].click();", eleSearched);
                                                                Thread.sleep(200);
                                                                System.out.println("Clicked");
                                                                Thread.sleep(2000);

                                                                // select the Month
                                                                // month_input is an xpath
                                                                rfElemenntSearch = elementSearch(driver1, "month_input");
                                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                                eleSearched.sendKeys(strMonth);
                                                                                String month = eleSearched.getAttribute("value");
                                                                                System.out.println("Month after selection : " + month);
                                                                } else {
                                                                                System.out.println("Month field not found");
                                                                }

                                                                // select the year
                                                                // year_input is an xpath
                                                                rfElemenntSearch = elementSearch(driver1, "year_input");
                                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                                eleSearched.sendKeys(strYear);
                                                                                String year = eleSearched.getAttribute("value");
                                                                                System.out.println("Year after slection : " + year);
                                                                } else {
                                                                                System.out.println("Year field not found");
                                                                }

                                                                Thread.sleep(2000);

                                                                // select the date from the table using anchor tag and click on
                                                                // the anchor tag to click the date
                                                                // date_table is an xpath
                                                                rfElemenntSearch = elementSearch(driver1, "date_table");
                                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                                List<WebElement> td = eleSearched.findElements(By.tagName("a"));
                                                                                {
                                                                                                for (WebElement data : td) {
                                                                                                                String value = data.getText();
                                                                                                                System.out.println("Td value is " + value);
                                                                                                                if (value.equalsIgnoreCase(strDate) && data.isEnabled()) {
                                                                                                                                wait = new WebDriverWait(driver1, 10);
                                                                                                                                wait.until(ExpectedConditions.elementToBeClickable(data));
                                                                                                                                ((JavascriptExecutor) driver1).executeScript("arguments[0].click();", data);
                                                                                                                                System.out.println("date selected");
                                                                                                                }
                                                                                                }
                                                                                }

                                                                } else {
                                                                                System.out.println("Date table not found");
                                                                }
                                                } else {
                                                                System.out.println("Calender icon not found");
                                                }
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception e) {
                                                System.out.println(e.getMessage());
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, e.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                                ExcelRead.testCaseError = e.getMessage();
                                }

                }

                public static void getText(String elename, String variableName, WebDriver driver1) {
                                try {
                                                String rfElemenntSearch = elementSearch(driver1, elename);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                System.out.println("Value found is " + eleSearched.getText());
                                                                ExcelRead.runTimeVar.put(variableName, eleSearched.getText());
                                                                ExcelRead.testCaseStatus = "pass";
                                                } else {
                                                                System.out.println();
                                                                ExcelRead.testCaseError = rfElemenntSearch;
                                                                ExcelRead.testCaseStatus = "fail";
                                                }
                                }catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                } catch (Exception e) {
                                                ExcelRead.testCaseError = e.getMessage();
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, e.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                }
                }

                /*
                * Function : Get Text from an element and compare with element provided in
                * Parameter Input Parameters : ElementName present in properties file name
                * you need to fetch value , WebDriver
                * 
                 * Excel input as : Elename , TagName , ValueTo Compare
                * 
                 */
                public static String getTextandCompare(String elename, String value2Compare, WebDriver driver1) {

                                String text = null;
                                try {
                                                String rfElemenntSearch = elementSearch(driver1, elename);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                text = eleSearched.getText();
                                                                if (text.equalsIgnoreCase("")) {
                                                                                ExcelRead.testCaseStatus = "fail";
                                                                                ExcelRead.testCaseError = "No value in the element : " + elename;
                                                                                System.out.println("No value in the element : " + elename);
                                                                } else {
                                                                                if (value2Compare.equalsIgnoreCase(text)) {
                                                                                                ExcelRead.testCaseStatus = "pass";
                                                                                                System.out.println(
                                                                                                                                "Value matching with given value : " + value2Compare + " and web value " + text);
                                                                                } else {

                                                                                                ExcelRead.testCaseStatus = "fail";
                                                                                                ExcelRead.testCaseError = "Value not matching";
                                                                                                System.out.println(
                                                                                                                                "Value not matching with given value : " + value2Compare + " and web value " + text);
                                                                                }
                                                                }
                                                } else {
                                                                //captureScreenshot(elename, driverobj.get());
                                                                ExcelRead.testCaseStatus = "fail";
                                                                System.out.println("Element not found " + rfElemenntSearch);
                                                }
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception e) {
                                                // write something here
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, e.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                                ExcelRead.testCaseError = e.getMessage();
                                }
                                return text;
                }

                /*
                * Function : Get Text from an element and compare with element provided in
                * Parameter Input Parameters : ElementName present in properties file , Tag
                * name you need to fetch value , WebDriver
                * 
                 * Excel input as : Elename , TagName , ValueTo Compare
                * 
                 */
                public static void getAttrandCompareWith(String elename, String tagName, String value2Compare, WebDriver driver1) {

                                String text = "";

                                try {
                                                String rfElemenntSearch = elementSearch(driver1, elename);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                text = eleSearched.getAttribute(tagName);
                                                                if (text.equalsIgnoreCase("")) {
                                                                                ExcelRead.testCaseStatus = "fail";
                                                                                ExcelRead.testCaseError = "No value in the element : " + elename;
                                                                                System.out.println("No value in the element : " + elename);
                                                                } else {
                                                                                if (value2Compare.equalsIgnoreCase(text)) {
                                                                                                ExcelRead.testCaseStatus = "pass";
                                                                                                System.out.println(
                                                                                                                                "Value matching with given value : " + value2Compare + " and tag value :  " + text);
                                                                                } else {
                                                                                                ExcelRead.testCaseStatus = "fail";
                                                                                                ExcelRead.testCaseError = "Value not matching";
                                                                                                System.out.println(
                                                                                                                                "Value not matching with given value : " + value2Compare + " and tag value " + text);
                                                                                }
                                                                }
                                                } else {
                                                                ExcelRead.testCaseStatus = "fail";
                                                                System.out.println("Element not found " + rfElemenntSearch);
                                                }
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (InterruptedException e) {
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, e.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                                ExcelRead.testCaseError = e.getMessage();
                                                e.printStackTrace();
                                }
                }

                /*
                * Mehtod Name : selectDropDown Inputs : Element Name , Dropdown value ,
                * WebDriver Working : Value of the dropdown will be selected based on the
                * value provided by the use it might be ByValue , ByIndex , By Text.
                * Autohor : PranayakUmar Adepu : Infosys ltd
                */

                public static void selectDropDown(String elename, String value, WebDriver driver1) {
                                try {
                                                int i;
                                                String rfElemenntSearch = elementSearch(driver1, elename);
                                                String[] temp = value.split(":");
                                                Select select = new Select(eleSearched);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                System.out.println("Trying to select from Dropdown-----------");
                                                                if (temp[1].equalsIgnoreCase("text")) {
                                                                                select.selectByVisibleText(temp[0]);
                                                                } else if (temp[1].equalsIgnoreCase("index")) {
                                                                                i = Integer.parseInt(temp[0]);
                                                                                select.selectByIndex(i);
                                                                } else if (temp[1].equalsIgnoreCase("value")) {
                                                                                select.selectByValue(temp[0]);
                                                                }
                                                                ExcelRead.testCaseStatus = "pass";
                                                                Thread.sleep(1000);
                                                } else {
                                                                ExcelRead.testCaseStatus = "fail";
                                                                System.out.println("Element not present");
                                                }

                                }catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                } catch (Exception e) {
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, e.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                                System.out.println("Element not selected");
                                                System.out.println(e.getMessage() + elename);
                                                e.getMessage();

                                }

                }

                /*
                * Mehtod Name : selectDropDownText Inputs : Element Name , Dropdown value ,
                * WebDriver Working : Value of the dropdown will be selected based on the
                * value provided by the user. Autohor : PranayakUmar Adepu : Infosys ltd
                */
                public static void selectDropDownText(String elename, String value, WebDriver driver1) {
                                try {
                                                String rfElemenntSearch = elementSearch(driver1, elename);
                                                Select select = new Select(eleSearched);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                System.out.println("Trying to select from Dropdown-----------" + value);
                                                                select.selectByVisibleText(value);
                                                                ExcelRead.testCaseStatus = "pass";
                                                                Thread.sleep(1000);
                                                } else {
                                                                ExcelRead.testCaseStatus = "fail";
                                                                System.out.println("Element not present");
                                                }
                                }catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                } catch (Exception e) {
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, e.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                                System.out.println("Element not selected");
                                                System.out.println(e.getMessage() + elename);
                                }

                }
                
                public static void selectDropDownTextUsingKey(String elename, String value, WebDriver driver1) {
                    try {
                                    String rfElemenntSearch = elementSearch(driver1, elename);
                                   // Select select = new Select(eleSearched);
                                    if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                    System.out.println("Trying to select from Dropdown-----------" + value);
                                                   // select.selectByVisibleText(value);
                                                    JavascriptExecutor executor = (JavascriptExecutor)driver1;
                                                    executor.executeScript("arguments[0].click();", eleSearched);
                                                    eleSearched.sendKeys(value);  
                                                    eleSearched.sendKeys(Keys.ENTER);
                                                    ExcelRead.testCaseStatus = "pass";
                                                    Thread.sleep(1000);
                                    } else {
                                                    ExcelRead.testCaseStatus = "fail";
                                                    System.out.println("Element not present");
                                    }
                    }catch(NoClassDefFoundError ex){
                                    ExcelRead.testCaseStatus="Fail";
                                    ExcelRead.testCaseError =ex.getMessage();
                    } catch (Exception e) {
                                    CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, e.getMessage());
                                    ExcelRead.testCaseStatus = "fail";
                                    System.out.println("Element not selected");
                                    System.out.println(e.getMessage() + elename);
                    }

    }

                /*
                * Mehtod Name : selectByPartialText Inputs : Element Name , Dropdown value
                * , WebDriver Working : Value of the dropdown will be selected based on the
                * value provided by the user. Autohor : PranayakUmar Adepu : Infosys ltd
                */

                public static void selectByPartialText(String elename, String value, WebDriver driver1) {
                                try {
                                                String rfElemenntSearch = elementSearch(driver1, elename);
                                                Select select = new Select(eleSearched);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                System.out.println("Trying to select from Dropdown-----------");
                                                                List<WebElement> options = eleSearched.findElements(By.tagName("option"));
                                                                int i = 0, count = 0;
                                                                for (WebElement text : options) {
                                                                                i++;
                                                                                String textContent = text.getAttribute("value");
                                                                                if (textContent.toLowerCase().contains(value.toLowerCase())) {
                                                                                                count = i - 1;
                                                                                                break;
                                                                                }
                                                                }
                                                                if (count == 0) {
                                                                                ExcelRead.testCaseStatus = "fail";
                                                                                System.out.println("Text nmot present in dropdown");
                                                                } else {
                                                                                select.selectByIndex(count);
                                                                                ExcelRead.testCaseStatus = "pass";
                                                                                Thread.sleep(1000);
                                                                }

                                                } else {
                                                                ExcelRead.testCaseStatus = "fail";
                                                                System.out.println("Element not present");
                                                }

                                }catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                } catch (Exception e) {
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, e.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                                System.out.println("Element not selected");
                                                System.out.println(e.getMessage() + elename);
                                }

                }

                public static void rfWriteToExcel(String pKey, String usrComment) {
                                try {
                                                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                                Date date = new Date();
                                                System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43
                                                String vDataWB = System.getProperty("user.dir") + "\\Reports\\Data.xls";
                                                File file = new File(vDataWB);
                                                // Workbook.getWorkbook(file);
                                                // Workbook wb = Workbook.getWorkbook(file);
                                                // Sheet vSheet = wb.getSheet("Data");
                                                WritableWorkbook workbook;
                                                WritableSheet sheet;
                                                Workbook workbookRead = Workbook.getWorkbook(new File(vDataWB));
                                                workbook = Workbook.createWorkbook(file, workbookRead);
                                                sheet = workbook.getSheet("Data");
                                                int vRowCount = sheet.getRows();
                                                System.out.println("Ths is rows : " + vRowCount);
                                                WritableCellFormat cellFormat = new WritableCellFormat();
                                                cellFormat.setWrap(true);
                                                Label label0 = new Label(0, (vRowCount), Integer.toString(vRowCount), cellFormat);
                                                sheet.addCell(label0);
                                                // System.out.println("Ths is rows : 1");
                                                Label label1 = new Label(1, (vRowCount), pKey, cellFormat);
                                                sheet.addCell(label1);
                                                // System.out.println("Ths is rows : 2");
                                                Label label2 = new Label(2, (vRowCount), usrComment, cellFormat);
                                                sheet.addCell(label2);
                                                // System.out.println("Ths is rows : 3");
                                                Label label3 = new Label(3, (vRowCount), dateFormat.format(date), cellFormat);
                                                sheet.addCell(label3);
                                                // System.out.println("Ths is rows : 4");
                                                workbook.write();
                                                workbook.close();
                                                System.out.println("Data added : " + usrComment);
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception ex) {
                                                ExcelRead.testCaseStatus = "fail";
                                                ExcelRead.testCaseError = ex.getMessage();
                                                System.out.println(ex.getStackTrace());
                                }
                }
                public static void rfWriteToExcel2(String pKey, String usrComment) {
                    try {
                                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                                    Date date = new Date();
                                    System.out.println(dateFormat.format(date)); // 2016/11/16 12:08:43
                                    String vDataWB = System.getProperty("user.dir") + "\\Reports\\Data.xls";
                                    File file = new File(vDataWB);
                                    // Workbook.getWorkbook(file);
                                    // Workbook wb = Workbook.getWorkbook(file);
                                    // Sheet vSheet = wb.getSheet("Data");
                                    WritableWorkbook workbook;
                                    WritableSheet sheet;
                                    Workbook workbookRead = Workbook.getWorkbook(new File(vDataWB));
                                    workbook = Workbook.createWorkbook(file, workbookRead);
                                    sheet = workbook.getSheet("Data");
                                    int vRowCount = sheet.getRows();
                                    System.out.println("Ths is rows : " + vRowCount);
                                    WritableCellFormat cellFormat = new WritableCellFormat();
                                    cellFormat.setWrap(true);
                                    Label label0 = new Label(0, (vRowCount), Integer.toString(vRowCount), cellFormat);
                                    sheet.addCell(label0);
                                    // System.out.println("Ths is rows : 1");
                                    Label label1 = new Label(1, (vRowCount), pKey, cellFormat);
                                    sheet.addCell(label1);
                                    // System.out.println("Ths is rows : 2");
                                    Label label2 = new Label(2, (vRowCount), usrComment, cellFormat);
                                    sheet.addCell(label2);
                                    // System.out.println("Ths is rows : 3");
                                    Label label3 = new Label(3, (vRowCount), dateFormat.format(date), cellFormat);
                                    sheet.addCell(label3);
                                    Label label4 = new Label(4, (vRowCount), ExcelRead.currTestCaseName, cellFormat);
                                    sheet.addCell(label4);
                                    // System.out.println("Ths is rows : 3");
                                    Label label5 = new Label(5, (vRowCount), ExcelRead.currServiceID, cellFormat);
                                    sheet.addCell(label5);
                                    Label label6 = new Label(6, (vRowCount), ExcelRead.currLocalNet, cellFormat);
                                    sheet.addCell(label6);
                                    // System.out.println("Ths is rows : 4");
                                    workbook.write();
                                    workbook.close();
                                    System.out.println("Data added : " + usrComment);
                    } catch(NoClassDefFoundError ex){
                                    ExcelRead.testCaseStatus="Fail";
                                    ExcelRead.testCaseError =ex.getMessage();
                    }catch (Exception ex) {
                                    ExcelRead.testCaseStatus = "fail";
                                    ExcelRead.testCaseError = ex.getMessage();
                                    System.out.println(ex.getStackTrace());
                    }
    }

                public static void uploadFile(String elename, String value, WebDriver driver1) {
                                try {
                                                String rfElemenntSearch = elementSearch(driver1, elename);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {

                                                } else {
                                                                ExcelRead.testCaseStatus = "fail";
                                                                System.out.println("Element not present");
                                                                driver1.findElement(By.name("send")).click();
                                                }

                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception e) {
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, e.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                                System.out.println("Element not found");
                                                System.out.println(e.getMessage() + elename);
                                }

                }
                

                public static void selectPriorityBit(String value , WebDriver driver1){
                                try{
              if (value.equalsIgnoreCase("P0") || value.equalsIgnoreCase("P0BIS")){
                     selectDropDown("order_Priority_BitO", value, driver1);
              }
              else if(value.equalsIgnoreCase("P1") || value.equalsIgnoreCase("P1BIS")){
                     selectDropDown("order_Priority_Bit1", value, driver1);
              }
              else if(value.equalsIgnoreCase("P3") || value.equalsIgnoreCase("P3BIS")){
                     selectDropDown("order_Priority_Bit3", value, driver1);
              }
              else if(value.equalsIgnoreCase("P5") || value.equalsIgnoreCase("P5BIS")){
                     selectDropDown("order_Priority_Bit3", value, driver1);
              }
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception ex) {
                                                System.out.println(ex.toString());
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ex.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                }
       }


                public boolean elementEnabled(String elename, String eleType, WebDriver driver1) {
                                try {
                                                String rfElemenntSearch = null;
                                                rfElemenntSearch = elementSearch(driver1, elename);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                System.out.println("Checking element is enabled or not at  " + elename);
                                                                if (eleSearched.isEnabled()) {
                                                                                System.out.println("Element is enabled at  " + elename);
                                                                                return true;
                                                                } else {
                                                                                System.out.println("Element is not enabled " + elename);
                                                                                return false;
                                                                }
                                                } else {
                                                                // need to write
                                                }
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception ex) {
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ex.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                }
                                return false;
                }

                public static boolean elementDisplayed(String elename, WebDriver driver1) {
                                try {
                                                String rfElemenntSearch = null;
                                                rfElemenntSearch = elementSearch(driver1, elename);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                System.out.println("Checking element is displayed or not at  " + elename);
                                                                if (eleSearched.isDisplayed()) {
                                                                                System.out.println("Element is displayed at  " + elename);
                                                                                return true;
                                                                } else {
                                                                                System.out.println("Element is not displayed " + elename);
                                                                                return false;
                                                                }
                                                } else {
                                                                ExcelRead.testCaseStatus = "fail";
                                                                System.out.println("Element not present");
                                                }
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception ex) {
                                                ex.printStackTrace();
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ex.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                }
                                return false;
                }

                public static void validateTitle(WebDriver driver1, String expectedTitle) {
                                try {
                                                String actualTitle = driver1.getTitle();
                                                if (!actualTitle.equalsIgnoreCase(expectedTitle)) {
                                                }
                                }catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                } catch (Exception ex) {
                                                ex.printStackTrace();
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, ex.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                }
                }
                /*
                * Author : PRanay Adep IVS-ECS Date : 25/01/2018 Inputs : Xpath , Input
                * Values separated by comma Output : result with unmacthed values Dropdown
                * Values validation with the given inputs
                */

                public static void dropdownValueValidation(WebDriver driver1, String elename, String ExpecteddropdownValues) {
                                String expValueString[] = ExpecteddropdownValues.split(",");
                                String rfElemenntSearch = null;
                                System.out.println("------------------------------------------");
                                try {
                                                rfElemenntSearch = elementSearch(driver1, elename);
                                                if (rfElemenntSearch.equalsIgnoreCase("Pass")) {
                                                                Select dropdown = new Select(eleSearched);
                                                                List<WebElement> values = dropdown.getOptions();

                                                                List<String> dropdownValueitem = new ArrayList<String>();
                                                                for (WebElement item : values) {
                                                                                dropdownValueitem.add(item.getText());
                                                                                // System.out.println(item.getText());
                                                                }
                                                                int dropdownLength = dropdownValueitem.size() - 1;
                                                                System.out.println("----------------------------------------");
                                                                System.out.println("Expected Value size : " + expValueString.length);
                                                                System.out.println("Dropdown Value size : " + dropdownLength);
                                                                int length = expValueString.length + 1;
                                                                if (dropdownValueitem.size() == length) {
                                                                                for (int i = 0; i < expValueString.length; i++) {
                                                                                                // if (ArrayUtils.contains(expValueString,
                                                                                                // dropdownValueitem.get(i))) {
                                                                                                if (dropdownValueitem.contains(expValueString[i].trim())) {
                                                                                                } else {
                                                                                                                System.out.println("Expected values are not present in the dropdown " + expValueString[i]);
                                                                                                }

                                                                                }
                                                                } else {
                                                                                System.out.println("Expected values and Dropdown values count mismacth ");
                                                                                System.out.println("Expected Value size : " + expValueString.length);
                                                                                System.out.println("Dropdown Value size : " + dropdownLength);
                                                                                System.out.println("Dropdown values are ");
                                                                                for (WebElement item : values) {
                                                                                                System.out.println(item.getText());
                                                                                }
                                                                }

                                                                // }
                                                } else {
                                                                ExcelRead.testCaseStatus = "fail";
                                                                System.out.println("Element not present");
                                                }
                                } catch(NoClassDefFoundError ex){
                                                ExcelRead.testCaseStatus="Fail";
                                                ExcelRead.testCaseError =ex.getMessage();
                                }catch (Exception e) {
                                                e.printStackTrace();
                                                CommonFunctions2.rfWriteToExcel(ExcelRead.currTestCaseId, e.getMessage());
                                                ExcelRead.testCaseStatus = "fail";
                                }

                }
}
