package main;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;


import common.Config;
import common.FileUtil;
import common.Out;

public class ConfigIniter {
	public static String configsJsonPath="configs/config.json";
	public static String configsSrcPath="src/main/java/common/Config.java";
	
	public static void main(String[] args) {
		
		String jsonStr = FileUtil.read(configsJsonPath);
		JSONObject configJO=new JSONObject(jsonStr);
		StringBuilder fieldSb=new StringBuilder();
		fieldSb.append("package common;\n");
		fieldSb.append("public class Config {\n");
		genCode(fieldSb, configJO.toMap(),1);
		fieldSb.append("}\n");
		
		FileUtil.write(configsSrcPath, fieldSb.toString());
		
	}

	static void genCode(StringBuilder fieldSb,Map<?, ?> map,int deep) {

		for (Map.Entry<?, ?> entry : map.entrySet()) {
			String key=(String)entry.getKey();
			if(entry.getValue() instanceof Map<?, ?>) {
				for(int i=0;i<deep;i++) {
					fieldSb.append("	");
				}
				fieldSb.append(String.format("public class %s {\n",key));
				deep++;
				genCode(fieldSb, (Map<?, ?>)entry.getValue(),deep);
				deep--;
				for(int i=0;i<deep;i++) {
					fieldSb.append("	");
				}
				fieldSb.append("}\n");
			}
			else if(entry.getValue() instanceof Integer) {
				for(int i=0;i<deep;i++) {
					fieldSb.append("	");
				}
				fieldSb.append(String.format("public static final int %s = %s;\n",key,(int)entry.getValue()));
			}
			else if(entry.getValue() instanceof String) {
				for(int i=0;i<deep;i++) {
					fieldSb.append("	");
				}
				fieldSb.append(String.format("public static final String %s = \"%s\";\n",key,(String)entry.getValue()));
			}
		}
	}
}
