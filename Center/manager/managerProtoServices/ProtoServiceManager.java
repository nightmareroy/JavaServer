package managerProtoServices;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.protobuf.Descriptors.MethodDescriptor;

import common.Out;

public class ProtoServiceManager {
	public static Map<String, ProtoService> protoCenterGameServiceMap=new HashMap<>();
	
	public static void init() {
		List<MethodDescriptor> centerGameMdList = protoCenterGame.Services.Handler.getDescriptor().getMethods();
		for (MethodDescriptor methodDescriptor : centerGameMdList) {
			Class<?> handlerC=null;
			try {
				String[] routeStrs=methodDescriptor.getFullName().split("\\.");
				String className = routeStrs[0]+"."+routeStrs[2]+"Handler";
				handlerC = Class.forName(className);
			} catch (Exception e) {
				Out.warn("CenterGame Handler:"+methodDescriptor.getName()+",未定义！");
			}
			ProtoService protoService = new ProtoService(methodDescriptor.getFullName(),methodDescriptor,handlerC);
			protoCenterGameServiceMap.put(protoService.route, protoService);
			
		}
		
		
		for (Field field : ProtoServiceNameList.class.getFields()) {
			String route=null;
			try {
				route=(String)field.get(String.class);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			if(!protoCenterGameServiceMap.containsKey(route)) {
				Out.error("proto源文件中没有 ",route,"的定义");
			}
		}
		Out.info("protoServiceNameList检测完毕！");
	}
}
