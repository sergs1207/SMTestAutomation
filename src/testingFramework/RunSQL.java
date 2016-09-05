package testingFramework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class RunSQL {

	private String dbConnectionName = ""; // driver for connection
	private String dbUser = ""; // login
	private String dbPassword = ""; // password
	private String myQuery = "";

	public RunSQL(String dbConnectionName, String dbUser, String dbPassword, String myQuery) {

		this.myQuery = myQuery;
		this.dbConnectionName = dbConnectionName; // driver for connection
		this.dbUser = dbUser; // login
		this.dbPassword = dbPassword; // password

	}

	public String getResultToString() {
		String convertedResult = "";
		// -----------

		try {
				Connection conn = DriverManager.getConnection(dbConnectionName, dbUser, dbPassword); // MySQL
				ResultSet rs = conn.createStatement().executeQuery(myQuery);
				String columnName = rs.getMetaData().getColumnName(1);
				while (rs.next()) convertedResult=convertedResult+rs.getString(columnName)+";";
			} catch (SQLException ex) {	ex.printStackTrace();}

		// -----------
		return convertedResult;
	}


}
