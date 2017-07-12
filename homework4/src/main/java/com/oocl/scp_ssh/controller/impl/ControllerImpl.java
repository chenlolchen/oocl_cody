package com.oocl.scp_ssh.controller.impl;

import com.oocl.scp_ssh.controller.Controller;
import com.oocl.scp_ssh.parser.CmdParser;
import com.oocl.scp_ssh.parser.impl.CmdParserImpl;

import java.io.*;

public class ControllerImpl implements Controller {
    private CmdParser parser;
    private InputStream in;
    private OutputStream out;

    public ControllerImpl() {
        this.parser = parser;
    }

    public ControllerImpl(InputStream in, OutputStream out) {
        this.parser = new CmdParserImpl();
        this.in = in;
        this.out = out;
    }

    public StringBuilder commandProcess(String cmd) {
        String[] cmdSplit = cmd.split(" ");
        switch (cmdSplit[0]) {
            case "ls":
                return parser.processLS(cmdSplit);
            case "rm":
                return parser.processRM(cmdSplit);
            case "scp":
//                scp e://aa.txt 127.0.0.1:/ftp/t.txt
                return parser.processSCP(cmdSplit, out);
            default:
                return parser.processERROR();
        }
    }
}
