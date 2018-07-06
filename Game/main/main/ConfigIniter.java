package main;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;


import common.FileUtil;
import common.Out;

public class ConfigIniter {
	public static String configsJsonPath="configs/config.json";
	public static String configsSrcPath="common/common/Config.java";
	
	public static void main(String[] args) {
		
		String jsonStr = FileUtil.read(configsJsonPath);
		JSONObject configJO=new JSONObject(jsonStr);
		StringBuilder fieldSb=new StringBuilder();
		fieldSb.append("package common;\n");
		fieldSb.append("public class Config {\n");
		genCode(fieldSb, configJO.toMap(),1);
		fieldSb.append("}\n");
		
		FileUtil.write(configsSrcPath, fieldSb.toString());
		Out.info("sucess!");
	}

	static void genCode(StringBuilder fieldSb,Map<?, ?> map,int deep) {

		for (Map.Entry<?, ?> entry : map.entrySet()) {
			String key=(String)entry.getKey();
			if(entry.getValue() instanceof Map<?, ?>) {
				for(int i=0;i<deep;i++) {
					fieldSb.append("	");
				}
				fieldSb.append(String.format("public static class %s {\n",key));
				deep++;
				genCode(fieldSb, (Map<?, ?>)entry.getValue(),deep);
				deep--;
				for(int i=0;i<deep;i++) {
					fieldSb.append("	");
				}
				fieldSb.append("}\n");
			}
			
			//列表里面只能放int和string类型
			else if(entry.getValue() instanceof List<?>) {
				List<?> list=(List<?>)entry.getValue();
				if(list.size()>0) {
					for(int i=0;i<deep;i++) {
						fieldSb.append("	");
					}
					if(list.get(0) instanceof Integer) {
						fieldSb.append(String.format("public static final int[] %s = new int[] {",key));
						for (Object item : list) {
							fieldSb.append((Integer)item);
							fieldSb.append(",");
						}
					}
					else if(list.get(0) instanceof String) {
						fieldSb.append(String.format("public static final String[] %s = new String[] {",key));
						for (Object item : list) {
							fieldSb.append("\"");
							fieldSb.append((String)item);
							fieldSb.append("\",");
						}
					}
					fieldSb.append("};\n");
				}
			}
			else if(entry.getValue() instanceof Integer) {
				for(int i=0;i<deep;i++) {
					fieldSb.append("	");
				}
				fieldSb.append(String.format("public static final int %s = %s;\n",key,(Integer)entry.getValue()));
			}
			else if(entry.getValue() instanceof String) {
				for(int i=0;i<deep;i++) {
					fieldSb.append("	");
				}
				fieldSb.append(String.format("public static final String %s = \"%s\";\n",key,(String)entry.getValue()));
			}
			else if(entry.getValue() instanceof Boolean) {
				for(int i=0;i<deep;i++) {
					fieldSb.append("	");
				}
				fieldSb.append(String.format("public static final Boolean %s = %s;\n",key,(Boolean)entry.getValue()));
			}
		}
	}
}
