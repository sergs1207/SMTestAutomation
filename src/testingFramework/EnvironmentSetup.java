package testingFramework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class EnvironmentSetup {
	

    

	public void CreateDbTablesWithData(String DB_USER, String DB_PASSWORD,
			String DB_CONNECTION_STRING, 
			String PATH_TO_SCRIPTS) throws FileNotFoundException, IOException {
	
		 try (
		         // Step 1: Allocate a database "Connection" object
		         Connection conn = DriverManager.getConnection(
		        		 DB_CONNECTION_STRING, DB_USER, DB_PASSWORD); // MySQL
		 
		         // Step 2: Allocate a "Statement" object in the Connection
		         Statement stmt = conn.createStatement();
		      ) {
		         // Step 3: Execute a SQL SELECT query, the query result
		         //  is returned in a "ResultSet" object.
		     //-------------------
			 
			 
			 try {
					File file = new File(PATH_TO_SCRIPTS);
					
					FileReader fileReader = new FileReader(file);
					BufferedReader bufferedReader = new BufferedReader(fileReader);
					
					String myQuery;
					
					while ((myQuery = bufferedReader.readLine()) != null) {
					
						stmt.executeUpdate(myQuery);	
						
					}
					fileReader.close();
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			 
			 
			 //-------------------
			 
	
		         
		      } catch(SQLException ex) {
		         ex.printStackTrace();
		      }
		 
       

     
		
		
		
	}

	public String getFromIniFile(String myParam, String pathToIni) throws FileNotFoundException, IOException {
		String parametrValue = "";
		// открыть файл для чтения
		// вычитываем в стринговую переменную построчно
		// если строка начинается с символов  myParam + "= ", то присвоить в переменную parametrValue все что правее
		try {
			File file = new File(pathToIni);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				
				if (line.substring(0, myParam.length()).equals(myParam))
				{
					parametrValue = line.substring(myParam.length() + 1, line.length());
				}
				
			}
			fileReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return parametrValue;
	}
	
	


}