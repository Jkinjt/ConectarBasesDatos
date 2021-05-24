/**
 * 
 */
package conection;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;


/**
 * @author Joaquin
 *
 */
public class MongoConection {

	private static MongoConection mongoConection;
	private MongoClient mongoConexion;
	private static MongoDatabase mongoBD;

	
	private MongoConection() {
		connection();
	}
	
	public static MongoConection _GetInstance() {
    	if(mongoConection ==null) {
    		mongoConection=new MongoConection();
    	}
    	return mongoConection;
    }

	public boolean connection() {
		boolean result = false;

		mongoConexion = new MongoClient();
		if (mongoConexion != null) {
			result = true;
		}
		return result;

	}
	
	public List<String> showDB()
    {
        MongoIterable <String> collections = mongoConexion.listDatabaseNames();
        List <String> result = new ArrayList<String>();
        for (String collectionName: collections) {
        		result.add(collectionName);
            }   
    
        return result;
    }
	public boolean connectBD(String bd){
	       boolean result=false;
	       mongoBD = mongoConexion.getDatabase(bd);
	       if(mongoBD!=null)
	       {
	           result= true;
	       
	       }
	       return result;
		}
	public static void insert(String nombreColeccion, Document documento)
    {
        MongoCollection<org.bson.Document> coleccion = mongoBD.getCollection(nombreColeccion);
        coleccion.insertOne(documento);
    
    }
}
