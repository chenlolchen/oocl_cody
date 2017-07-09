package com.oocl.crm.parser;


public interface CmdParser {
	void showData(String inputParamsString);
	void addData(String inputParamsString);
	void deleteData(String inputParamsString);
	void updateData(String inputParamsString);
	void sortData(String inputParamsString);
}
