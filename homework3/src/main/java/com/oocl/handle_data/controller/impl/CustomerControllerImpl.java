package com.oocl.handle_data.controller.impl;

import com.oocl.handle_data.controller.CustomerController;
import com.oocl.handle_data.exception.FormatException;
import com.oocl.handle_data.printer.DataPrinter;
import com.oocl.handle_data.printer.impl.DataPrinterImpl;
import com.oocl.handle_data.service.CustomerService;
import com.oocl.handle_data.service.impl.CustomerServiceImpl;
import com.oocl.handle_data.pojo.Customer;
import com.oocl.handle_data.util.FormatUtil;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class CustomerControllerImpl implements CustomerController {
    CustomerService customerService;
    DataPrinter dataPrinter;

    public CustomerControllerImpl(){
        customerService = new CustomerServiceImpl();
        dataPrinter = new DataPrinterImpl();
    }

    public void scanner(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(fileName));
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            customerService.insertData(s);
        }
    }

    public StringBuilder excuteCommand(String commmand) throws IOException {
        Map<String,String> map = FormatUtil.formatCommand(commmand);
        String operate = map.get("operate");
        String type = map.get("type");
        String parameterName = map.get("parameter");
        if(operate.equals("L") && type.equals("xml") && parameterName.equals("id")){
            return outputXmlId();
        }else if(operate.equals("L") && type.equals("line") && parameterName.equals("birth")){
            return outputLineDate();
        }else if(operate.equals("C") && type.equals("xml") && parameterName.equals("id")){
            return createXmlId();
        }else{
            throw new FormatException("找不到该命令");
        }
    }

    private StringBuilder outputLineDate() {
        StringBuilder sb = new StringBuilder();
        Set<Customer> set = customerService.outputBySortDate();
        sb = dataPrinter.print(set,"line");
        return sb;
    }

    private StringBuilder outputXmlId() {
        StringBuilder sb = new StringBuilder();
        Set<Customer> set = customerService.outputBySortId();
        sb = dataPrinter.print(set,"xml");
        return sb;
    }

    private StringBuilder createXmlId() throws IOException {
        StringBuilder sb = new StringBuilder();
        Set<Customer> set = customerService.outputBySortId();
        sb = dataPrinter.print(set,"xml");
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("data.txt"));
        out.write(sb.toString().getBytes());
        out.close();
        return new StringBuilder("create success");
    }
}
