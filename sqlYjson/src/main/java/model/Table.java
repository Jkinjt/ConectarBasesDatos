/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conection.MongoConection;
import conection.MysqlServer;

/**
 * @author Joaquin
 *
 */
public class Table {
	private final static  String SELECT= "select * from ";
	
	private String name;
	List<Row> rows;
	
	public Table(String name) {
		this.name=name;
		Connection con = MysqlServer._getInstance();
		if (con != null) {
			Statement st;
			try {
				st = con.createStatement();
				String q = SELECT+name;
				ResultSet rs = st.executeQuery(q);
				rows=new ArrayList<Row>();
				while (rs.next()) {
					Row row=new Row(rs,name);
					rows.add(row);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void saveTable() {
		for (int i = 0; i < rows.size(); i++) {
			
			MongoConection.insert(this.name, rows.get(i).createDocument());
		}
		
	}

	@Override
	public String toString() {
		return "Table [name=" + name + ", rows=" + rows + "]";
	}
	
	

}
