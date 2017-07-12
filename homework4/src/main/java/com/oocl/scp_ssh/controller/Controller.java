package com.oocl.scp_ssh.controller;

import java.io.FileNotFoundException;

public interface Controller {
	public StringBuilder commandProcess(String cmd) throws FileNotFoundException, Exception;
}
