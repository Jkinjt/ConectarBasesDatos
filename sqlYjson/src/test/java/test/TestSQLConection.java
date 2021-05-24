/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import model.Atribute;
import model.MysqDBInformation;

/**
 * @author Joaquin
 *
 */
public class TestSQLConection {

	@Test
	public void test() {
		List<String> ls= MysqDBInformation.getDataBases();
	System.out.println(ls.toString());
	ls= MysqDBInformation.getTables();
	System.out.println(ls.toString());
	List<Atribute> lt=new ArrayList<Atribute>();
	lt=MysqDBInformation.getTableInfo("alumno");
	System.out.println(lt.toString());
			
	
	
	}

}
