package testingFramework;

public class Runner {

	static final String PATH_TO_INI = "D://Eclipse//workspace_mukoid//Testing framework//config//tf.ini";
	static final String PATH_TO_EXCEL = "D://Eclipse//workspace_mukoid//Testing framework//config//tf.ini"; 
	
	public enum TestStatus {
	    PASSED, FAILED 
	}
	

	public void loadConfigurations() {
		EnvironmentSetup myEnvironment = new EnvironmentSetup();
		myEnvironment.getIniFile(PATH_TO_INI);
		
	}
	public void setUpEnvironment(){
		EnvironmentSetup myEnvironment = new EnvironmentSetup();
		myEnvironment.getIniFile(PATH_TO_INI);
		myEnvironment.CreateDbTablesWithData();
		}
	
	

	public void runTestCases() {
		TestRunner myTestRun = new TestRunner();
		myTestRun.loadTestCaseData(PATH_TO_EXCEL);
		myTestRun.showTestCaseData();
		myTestRun.executeTestCases();
		
	}
	public void generateTestReport() {
		Reporting myReport = new Reporting();
		myReport.generateHTMLreport(); 
		
	}

}
