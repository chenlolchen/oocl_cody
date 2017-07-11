package com.oocl.handle_data.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public interface CustomerController {
    void scanner(String fileName) throws FileNotFoundException;
    StringBuilder excuteCommand(String commmand) throws IOException;
}
