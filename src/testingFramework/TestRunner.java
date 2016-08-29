package testingFramework;

import java.util.ArrayList;
import jxl.*;
import jxl.read.biff.BiffException;
import testingFramework.Runner.TestStatus;

import java.io.File;
import java.io.IOException;

public class TestRunner {

	private ArrayList<String[]> TestCases = new ArrayList<String[]>();
	String[] data;

	public void loadTestCaseData(String pathToFile) {

		try {

			Workbook wrk1 = Workbook.getWorkbook(new File(pathToFile));
			int i = 1;

			while (true) {
				String stepNumber = wrk1.getSheet(0).getCell(0, i).getContents();
				String actionToDo = wrk1.getSheet(0).getCell(1, i).getContents();
				String expectedResult = wrk1.getSheet(0).getCell(2, i).getContents();
				String actualResult = "";
				String testResult = "";

				data = new String[] { stepNumber, actionToDo, expectedResult, actualResult, testResult };
				TestCases.add(i - 1, data);

				i++;
			}

		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException exception) {
			System.out.println("Test cases are loaded....");
		}
	}

	public void prepareTestReportData() {
		for (String[] x : TestCases) {
			if (x[2] == x[3]) {
				x[4] = TestStatus.values()[0].toString();
			} else {
				x[4] = TestStatus.values()[1].toString();
			}
		}
	}

	public void showTestCaseData() {
		for (String[] x : TestCases)
			System.out.println(x[0] + " " + x[1] + " " + x[2] + " " + x[3] + " " + x[4]);
	}

	public void executeTestCases() {
		for (String[] x : TestCases) {
			RunSQL myQuery = new RunSQL(x[1]);
			x[3] = myQuery.getResultToString();
	}

	}

	public static void main(String[] args) {
		//It should be removed after testing 
		
		TestRunner myRunner = new TestRunner();
		myRunner.loadTestCaseData("D://testingFramework//config//TestCases.xls");
		myRunner.showTestCaseData();
		myRunner.executeTestCases();
		
		//This file should contain only logic 
		

	}
}
