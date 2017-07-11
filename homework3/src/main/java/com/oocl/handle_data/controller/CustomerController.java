package com.oocl.handle_data.controller;

import java.io.FileNotFoundException;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public interface CustomerController {
    void scanner(String fileName) throws FileNotFoundException;

    void outputBySortId();

    void outputBySortDate();

    void outputXml();

    String excuteCommand(String commmand);
}
