package main;

import java.lang.reflect.Field;
import java.util.Map;

import org.json.JSONObject;


import common.Config;
import common.FileUtil;
import common.Out;

public class PreMain {
	public static String configsPath="configs/";
	
	public static void main(String[] args) {
		String jsonStr = FileUtil.readAll(configsPath+"config.json");
		JSONObject configJO=new JSONObject(jsonStr);
		for (Map.Entry<String, Object> entry : configJO.toMap().entrySet()) {
			Out.debug(entry.getKey());
//			JSONObject jsonObject = (JSONObject)entry.getValue();
//			Out.debug(entry.getValue() instanceof Map<?, ?>);
//			Out.debug(entry.getValue() instanceof JSONTokener);
			Map<?, ?> so=(Map<?, ?>)entry.getValue();
			for (Map.Entry<?, ?> entry2 : so.entrySet()) {
				Out.debug(entry2.getKey(),":",entry2.getValue());
				Out.debug(entry2.getValue() instanceof Integer);
			}
			
		}
	}
	
	static void genCode(Class c,Map<?, ?> map) {
		for (Map.Entry<?, ?> entry : map.entrySet()) {
			if(entry.getValue() instanceof Integer) {
//				Field field=new field
			}
		}
	}
}
