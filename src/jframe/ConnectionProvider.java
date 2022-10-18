package jframe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static Connection con;
	
public static Connection createConnection() throws ClassNotFoundException, SQLException {
	/*calling Class.forName(String) returns the Class object associated with the class or 
	 * interface with the given string name
	 * (...) A Driver class is loaded, and therefore automatically registered with the DriverManager, in one of two ways:

   by calling the method Class.forName. This explicitly loads the driver class. Since it does not depend on any external setup,
   this way of loading a driver is the recommended one for using the DriverManager framework. 
   
   It is the responsibility of the newly-loaded Driver class to register itself by calling DriverManager.registerDriver.
   As mentioned, this should be done automatically when the class is loaded.
	 */
	
	
	//Load JDBC driver
	//Class.forName("com.mysql.jdbc.Driver");//depreciated
	Class.forName("com.mysql.cj.jdbc.Driver");	//MySql Driver Java Class Name = com.mysql.cj.jdbc.Driver
	
	//create a connection
	String url="jdbc:mysql://localhost:3306/library_ms"; //URL for Connection:- The connection URL for the MySql database is 
	//local-host=database path, MySql port= 3306, database=student_manage.
	String user="root";
	String pass="12345";
	con=DriverManager.getConnection(url, user, pass);
	
 return con;
}
}
