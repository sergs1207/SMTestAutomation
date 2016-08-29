package testingFramework;

public class Launcher {
	public static void main(String[] args) {
		Runner myInstance = new Runner();
		
		myInstance.loadConfigurations();
		myInstance.setUpEnvironment();
		myInstance.runTestCases();
		myInstance.generateTestReport();

	}
}
