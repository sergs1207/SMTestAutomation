package testingFramework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import jxl.write.WriteException;

public class Runner {

	static final String PATH_TO_INI = "D://Eclipse//workspace_mukoid//Testing framework//src//testingFramework//framework.ini";

	public String pathToExcel = "";
	public String dbConnectionString = ""; // driver for connection
	public String dbUser = ""; // login
	public String dbPassword = ""; // password
	public String pathToScripts = "";
	public String pathToReports = "";

	public enum TestStatus {
		PASSED, FAILED
	}

	public void loadConfigurations() throws FileNotFoundException, IOException {

		EnvironmentSetup myEnvironment = new EnvironmentSetup();

		dbConnectionString = myEnvironment.getFromIniFile("DB_CONNECTION_STRING", PATH_TO_INI);
		dbUser = myEnvironment.getFromIniFile("DB_USER", PATH_TO_INI);
		dbPassword = myEnvironment.getFromIniFile("DB_PASSWORD", PATH_TO_INI);
		pathToScripts = myEnvironment.getFromIniFile("QUERIES", PATH_TO_INI);

		// Uncomment when creating environment from scratch
		// myEnvironment.CreateDbTablesWithData(DB_USER, DB_PASSWORD,
		// DB_CONNECTION_STRING, PATH_TO_SCRIPTS);

	}

	public void runTestCases() {
		TestRunner myTestRun = new TestRunner();
		myTestRun.loadTestCaseData(pathToExcel);
		myTestRun.executeTestCases(dbConnectionString, dbUser, dbPassword);
		myTestRun.showTestCaseData();	
	}

	

	public static void main(String[] args) {

	}

}