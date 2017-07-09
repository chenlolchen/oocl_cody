package com.oocl.crm.parser.impl;

import com.oocl.crm.bean.Student;
import com.oocl.crm.exception.FormatException;
import com.oocl.crm.parser.CmdParser;
import com.oocl.crm.repository.StudentDataProcess;
import com.oocl.crm.repository.impl.StudentDataProcessImpl;

public class CmdParserImpl implements CmdParser {
	
	private StudentDataProcess studentDataProcess;

	public CmdParserImpl() {
		studentDataProcess = new StudentDataProcessImpl();
	}

	public StudentDataProcess getStudentDataProcess() {
		return studentDataProcess;
	}

	public void setStudentDataProcess(StudentDataProcess studentDataProcess) {
		this.studentDataProcess = studentDataProcess;
	}

	@Override
	public void showData(String inputParamsString) {
		if (inputParamsString.trim().equals("L")) {
			studentDataProcess.iterateAll();
		} else {
			String[] searchItem = inputParamsString.trim().split(":");
			String key = searchItem[0];
			String value = searchItem[1];
			studentDataProcess.iterateByKey(key, value);
		}
	}

	@Override
	public void addData(String inputParamsString) {
		String[] paramsStringList = inputParamsString.trim().split(",");
		Student student = new Student();
		setParamsToStudent(student, paramsStringList);
		int id = studentDataProcess.getIdCounter();
		student.setId(id);
		studentDataProcess.setIdCounter(id + 1);
		studentDataProcess.addData(student);
	}

	@Override
	public void deleteData(String inputParamsString) {
		int deleteID = Integer.parseInt(inputParamsString.trim());
		if (deleteID > 0 && deleteID <= studentDataProcess.getIdCounter()) {
			if (studentDataProcess.exitDataID(deleteID)) {
				System.out.println("success delete");
			} else {
				System.out.println("your input id is not exit");
			}
		} else {
			System.out.println("please input id between 0 - " + studentDataProcess.getIdCounter());
		}
	}

	@Override
	public void updateData(String inputParamsString) {
		String[] updateParamsSplit = inputParamsString.split(" ");
		int editID = Integer.parseInt(updateParamsSplit[0]);
		String[] paramsStringList = updateParamsSplit[1].trim().split(",");
		Student student = (Student) studentDataProcess.getDataById(editID);
		if(student != null){
			setParamsToStudent(student, paramsStringList);
			if (editID > 0 && editID <= studentDataProcess.getIdCounter()) {
				if (studentDataProcess.updateByDataID(editID, student)) {
					System.out.println("update success");
				} else {
					System.out.println("your input id is not exit");
				}
			} else {
				System.out.println("please check your input id between 0 - " + studentDataProcess.getIdCounter());
			}
		}else {
			System.out.println("can not found student id");
		}
	}

	@Override
	public void sortData(String inputParamsString) {
		String sortString = inputParamsString.trim();
		if (sortString.equals("name")) {
			studentDataProcess.sortByName();
		} else if (sortString.equals("id")) {
			studentDataProcess.sortById();
		} else {
			System.out.println("please input a name or id");
		}
	}

	private void setParamsToStudent(Student student, String[] paramsStringList) {
		for (String item : paramsStringList) {
			String[] s = item.split(":");
			String key = s[0];
			String value = s[1];
			switch (key) {
				case "name":
					student.setName(value);
					break;
				case "sex":
					student.setSex(value);
					break;
				case "birthDay":
					student.setBirthDay(value);
					break;
				case "address":
					student.setAddress(value);
					break;
				case "call":
					student.setCall(value);
					break;
				default:
					throw new FormatException();
			}
		}
	}
}
