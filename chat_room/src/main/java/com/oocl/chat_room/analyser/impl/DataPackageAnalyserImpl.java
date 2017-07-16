package com.oocl.chat_room.analyser.impl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.oocl.chat_room.analyser.DataPackageAnalyser;
import com.oocl.chat_room.protocol.DataPackage;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public class DataPackageAnalyserImpl implements DataPackageAnalyser {
	private ObjectOutputStream out;
	private ObjectInputStream in;

	public DataPackageAnalyserImpl(){

	}

	public DataPackageAnalyserImpl(Socket socket){
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public DataPackage readPackage() {
		DataPackage dataPackage = null;
		try {
			dataPackage = (DataPackage)in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dataPackage;
	}

	@Override
	public void sendPackage(DataPackage dataPackage){
		try {
			out.writeObject(dataPackage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
