package com.oocl.chat_room.analyser;


import com.oocl.chat_room.protocol.DataPackage;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public interface DataPackageAnalyser {

    void sendPackage(DataPackage dp);

    DataPackage readPackage();

}
