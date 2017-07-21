package com.oocl.chat_room.action.server_web;

import java.net.Socket;

public interface ServerWebAction {
	void actionHandler(Socket socket);
}
