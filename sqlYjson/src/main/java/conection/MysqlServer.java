/**
 * 
 */
package conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Joaquin
 *
 */
public class MysqlServer {
	private static MysqlServer mysqlServer;
	private static Connection connection;
	private static String server;
	private static String database;
	private static String username;
	private static String password;
	
	public static Connection _getInstance() {
		if(connection==null) {
			mysqlServer=new MysqlServer();
			conect();
			
		}
		return connection;
	}
	
	public static Connection _getInstance(String server, String database, String username, String password) {
		if(connection==null) {
			mysqlServer=new MysqlServer(server,database, username, password);
			conect();
		}
		return connection;
	}
	
	private MysqlServer() {
		this("jdbc:mysql://localhost","lectura","root","1234");
	}


	private MysqlServer(String server, String database, String username, String password) {
		super();
		this.server = server;
		this.database = database;
		this.username = username;
		this.password = password;
	}


	public String getServer() {
		return server;
	}


	public void setServer(String server) {
		this.server = server;
	}


	public String getDatabase() {
		return database;
	}


	public void setDatabase(String database) {
		this.database = database;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	private static void conect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");			
			connection= DriverManager.getConnection(server+"/"+database, username, password);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			connection=null;
			e.printStackTrace();
		}
		if(connection!=null) {
		}
		
		
	}
	

}
