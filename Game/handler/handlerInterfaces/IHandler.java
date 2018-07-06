package handlerInterfaces;

import clientCenter.LogicPacket;

public interface IHandler{
	byte[] handle(LogicPacket logicPacket);
}
