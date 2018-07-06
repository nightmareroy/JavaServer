package handlerInterfaces;

import serverGame.LogicPacket;

public interface IHandler{
	byte[] handle(LogicPacket logicPacket);
}
