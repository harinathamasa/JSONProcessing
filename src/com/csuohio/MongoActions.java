package com.csuohio;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;


/**
 * 
 * @author Hari
 *
 */
public class MongoActions {

	public MongoActions() {
		// TODO Auto-generated constructor stub	
	}
	
	
	/**
	 * 
	 * @param name
	 */
	public static DBCollection switchCollection(String name,DB db){
		return db.getCollection(name);
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static DBCursor showContentInDocument(DBCollection collection){
		return collection.find();
	}
	/**
	 * 
	 * @param document
	 */
	public static int insertDocument(BasicDBObject document,DBCollection collection,DB db){
		int statusCode=0;
		try{
			if(db!=null){
				if(document!=null){
					collection.insert(document);	
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			statusCode=1;
		}
		return statusCode;
	}
	/**
	 * 
	 * @param document
	 * @param searchQuery
	 */
	public static int updateDocument(BasicDBObject document,BasicDBObject searchQuery,DBCollection collection){
		int statusCode=0;
		try{
			if(collection!=null){
				collection.update(searchQuery, document);
			}
		}catch(Exception e){
			e.printStackTrace();
			statusCode=1;
		}
		return statusCode;
	}
	
	/**
	 * 
	 * @param document
	 * @return
	 */
	public static DBCursor read(BasicDBObject document,DBCollection collection){
		DBCursor dbCursor=null;
		if(collection!=null){
			if(document!=null){
				dbCursor=collection.find(document);
			}
		}
		return dbCursor;
	}
	
	/**
	 * 
	 * @param document
	 */
	public static int remove(BasicDBObject document,DBCollection collection){
		int statusCode=0;
		try{
		if(document!=null){
			collection.remove(document);
		}
		}catch(Exception e){
			e.printStackTrace();
			statusCode=1;
		}
		return statusCode;
	}
	/**
	 * 
	 */
	public static int deleteAll(DBCollection collection){
		
		int statusCode=0;
		
		try{
		
			DBCursor cursor=collection.find();
			while(cursor.hasNext()){
				collection.remove(cursor.next());
			}
		
		}
		catch(Exception e){
			e.printStackTrace();
			statusCode=1;
		}
		return statusCode;
	}
	
}

