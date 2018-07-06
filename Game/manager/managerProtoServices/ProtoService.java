package managerProtoServices;

import com.google.protobuf.Descriptors.MethodDescriptor;

import handlerInterfaces.IHandler;

public class ProtoService {
	public String route;
	public MethodDescriptor methodDescriptor;
	public Class<?> handlerClass;
	
	public ProtoService(String route,MethodDescriptor methodDescriptor,Class<?> handlerClass) {
		this.route = route;
		this.methodDescriptor = methodDescriptor;
		this.handlerClass = handlerClass;
	}
}
