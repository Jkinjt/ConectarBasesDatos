/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import model.MysqDBInformation;
import model.Table;

/**
 * @author Joaquin
 *
 */
public class TestTable {

	@Test
	public void test() {
		List<String> ls= MysqDBInformation.getDataBases();
		System.out.println(ls.get(3));
		MysqDBInformation.useDB(ls.get(3));
		List<String> tables=MysqDBInformation.getTables();
		Table table=new Table(tables.get(0));
		System.out.println(table.toString());
	}

}
