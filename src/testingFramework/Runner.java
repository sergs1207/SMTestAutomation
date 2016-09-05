package testingFramework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import jxl.write.WriteException;

public class Runner {

	static final String PATH_TO_INI = "D://Eclipse//workspace_mukoid//Testing framework//src//testingFramework//framework.ini";

	String PATH_TO_EXCEL = "";
	String DB_CONNECTION_STRING = ""; // driver for connection
	String DB_USER = ""; // login
	String DB_PASSWORD = ""; // password
	String PATH_TO_SCRIPTS = "";
	String PATH_TO_REPORTS = "";

	public enum TestStatus {
		PASSED, FAILED
	}

	public void loadConfigurations() throws FileNotFoundException, IOException {

		EnvironmentSetup myEnvironment = new EnvironmentSetup();

		DB_CONNECTION_STRING = myEnvironment.getFromIniFile("DB_CONNECTION_STRING", PATH_TO_INI);
		DB_USER = myEnvironment.getFromIniFile("DB_USER", PATH_TO_INI);
		DB_PASSWORD = myEnvironment.getFromIniFile("DB_PASSWORD", PATH_TO_INI);
		PATH_TO_SCRIPTS = myEnvironment.getFromIniFile("QUERIES", PATH_TO_INI);

		// Uncomment when creating environment from scratch
		// myEnvironment.CreateDbTablesWithData(DB_USER, DB_PASSWORD,
		// DB_CONNECTION_STRING, PATH_TO_SCRIPTS);

	}

	public void runTestCases() {
		TestRunner myTestRun = new TestRunner();
		myTestRun.loadTestCaseData(PATH_TO_EXCEL);
		myTestRun.showTestCaseData();
		myTestRun.executeTestCases();

	}

	public void generateTestReport() throws WriteException, IOException {
		Reporting myReport = new Reporting();
		// myReport.generateHTMLreport(PATH_TO_REPORTS);

	}

	public static void main(String[] args) {

	}

}