package com.oocl.scp_ssh.parser;

import java.io.OutputStream;

/**
 * Created by chen on 2017/7/12.
 */
public interface CmdParser {
    StringBuilder processLS(String[] cmd);

    StringBuilder processRM(String[] cmd);

    StringBuilder processSCP(String[] cmd, OutputStream out);

    StringBuilder processERROR();
}
