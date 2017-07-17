package com.oocl.chat_room.analyser;


import com.oocl.chat_room.protocol.DataPackage;

import java.io.IOException;

/**
 * Created by CHENCO7 on 7/13/2017.
 */
public interface DataPackageAnalyser {

    Boolean sendPackage(DataPackage dp);

    DataPackage readPackage() throws Exception;

    void closeSession();

}
