package testScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import reusables.CommonFunctions2;
import reusables.MIBChange;

public class ExcelDriverBridge extends CommonFunctions2 {
	public static ThreadLocal<WebDriver> driverobj = new ThreadLocal<WebDriver>();
	

	public static void reusableFunctions(String currTestCaseBrowser, String currTestStepUDF, String[] currTestStepIP)
			throws Exception {
		// String locator = ExcelRead.mapOR.get(currTestStepIP[0]);
		if (currTestStepUDF.equalsIgnoreCase("rfElementClickwithoutJS") || currTestStepUDF.equalsIgnoreCase("logout")
				|| currTestStepUDF.equalsIgnoreCase("getTextandCompare")) {
			//captureScreenshot(currTestStepIP[0], driverobj.get());
		}
		switch (currTestStepUDF) {
		case "setupMobileDriver":
			setupMobileDriver(currTestStepIP[0], currTestStepIP[1]);
			break;
		case "setupMobileDriverWithAPK":
			setupMobileDriverWithAPK(currTestStepIP[0]);
			break;
		case "swipe":
			swipe(driverobj.get());
			break;
		case "clickOnButton":
			clickOnButton(driverobj.get(),currTestStepIP[0],currTestStepIP[1]);
			break;
		
		case "handleAlert":
		handleAlertBox(driverobj.get());
			break;
		
		case "rfSendText":
			sendValue(currTestStepIP[0], currTestStepIP[1], driverobj.get());
			break;
			
		case "rfElementClick":
			System.out.println(currTestStepIP[0]);
			
			elementclick(currTestStepIP[0], driverobj.get());
			break;
		case "rfElementClickwithoutJS":
			System.out.println(currTestStepIP[0]);
			elementclickWithoutJS(currTestStepIP[0], driverobj.get());
			break;
		case "multipleClick":
			multipleClicks(currTestStepIP[0], driverobj.get());
			break;
		case "doubleClick":
			doubleClick(currTestStepIP[0], driverobj.get());
			break;
		case "drawLine":
			drawLine(currTestStepIP[0], driverobj.get());
			break;
		
		
		case "sleep":
			sleep(currTestStepIP[0]);
			break;
		case "selectFromDropDown":
			selectDropDown(currTestStepIP[0], currTestStepIP[1], driverobj.get());
			break;
		case "selectDropDownText":
			selectDropDownText(currTestStepIP[0], currTestStepIP[1], driverobj.get());
			//selectDropDownTextUsingKey(currTestStepIP[0], currTestStepIP[1], driverobj.get());
			break;
		case "selectByPartialText":
			selectByPartialText(currTestStepIP[0], currTestStepIP[1], driverobj.get());
			break;
	
		
		case "getAttrAndCompare":
			getAttrandCompareWith(currTestStepIP[0], currTestStepIP[1], currTestStepIP[2], driverobj.get());
			break;
		case "getDifference":
			getDifference(currTestStepIP[0], currTestStepIP[1], currTestStepIP[2]);
			break;
		case "getTextandCompare":
			getTextandCompare(currTestStepIP[0], currTestStepIP[1], driverobj.get());
			break;
		
		case "getText":
			getText(currTestStepIP[0], currTestStepIP[1], driverobj.get());
			break;
		case "selectAutoComplete":
			selectAutoComplete(currTestStepIP[0], currTestStepIP[1], driverobj.get());
			break;
		
		case "getReqMsg":
			//getReqMsg(currTestStepIP[0], currTestStepIP[1], currTestStepIP[2]);
			break;
		case "logout":
			logout(driverobj.get());
			break;
		case "print":
			printValue(currTestStepIP[0], currTestStepIP[1]);
			break;
		
		case "mibchange":
			MIBChange.MIBChane(driverobj.get());
			break;
		
		case "replaceToVariable":
			replaceToVariable(currTestStepIP[0], currTestStepIP[1], currTestStepIP[2], currTestStepIP[3]);
			break;
		case "waitForAction":
			waitForAction();
			break;
		
		case "dropdownValueValidation":
			dropdownValueValidation(driverobj.get(), currTestStepIP[0], currTestStepIP[1]);
			break;
		case "screenshot":
			captureScreenshot(currTestStepIP[0], driverobj.get());
			break;
		case "clear":
			clear(currTestStepIP[0], driverobj.get());
			break;
		case "selectDate":
			selectDate(currTestStepIP[0],currTestStepIP[1], driverobj.get());
			break;
		case "highlight":
			highlightElement(currTestStepIP[0], driverobj.get());
			break;
		// captureScreenshot
		default:
			System.out.println("Invalid Step");
			break;
		}
	}

	private static void logout(WebDriver webDriver) {
		// TODO Auto-generated method stub
		
	}
}
