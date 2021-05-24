/**
 * 
 */
package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

/**
 * @author Joaquin
 *
 */
public class Row {
	private List<Atribute> atributes;
	
	
	public Document createDocument() {
		Document result=new Document("_id", atributes.get(0).getValor() );
		for (int i = 1; i < atributes.size(); i++) {
			result.append(atributes.get(i).getName(), atributes.get(i).getValor());
		}
		
		
		return result;
	}
	

}
