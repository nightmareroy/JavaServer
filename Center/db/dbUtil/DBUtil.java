package dbUtil;


import java.lang.reflect.Field;  
import java.lang.reflect.InvocationTargetException;  
import java.util.Date;  
  
import org.apache.commons.beanutils.BeanUtils;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;  
import com.mongodb.DBObject;  
  
public class DBUtil {  
//
//	
//  /** 
//   * 把实体bean对象转换成DBObject 
//   * @param bean 
//   * @return 
//   * @throws IllegalArgumentException 
//   * @throws IllegalAccessException 
//   */  
//  public static <T> DBObject bean2DBObject(T bean) throws IllegalArgumentException,IllegalAccessException {  
//	  if (bean == null) {  
//		  return null;  
//	  }
//	  DBObject dbObject = new BasicDBObject();  
//	  // 获取对象对应类中的所有属性域  
//	  Field[] fields = bean.getClass().getDeclaredFields();  
//	  for (Field field : fields) {  
//	      // 获取属性名  
//	      String varName = field.getName();  
//	      // 修改访问控制权限  
//	      boolean accessFlag = field.isAccessible();  
//	      if (!accessFlag) {  
//	        field.setAccessible(true);  
//	      }  
//	      Object param = field.get(bean);  
//	      if (param == null) {  
//	        continue;  
//	      } else if (param instanceof Integer) {//判断变量的类型  
//	        int value = ((Integer) param).intValue();  
//	        dbObject.put(varName, value);  
//	      } else if (param instanceof String) {  
//	        String value = (String) param;  
//	        dbObject.put(varName, value);  
//	      } else if (param instanceof Double) {  
//	        double value = ((Double) param).doubleValue();  
//	        dbObject.put(varName, value);  
//	      } else if (param instanceof Float) {  
//	        float value = ((Float) param).floatValue();  
//	        dbObject.put(varName, value);  
//	      } else if (param instanceof Long) {  
//	        long value = ((Long) param).longValue();  
//	        dbObject.put(varName, value);  
//	      } else if (param instanceof Boolean) {  
//	        boolean value = ((Boolean) param).booleanValue();  
//	        dbObject.put(varName, value);  
//	      } else if (param instanceof Date) {  
//	        Date value = (Date) param;  
//	        dbObject.put(varName, value);  
//	      }  
//	      // 恢复访问控制权限  
//	      field.setAccessible(accessFlag);  
//	  }  
//	  return dbObject;  
//  }  
//  
//  /** 
//   * 把DBObject转换成bean对象 
//   * @param dbObject 
//   * @param bean 
//   * @return 
//   * @throws IllegalAccessException 
//   * @throws InvocationTargetException 
//   * @throws NoSuchMethodException 
//   * @throws InstantiationException 
//   */  
//  public static <T> T dbObject2Bean(DBObject dbObject, Class<T> clazz) throws IllegalAccessException,  
//      InvocationTargetException, NoSuchMethodException, InstantiationException {  
//    T bean=clazz.newInstance(); 
//    Field[] fields = clazz.getDeclaredFields();  
//    for (Field field : fields) {  
//      String varName = field.getName();  
//      Object object = dbObject.get(varName);  
//      if (object != null) {  
//    	  BeanUtils.setProperty(bean, varName, object);  
//      }  
//    }  
//    return bean;  
//  }
//  
  
  
	public static <T> Document bean2Document(T bean) {
		if (bean == null) {
			return null;  
		}
		Document document = new Document();
	  
		Field[] fields = bean.getClass().getFields();  
		for (Field field : fields) {
			// 获取属性名  
			String varName = field.getName();  
			// 修改访问控制权限  
			boolean accessFlag = field.isAccessible();  
			if (!accessFlag) {  
				field.setAccessible(true);  
			} 
			Object param = null;
			try {
				param = field.get(bean);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			if (param == null) {  
				continue;
			} else if(param instanceof ObjectId) {
				document.put(varName, (ObjectId)param);
			} else if (param instanceof Integer) {
				int value = ((Integer) param).intValue();  
				document.put(varName, value);  
			} else if (param instanceof String) {  
				String value = (String) param;  
				document.put(varName, value);  
			} else if (param instanceof Double) {  
				double value = ((Double) param).doubleValue();  
				document.put(varName, value);  
			} else if (param instanceof Float) {  
				float value = ((Float) param).floatValue();  
				document.put(varName, value);  
			} else if (param instanceof Long) {  
				long value = ((Long) param).longValue();  
				document.put(varName, value);  
			} else if (param instanceof Boolean) {  
				boolean value = ((Boolean) param).booleanValue();  
				document.put(varName, value);  
			} else if (param instanceof Date) {  
				Date value = (Date) param;  
				document.put(varName, value);  
			} else {
				document.put(varName, bean2Document(param));
			} 
			// 恢复访问控制权限  
			field.setAccessible(accessFlag);  
		}
		return document;
	}
	
	public static <T> T document2Bean(Document document,Class<T> clazz) {
		T bean=null;
		try {
			bean=clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		} 
		Field[] fields = clazz.getFields();
		for (Field field : fields) {
			String varName = field.getName();  
			boolean accessFlag = field.isAccessible();  
			if (!accessFlag) {  
				field.setAccessible(true);  
			} 
			Object object = document.get(varName);
			if (object == null) {  
//				BeanUtils.setProperty(bean, varName, object);
				continue;
			}
			Class<?> type = field.getType();
			try {
				if(type == ObjectId.class) {
					field.set(bean, (ObjectId)object);
				} else if (type == Integer.class) {
					field.set(bean, ((Integer)object).intValue());
				} else if (type == String.class) {  
					field.set(bean, (String)object);
				} else if (type == Double.class) {  
					field.set(bean, ((Double)object).doubleValue());
				} else if (type == Float.class) {  
					field.set(bean, ((Float)object).floatValue());
				} else if (type == Long.class) {  
					field.set(bean, ((Long)object).longValue()); 
				} else if (type == Boolean.class) {  
					field.set(bean, (Boolean)object); 
				} else if (type == Date.class) {  
					field.set(bean, (Date)object);  
				}
				field.setAccessible(accessFlag);  
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				continue;
			}
		}
		return bean;
	}
}
  
  
