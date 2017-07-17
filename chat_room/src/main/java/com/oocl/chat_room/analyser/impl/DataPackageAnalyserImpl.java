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
	private Socket socket;

	public DataPackageAnalyserImpl(){

	}

	public DataPackageAnalyserImpl(Socket socket){
		try {
			this.socket = socket;
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public DataPackage readPackage() throws Exception {
		DataPackage dataPackage = null;
		dataPackage = (DataPackage)in.readObject();
		return dataPackage;
	}

	@Override
	public Boolean sendPackage(DataPackage dataPackage){
		if(socket.isClosed()){
			return false;
		}
		try {
			out.writeObject(dataPackage);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public void closeSession(){
		try {
			out.close();
			in.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
