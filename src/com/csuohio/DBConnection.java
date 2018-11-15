package com.csuohio;

import java.net.UnknownHostException;
import com.mongodb.DB;
import com.mongodb.MongoClient;

public class DBConnection {

	private static DBConnection dbConnection=null;
	private static DB db=null;

	private DBConnection() {
		// TODO Auto-generated constructor stub
	}

	public static DBConnection getDBConnection(){
		if(dbConnection!=null){
			return dbConnection;
		}else{
			dbConnection=new DBConnection();
			return dbConnection;
		}
	}
	
	public static DB connect(String dataBase){
		try {
			MongoClient mogoClient=new MongoClient("localhost",27017);
			db=mogoClient.getDB(dataBase);
			System.out.println("Connected to DB Successfully...!!!");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception");
			
		}
		return db;
	}
	
	
}

