package handler.base;

import com.google.protobuf.MessageLite;

public interface IHandler<T extends MessageLite,U extends MessageLite> {
	U handle(byte[] requestBytes);
}
