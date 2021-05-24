/**
 * 
 */
package model;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import Utils.TypeSql;

/**
 * @author Joaquin
 *
 */
public class Row {
	private List<Atribute> atributes;

	public Row(ResultSet rs, String table) throws SQLException {
		if (rs != null && table != null) {
			atributes = MysqDBInformation.getTableInfo(table);
			int count = 0;
			while (count<atributes.size()) {
				switch (atributes.get(count).getTypeInt()) {
				case integer:
					atributes.get(count).setValor("" + rs.getInt(atributes.get(count).getName()));
					break;
				case varchar:
					atributes.get(count).setValor(rs.getString(atributes.get(count).getName()));
					break;
				case date:
					Date date = rs.getDate(atributes.get(count).getName());
					LocalDate localDate = date.toLocalDate();
					atributes.get(count).setValor(
							localDate.getYear() + "," + localDate.getMonthValue() + "," + localDate.getDayOfMonth());
					break;
				default:
					break;

				}
				count++;

			}
		}

	}

	public Document createDocument() {
		Document result = new Document("_id", atributes.get(0).getValor());
		for (int i = 1; i < atributes.size(); i++) {
			result.append(atributes.get(i).getName(), atributes.get(i).getValor());
		}

		return result;
	}

	@Override
	public String toString() {
		return "Row [atributes=" + atributes + "]";
	}
	
	

}
