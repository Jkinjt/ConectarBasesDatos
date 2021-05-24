/**
 * 
 */
package launch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import conection.MongoConection;
import model.MysqDBInformation;
import model.Table;

/**
 * @author Joaquin
 *
 */
public class Ejecutable {
	static MongoConection mc=MongoConection._GetInstance();
	public static void main(String[] args) {
		
		List<String> ls= MysqDBInformation.getDataBases();
		for (int i = 0; i < ls.size(); i++) {
			System.out.println("Pulse "+(i+1)+" "+ls.get(i));
		}
		System.out.println("Pulsa 0 para salir");
		int count=-1;
		do  {
			System.out.println("Introduzca el número: ");
			Scanner sc=new Scanner(System.in);
			count=sc.nextInt();
		}while(count==0);
		if(count>0&&mc.connectBD(ls.get(count))) {
			MysqDBInformation.useDB(ls.get(count));
			
			List<String> tables=MysqDBInformation.getTables();
			List<Table> db=new ArrayList<Table>();
			for (int i = 0; i < tables.size(); i++) {
				Table table=new Table(tables.get(i));
				table.saveTable();
			}	
		}
		
		
		
	}
	

}
