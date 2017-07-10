package com.oocl.handle_data.service.impl;

import com.oocl.handle_data.service.CustomerService;
import com.oocl.handle_data.pojo.Customer;
import com.oocl.handle_data.repository.CustomerDataProcess;
import com.oocl.handle_data.repository.impl.CustomerDataProcessImpl;
import com.oocl.handle_data.util.FormatUtil;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class CustomerServiceImpl implements CustomerService {
    public final static String EMAIL_REGULAR = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
    public final static String SEX_REGULAR = "true|false";
    public final static String DATE_REGULAR = "^(19|20)\\d{2}-(1[0-2]|0?[1-9])-(0?[1-9]|[1-2][0-9]|3[0-1])";

    CustomerDataProcess customerDataProcess;

    public CustomerServiceImpl(){
        customerDataProcess = new CustomerDataProcessImpl();
    }

    public Set<Customer> outputBySortId() {
        return customerDataProcess.outputBySortId();
    }

    public Set<Customer> outputBySortDate() {
        return customerDataProcess.outputBySortDate();
    }

    public void insertData(String scannerText) {
        String[] str = FormatUtil.formatSpace(scannerText);
        if( checkByRegular(SEX_REGULAR,str[3]) && checkByRegular(EMAIL_REGULAR,str[2]) && checkByRegular(DATE_REGULAR,str[4]) ){
            customerDataProcess.add(str);
        }
    }

    private boolean checkByRegular(String regular, String scannerText){
        Pattern pattern = Pattern.compile(regular);
        Matcher matcher = pattern.matcher(scannerText);
        return matcher.matches();
    }

}
