/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import conection.MongoConection;

/**
 * @author Joaquin
 *
 */
public class TestMongoConnection {

	@Test
	public void testConnection() {
		MongoConection mc=MongoConection._GetInstance();
		mc.connection();
		mc.showDB();
		List <String> db=mc.showDB();
		System.out.println(db.toString());
	}

}
