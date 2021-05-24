/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import conection.MysqlServer;

/**
 * @author Joaquin
 *
 */
public class MysqDBInformation {
	private final static String SHOWDATABASES= "show databases";
	private final static String USE="use ";
	private final static String SHOWTABLES= "show tables";
	private final static String DESCRIBETABLES="describe ";
	
	
	
	public static List<String> getDataBases() {
		List<String>  result=new ArrayList<String>();
		Connection con = MysqlServer._getInstance();
		if (con != null) {
			Statement st;
			try {
				st = con.createStatement();
				String q = SHOWDATABASES;
				ResultSet rs = st.executeQuery(q);
				
				while (rs.next()) {
					result.add(rs.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	public static void  useDB(String dataBase) {
		Connection con = MysqlServer._getInstance();
		if (con != null) {
			Statement st;
			try {
				st = con.createStatement();
				String q = SHOWTABLES;
				st.executeQuery(q);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static List<String> getTables(){
		List<String>  result=new ArrayList<String>();
		Connection con = MysqlServer._getInstance();
		if (con != null) {
			Statement st;
			try {
				st = con.createStatement();
				String q = SHOWTABLES;
				ResultSet rs = st.executeQuery(q);
				
				while (rs.next()) {
					result.add(rs.getString(1));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public static List<Atribute> getTableInfo(String table){
		List<Atribute>  result=new ArrayList<Atribute>();
		Connection con = MysqlServer._getInstance();
		if (con != null) {
			Statement st;
			try {
				st = con.createStatement();
				String q = DESCRIBETABLES+table;
				ResultSet rs = st.executeQuery(q);
				while (rs.next()) {
					Atribute t=new Atribute();
					t.setName(rs.getString(1));
					t.setType(rs.getString(2));
					result.add(t);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

}
