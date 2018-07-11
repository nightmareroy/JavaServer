package managerDB;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import common.Config;
import common.Out;
import dbUtil.DBUtil;

public class DBManager {
	private DBManager() {
		
	}
	
	private static DBManager dbManager=null;
	
	public static DBManager getInstance() {
		if(dbManager==null) {
			dbManager=new DBManager();
		}
		return dbManager;
	}
	
	public int test = 9;
	
//	private MongoDatabase mongoDatabase=null;
	private MongoClient mongoClient=null;
	
	public void init() {
		mongoClient=new MongoClient(Config.MongoDB.Url,Config.MongoDB.Port);
		
//		mongoDatabase = mongoClient.getDatabase(Config.MongoDB.DatabaseName);
		
//		MongoCollection<Document> collection = getCollection("test_c");
//		
//		FindIterable<Document> findIterable = collection.find();  
//        MongoCursor<Document> mongoCursor = findIterable.iterator();  
//        while(mongoCursor.hasNext()){
////        	Out.debug("-----------");
////        	Document document = mongoCursor.next();
////        	for (Object object : document.values()) {
////        		Out.debug(object.getClass());
////			}
//        	Out.debug(mongoCursor.next());
//        }
//        DBManager testm=DBUtil.document2Bean(DBUtil.bean2Document(this), DBManager.class);
//		Out.debug(testm.test);
	}
	
	//集合操作
//	public MongoCollection<Document> getCollection(String collectionName){
//		return mongoDatabase.getCollection(collectionName);
//	}
//	
//	public void addCollection(String collectionName) {
//		mongoDatabase.createCollection(collectionName);
//	}
//	
//	public void deleteCollection(String collectionName) {
//		mongoDatabase.getCollection(collectionName).drop();
//	}
	
	//文档操作
//	public <T> T getObject(String collectionName,ObjectId objectId,Class<T> clazz) {
//		MongoCollection<Document> collection = getCollection(collectionName);
//		
//		BasicDBObject filter = new BasicDBObject();
//		filter.put("_id",objectId);
//		FindIterable<Document> findIterable = collection.find(filter);
//		
//        MongoCursor<Document> mongoCursor = findIterable.iterator();  
//        Document document=null;
//        while(mongoCursor.hasNext()){
//        	document = mongoCursor.next();
//        	
//        }
//        if(document == null) {
//        	return null;
//        }
//        
//        T bean;
//		try {
//			bean = clazz.newInstance();
//		} catch (InstantiationException | IllegalAccessException e) {
//			e.printStackTrace();
//		} 
//        Field[] fields = clazz.getDeclaredFields();  
//        for (Field field : fields) {  
//          String varName = field.getName();  
//          Object object = document.get(varName);
//          
//          
////          if (object != null) {  
////        	  try {
////				BeanUtils.setProperty(bean, varName, object);
////			} catch (IllegalAccessException | InvocationTargetException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}  
////          }  
//        }  
//        return bean;  
//	}
	
	public <T> T getObject(String databaseName,String collectionName,ObjectId objectId,Class<T> clazz) {
		MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);
		MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
		
		BasicDBObject filter = new BasicDBObject();
		filter.put("_id", objectId);
		FindIterable<Document> findIterable = collection.find(filter);
		MongoCursor<Document> mongoCursor = findIterable.iterator();  
		Document document=null;
		while(mongoCursor.hasNext()){
			document = mongoCursor.next();
		}
		if(document == null) {
			return null;
		}
		
		return DBUtil.document2Bean(document, clazz);
	}
	
	public <T> Boolean setObject(String databaseName,String collectionName,T object) {
		MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);
		MongoCollection<Document> collection = mongoDatabase.getCollection(collectionName);
		
		Document document=DBUtil.bean2Document(object);
		
		if(document==null) {
			return false;
		}
		
		ObjectId objectId = document.getObjectId("_id");
		
		if(objectId==null) {
			return false;
		}
		
		BasicDBObject filter = new BasicDBObject();
		filter.put("_id", objectId);
		
		collection.findOneAndReplace(filter, document);
		
		return true;

	}
}
