package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Customer;
import service.CustomerManager;
import service.impl.CustomerManagerFactory;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by CHENCO7 on 8/7/2017.
 */
@Controller
public class CustomerController {
    private CustomerManager manager;

    public CustomerController(){
         manager = CustomerManagerFactory.getInstance();
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String add(Customer customer, HttpSession session){
        session.setAttribute("uname", "cody");
        manager.addCustomer(customer);
//        return "forward:/listAll";
        return "redirect:/listAll";
    }

    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public String findAllCustomers(Model model){
        List<Customer> customers = manager.findAllCustomers();
        model.addAttribute("customers", customers);
        return "list";
    }

    @RequestMapping(value = "/testJson")
    @ResponseBody
    public Customer testJson(){
        Customer customer = new Customer();
        customer.setName("速度");
        customer.setSex(true);
        customer.setSalary(27.55);
        customer.setBirth(new Date());
        customer.setId(UUID.randomUUID().toString());
//        return "forward:/listAll";
        return customer;
    }
}
