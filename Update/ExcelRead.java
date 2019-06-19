package testScripts;

import java.io.File;
import java.util.HashMap;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import jxl.Sheet;
import jxl.Workbook;
import reusables.CommonFunctions2;
//import utils.SendEmail;

public class ExcelRead extends ExcelDriverBridge {
	public static HashMap<String, String> mapOR = new HashMap<String, String>();
	public static HashMap<String, String> runTimeVar = new HashMap<String, String>();
	public static String testCaseError, receivedXML, corrid, currTestCaseName, currTestCaseId, currServiceID,
			htmlReportPath, excelReportPath;
	public static String testCaseStatus = "none", testCasePrint = "none";
	public static String projectPath = System.getProperty("user.dir"), screenshotPath = "",
			folderPath = "C:\\Data\\Automation\\UTAF_Automation\\";
//	public static int testCaseInputStart = 8;
//	public static int stepType = 6;
//	public static int stepDescription = 2;
//	public static int stepName = 3;
//	public static int reportNeeded = 5;
//	public static int steptoBeExecuted = 4;
//	public static int testStepInputStart = 7;
	static ExtentReports extent;
	static ExtentTest test;

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {

		String executionWorkBook = folderPath + "WWS_SS_ExecutionSheet.xls";
		//  String executionWorkBook = folderPath + "CWS_Regr_UpdatedFrame_ProvideITT2.xls";
		//	String executionWorkBook = folderPath + "ExecutionSheet_ST.xls";
		htmlReportPath = folderPath + "\\Reports\\ITT\\UTAF_Report.html";
		
		CommonFunctions2.setPropFile(folderPath + "WWS_SS_element.properties");
		//	CommonFunctions2.setPropFile(folderPath + "element_ST.properties");
		extent = new ExtentReports(htmlReportPath, true);
		extent.addSystemInfo("Environment", "ITT / UAT").addSystemInfo("User", "pranayakumar.adepu");
		extent.loadConfig(new File(projectPath + "/extent-config.xml"));

		File file = new File(executionWorkBook);

		Workbook.getWorkbook(file);
		Workbook wb = Workbook.getWorkbook(file);

		Sheet tsSheet = wb.getSheet("TestSuites");
		int tsSheetRowCount = tsSheet.getRows();
		// int tsSheetColCount = tsSheet.getColumns();

		for (int tsSheetIterator = 1; tsSheetIterator < tsSheetRowCount; tsSheetIterator++) {
			String currTestSuiteName = tsSheet.getCell(1, tsSheetIterator).getContents();
			// System.out.println(currTestSuiteName);

			String currTestSuiteFlag = tsSheet.getCell(2, tsSheetIterator).getContents();
			// System.out.println(currTestSuiteFlag);

			if (currTestSuiteFlag.equalsIgnoreCase("y")) {
				runTimeVar = new HashMap<String, String>();
				// runTimeVar.put("startingMap", "startingMap");
				Sheet tcSheet = wb.getSheet("TestCases");
				int tcSheetRowCount = tcSheet.getRows();
				int tcSheetColCount = tcSheet.getColumns();

				for (int tcSheetIterator = 1; tcSheetIterator < tcSheetRowCount; tcSheetIterator++) {
					currTestCaseId = tcSheet.getCell(0, tcSheetIterator).getContents();
					currTestCaseName = tcSheet.getCell(2, tcSheetIterator).getContents();
					currServiceID = "NotUsed";
					System.out.println(currTestCaseName);
					String currTestCaseFlag = tcSheet.getCell(3, tcSheetIterator).getContents();
					System.out.println(currTestCaseFlag);

					if (currTestCaseFlag.equalsIgnoreCase("y")
							&& tcSheet.getCell(1, tcSheetIterator).getContents().equalsIgnoreCase(currTestSuiteName)) {
						test = extent.startTest(currTestCaseName);
						// driver.findElement(By.xpath("//*[contains(@href,'new_lang=fr')]")).click();
						int currTestCaseStartRow = Integer.parseInt(tcSheet.getCell(4, tcSheetIterator).getContents());
						int currTestCaseStepCount = Integer.parseInt(tcSheet.getCell(5, tcSheetIterator).getContents());
						String currTestCaseBrowser = tcSheet.getCell(7, tcSheetIterator).getContents();

						// String currTestCaseData =
						// tcSheet.getCell(testCaseData,
						// tcSheetIterator).getContents();
						// String currTestCaseBrowser =
						// tcSheet.getCell(testcasebrowser,
						// tcSheetIterator).getContents();
						String[] currTestCaseIP = new String[testCaseInputArraySize];

						for (int tcIPIterator = testCaseInputStart; tcIPIterator < tcSheetColCount; tcIPIterator++) {
							currTestCaseIP[tcIPIterator - testCaseInputStart] = tcSheet
									.getCell(tcIPIterator, tcSheetIterator).getContents();
							// System.out.println(currTestCaseIP[tcIPIterator -
							// 8]);
						}
						currServiceID = currTestCaseIP[1];

						// WebDriver driver = openBrowser(currTestCaseBrowser);
						// Thread.sleep(2000);
						// driver.get("https://webmail.itt.proximus.be/");
						Sheet tsSSheet = wb.getSheet("TestSteps");
						Sheet bpcSheet = wb.getSheet("BPCs");
						// int tsSSheetRowCount = tsSSheet.getRows();
						int tsSSheetColCount = tsSSheet.getColumns();

						for (int tsSSheetIterator = currTestCaseStartRow - 1; tsSSheetIterator < (currTestCaseStartRow
								+ currTestCaseStepCount - 1); tsSSheetIterator++) {
							// System.out.println(stepType +" , "+
							// tsSSheetIterator);
							String currTestStepType = tsSSheet.getCell(stepType, tsSSheetIterator).getContents();
							// System.out.println(currTestStepType);
							String currTestStepUDF = tsSSheet.getCell(stepName, tsSSheetIterator).getContents();
							String currTestStepDescription = tsSSheet.getCell(stepDescription, tsSSheetIterator)
									.getContents();
							String currTestStepReport = tsSSheet.getCell(reportNeeded, tsSSheetIterator).getContents();
							String currTestStepExec = tsSSheet.getCell(steptoBeExecuted, tsSSheetIterator)
									.getContents();
							String[] currTestStepIP = new String[15];

							for (int tsSIPIterator = testStepInputStart; tsSIPIterator < tsSSheetColCount; tsSIPIterator++) {
								// System.out.println(tsSIPIterator);

								if (!tsSSheet.getCell(tsSIPIterator, tsSSheetIterator).getContents().isEmpty()) {
									currTestStepIP[tsSIPIterator - testStepInputStart] = tsSSheet
											.getCell(tsSIPIterator, tsSSheetIterator).getContents();
									// System.out.println(currTestStepIP[tsSIPIterator
									// - 5]);
									// System.out.println(currTestStepIP[tsSIPIterator-5].substring(0,
									// 1));
									if (currTestStepIP[tsSIPIterator - testStepInputStart].contains("::")) {
										int indexIP = currTestStepIP[tsSIPIterator - testStepInputStart].indexOf("::");
										String[] customIP = currTestStepIP[tsSIPIterator - testStepInputStart]
												.substring(indexIP + 2).split("_");

										switch (customIP[0]) {
										case "TCIP":
											currTestStepIP[tsSIPIterator
													- testStepInputStart] = currTestStepIP[tsSIPIterator
															- testStepInputStart].substring(0, indexIP).concat(
																	currTestCaseIP[Integer.parseInt(customIP[1]) - 1]);
											break;
										case "TEMP":
											while (currTestStepIP[tsSIPIterator - testStepInputStart]
													.contains("::TEMP")) {
												currTestStepIP[tsSIPIterator - testStepInputStart] = retRunTimeVar(
														currTestStepIP[tsSIPIterator - testStepInputStart]);
											}
											break;
										default:
											System.out.println("Invalid input");
											break;
										}
									}
								}
							}
							System.out.println("This is current row : " + tsSSheetIterator);
							// if step type is case then
							if ((currTestStepType.equalsIgnoreCase("BPC") || currTestStepType.equalsIgnoreCase("Case"))
									&& currTestStepExec.equalsIgnoreCase("Y")) {
								int bpcStartRow = 0, bpcStepCount = 0;
								if (currTestStepType.equalsIgnoreCase("Case")) {
									System.out.println("In Case : " +currTestStepIP[0] );
									String steps = bpcCount(file, currTestStepIP[0]); // "bpcLogin");
									String[] bpcDetails = steps.split("_");
									bpcStartRow = Integer.parseInt(bpcDetails[0]);
									bpcStepCount = Integer.parseInt(bpcDetails[1]);
								} else {
									bpcStartRow = Integer.parseInt(currTestStepIP[0]);
									bpcStepCount = Integer.parseInt(currTestStepIP[1]);
								}
								for (int bpcRowIterator = bpcStartRow - 1; bpcRowIterator < (bpcStartRow + bpcStepCount
										- 1); bpcRowIterator++) {
									String currBPCTestStepType = bpcSheet.getCell(stepType, bpcRowIterator)
											.getContents();
									String currBPCTestStepUDF = bpcSheet.getCell(stepName, bpcRowIterator)
											.getContents();
									String currBPCTestStepDescription = bpcSheet
											.getCell(stepDescription, bpcRowIterator).getContents();
									String currBPCTestStepReport = bpcSheet.getCell(reportNeeded, bpcRowIterator)
											.getContents();
									String currBPCTestStepExec = bpcSheet.getCell(steptoBeExecuted, bpcRowIterator)
											.getContents();
									String[] currBPCTestStepIP = new String[10];

									for (int bpcIPIterator = testStepInputStart; bpcIPIterator < bpcSheet
											.getColumns(); bpcIPIterator++) {
										// System.out.println(bpcIPIterator);
										if (!bpcSheet.getCell(bpcIPIterator, bpcRowIterator).getContents().isEmpty()) {
											currBPCTestStepIP[bpcIPIterator - testStepInputStart] = bpcSheet
													.getCell(bpcIPIterator, bpcRowIterator).getContents();
											System.out.println(currBPCTestStepIP[bpcIPIterator - testStepInputStart]);

											if (currBPCTestStepIP[bpcIPIterator - testStepInputStart].contains("::")) {
												int indexIP = currBPCTestStepIP[bpcIPIterator - testStepInputStart]
														.indexOf("::");
												String[] customIP = currBPCTestStepIP[bpcIPIterator
														- testStepInputStart].substring(indexIP + 2).split("_");

												switch (customIP[0]) {
												case "TCIP":
													currBPCTestStepIP[bpcIPIterator
															- testStepInputStart] = currBPCTestStepIP[bpcIPIterator
																	- testStepInputStart].substring(0, indexIP).concat(
																			currTestCaseIP[Integer.parseInt(customIP[1])
																					- 1]);
													break;
												case "TSIP":
													currBPCTestStepIP[bpcIPIterator
															- testStepInputStart] = currBPCTestStepIP[bpcIPIterator
																	- testStepInputStart].substring(0, indexIP).concat(
																			currTestStepIP[Integer.parseInt(customIP[1])
																					- 1]);
													break;
												case "TEMP":
													while (currBPCTestStepIP[bpcIPIterator - testStepInputStart]
															.contains("::TEMP")) {
														currBPCTestStepIP[bpcIPIterator
																- testStepInputStart] = retRunTimeVar(
																		currBPCTestStepIP[bpcIPIterator
																				- testStepInputStart]);
													}
													break;
												default:
													System.out.println("Invalid input");
													break;
												}
											}
											// System.out.println(currBPCTestStepIP[bpcIPIterator
											// - 5]);
										}
									}
									if (currBPCTestStepExec.equalsIgnoreCase("Y")) {
										System.out.println("This is current row  in BPC: " + bpcRowIterator);

										System.out.println("-------------------------------------------");
										System.out.println("Step Name is : " + currBPCTestStepDescription);
										testCasePrint = "none";
										testCaseStatus = "none";
										System.out.println(ExcelRead.testCaseStatus
												+ " --------before reusable function-----------------------------------");
										// -------------------------Runnable----------------------
										reusableFunctions(currTestCaseBrowser, currBPCTestStepUDF, currBPCTestStepIP);
										System.out.println(ExcelRead.testCaseStatus
												+ " --------after reusable function-----------------------------------");
										if (currBPCTestStepReport.equalsIgnoreCase("Y")) {
											if (ExcelRead.testCaseStatus.equalsIgnoreCase("fail")) {
												test.log(LogStatus.FAIL,
														"Test step failed for : " + currBPCTestStepDescription);
												test.log(LogStatus.FAIL, "with error as  : " + testCaseError);
												// driverobj.get().close();
												System.out
														.println("--------to break-----------------------------------");
												//sendMailVBS();
												break;
											} else if (ExcelRead.testCaseStatus.equalsIgnoreCase("skipped")) {
												System.out.println(
														"--------Skipped step-----------------------------------");
											} else {
												if (testCasePrint.equals("none")) {
													test.log(LogStatus.PASS,
															"Test step passed for : " + currBPCTestStepDescription);

												} else {
													test.log(LogStatus.PASS,
															"Test step passed for : " + currBPCTestStepDescription);
													test.log(LogStatus.PASS, "Your message is : " + testCasePrint);

												}
											}
										}
										if (currBPCTestStepUDF.equalsIgnoreCase("rfElementClick")
												|| currBPCTestStepUDF.equalsIgnoreCase("logout")
												|| currBPCTestStepUDF.equalsIgnoreCase("getTextandCompare")) {
											test.log(LogStatus.PASS, "Screenshot is :",
													test.addScreenCapture(screenshotPath));
										}
										System.out.println("-------------------------------------------");
									}

								}
								if (testCaseStatus.equalsIgnoreCase("fail")) {
									System.out.println("-------------------TO break after BPC------------------------");
									break;
								}

							} else {
								// test step starting

								if (currTestStepExec.equalsIgnoreCase("Y")) {
									System.out.println("This is current row : " + tsSSheetIterator);
									System.out.println("-------------------------------------------");
									System.out.println("Step Name is : " + currTestStepDescription);
									testCasePrint = "none";
									// -------------------------Runnable----------------------
									reusableFunctions(currTestCaseBrowser, currTestStepUDF, currTestStepIP);
									System.out.println("testcase status" + testCaseStatus);
									if (currTestStepReport.equalsIgnoreCase("Y")) {
										if (testCaseStatus.equalsIgnoreCase("fail")) {
											test.log(LogStatus.FAIL,
													"Test step failed for : " + currTestStepDescription);
											test.log(LogStatus.FAIL, "with error as  : " + testCaseError);
											// sendMailVBS();
											// test.log(LogStatus.FAIL,
											// "Screenshot is :",
											// test.addScreenCapture(screenshotPath));
											// driverobj.get().close();
											// driverobj.get().quit();
											break;
										} else if (ExcelRead.testCaseStatus.equalsIgnoreCase("skipped")) {
											System.out
													.println("--------Skipped step-----------------------------------");
										} else {
											if (testCasePrint.equals("none")) {
												test.log(LogStatus.PASS,
														"Test step passed for : " + currTestStepDescription);

											} else {
												test.log(LogStatus.PASS,
														"Test step passed for : " + currTestStepDescription);
												test.log(LogStatus.PASS, "Your message is : " + testCasePrint);
											}
										}
									}
									System.out.println("-------------------------------------------");
								}
								if (currTestStepUDF.equalsIgnoreCase("rfElementClick")
										|| currTestStepUDF.equalsIgnoreCase("logout")
										|| currTestStepUDF.equalsIgnoreCase("getTextandCompare")) {
									test.log(LogStatus.PASS, "Screenshot is :", test.addScreenCapture(screenshotPath));
								}

							}

						}
						if (testCaseStatus.equalsIgnoreCase("fail")) {
							// driverobj.get().close();
							extent.endTest(test);
							driverobj.get().quit();
							// break;
						} else {
							extent.endTest(test);
							driverobj.get().quit();
						}
						Thread.sleep(3000);
						//sendMailVBS();
						//SendEmail.sendReportByMail(htmlReportPath, currTestCaseName);

						// driverobj.get().close();
						// driverobj.get().quit();
					}
				}
			}
		}
		wb.close();
		tearDown();
	}

	private static void tearDown() {
		extent.flush();
		extent.close();
		driverobj.get().quit();
		System.gc();
		System.exit(0);
	}

	public static String retRunTimeVar(String inputParam) {
		System.out.println("Inside : returnTimeVar " + inputParam);
		if (inputParam.contains("TEMP")) {
			int indexOF = inputParam.indexOf("::");
			int spaceIndex = indexOF + inputParam.substring(indexOF).indexOf(" ") + 1;
			String runTimeVariableKey = inputParam.substring(indexOF + 2, spaceIndex);
			String newrunTimeVariableKey = runTimeVariableKey.replaceAll("\\s+", "");
			if (!runTimeVar.containsKey(newrunTimeVariableKey)) {
				runTimeVar.put(newrunTimeVariableKey, newrunTimeVariableKey);
			}
			String runTimeVariableValue = runTimeVar.get(newrunTimeVariableKey);
			inputParam = inputParam.substring(0, indexOF).concat(runTimeVariableValue)
					.concat(inputParam.substring(spaceIndex));
			System.out.println("Variable key is : " + runTimeVariableKey);
			System.out.println("Variable value is : " + runTimeVariableValue);
		}
		return inputParam;
	}

	public static void sendMailVBS() {
		try {
			String pathSendEmailVBS = projectPath + "\\SendMail.vbs";
			pathSendEmailVBS = pathSendEmailVBS.replace("\\", "/");
			Thread.sleep(2000);
			Process p = Runtime.getRuntime().exec("cmd /c start " + pathSendEmailVBS);
			p.waitFor();
			Thread.sleep(2000);
		} catch (Exception ex) {
			System.out.println("Failed in sending mail :" + ex.getMessage());
		}
		// return inputParam;
	}

	public static String bpcCount(File workbook, String bpcName) throws Exception {
		String bpcStart_Count = "";
		int bpcStartRow = 0;
		try {
			// Get the workbook instance for XLSX file
			Workbook wb = Workbook.getWorkbook(workbook);
			// Iterating to the BPCs sheet
			Sheet tsSheet = wb.getSheet("BPCs");
			// Finding the no of rows present
			int noOfRows = tsSheet.getRows();

			System.out.println(noOfRows + " No. of rows present on Datasheet");
			// Determining the column number for "BPC_Name"
			String curdataName;
			// Fetching the no of columns
			int noOfColumns = tsSheet.getColumns();
			int columnNoOfBPC_Name = -1;
			// Iterating for all the columns
			for (int columnNo = 0; columnNo < noOfColumns; columnNo++) {
				curdataName = tsSheet.getCell(columnNo, 0).getContents();
				if (curdataName.equals("BPC_Name")) {
					columnNoOfBPC_Name = columnNo;
					break;
				}
			}
			if (columnNoOfBPC_Name == -1) {
				throw new Exception("Column name: 'BPC_Name' not present in the sheet: 'BPCs'");
			}
			// Iterating the entire sheet for finding the bpc count
			String bpc_Name;
			int count = 0;
			boolean bpcNameFound = false;
			for (int rowCount = 0; rowCount < noOfRows; rowCount++) {
				bpc_Name = tsSheet.getCell(columnNoOfBPC_Name, rowCount).getContents();
				if (bpcName.equals(bpc_Name)) {
					if (!bpcNameFound) {
						bpcStartRow = rowCount;
					}
					bpcNameFound = true;
					count++;
				}
			}
			wb.close();
			bpcStartRow = bpcStartRow + 1;
			bpcStart_Count = Integer.toString(bpcStartRow);
			bpcStart_Count = bpcStart_Count + "_";
			System.out.println(bpcStart_Count + " Count " + count);
			return bpcStart_Count + count;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return bpcStart_Count + "-1";
		}

	}
}
