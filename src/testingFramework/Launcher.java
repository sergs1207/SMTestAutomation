package testingFramework;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import jxl.write.WriteException;

public class Launcher {
	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException, WriteException {
		Runner myInstance = new Runner();

		myInstance.loadConfigurations();
		myInstance.runTestCases();
		myInstance.generateTestReport();

	}
}
