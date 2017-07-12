package com.oocl.scp_ssh.parser.impl;

import com.oocl.scp_ssh.parser.CmdParser;

import java.io.*;

/**
 * Created by chen on 2017/7/12.
 */
public class CmdParserImpl implements CmdParser {
    private StringBuilder sb;
    private File file;

    @Override
    public StringBuilder processLS(String[] cmd) {
        sb = new StringBuilder();
        file = new File("ftp/");
        String[] str = file.list();
        for (String s : str) {
            sb.append(s).append("\t");
        }
        sb.append("\n");
        return sb;
    }

    @Override
    public StringBuilder processRM(String[] cmd) {
        sb = new StringBuilder();
        file = new File("ftp/" + cmd[1]);
        if (file.delete()) {
            sb.append("delete success").append("\n");
        } else {
            sb.append("delete error").append("\n");
        }
        return sb;
    }

    @Override
    public StringBuilder processSCP(String[] cmd, OutputStream out) {
        sb = new StringBuilder();
        try {
            file = new File(cmd[1]);
            if(file == null){
                throw new FileNotFoundException();
            }
            FileInputStream fi = new FileInputStream(file);
            String[] ss = cmd[2].split(":/");
            out = new FileOutputStream(ss[1]);
            byte[] buf = new byte[4];
            int len = 0;
            while ((len = fi.read(buf)) != -1) {
                out.write(buf);
            }
        } catch (Exception e) {
            sb.append("upload error").append("\n");
        }
        sb.append("upload success").append("\n");
        return sb;
    }

    @Override
    public StringBuilder processERROR() {
        sb = new StringBuilder();
        sb.append("command not found");
        sb.append("\n");
        return sb;
    }
}
