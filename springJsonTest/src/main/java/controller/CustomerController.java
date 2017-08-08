package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.Customer;
import service.CustomerManager;
import service.impl.CustomerManagerFactory;

import java.util.List;

/**
 * Created by CHENCO7 on 8/7/2017.
 */
@RestController
public class CustomerController {
    private CustomerManager manager;

    public CustomerController(){
         manager = CustomerManagerFactory.getInstance();
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST, consumes = "application/json")
    public Customer addCustomer(@RequestBody Customer customer){
        return manager.addCustomer(customer);
    }

    @RequestMapping(value = "listAll", method = RequestMethod.GET)
    public List<Customer> findAllCustomers(){
        return manager.findAllCustomers();
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteCustomer(@PathVariable String id){
        return manager.deleteCustomerById(id);
    }

    @RequestMapping(value = "customer/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Customer loadCustomer(@PathVariable String id){
        return manager.loadCustomerById(id);
    }

    @RequestMapping(value = "customer", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public Customer updateCustomer(@RequestBody Customer customer){
        System.out.println(customer);
        return manager.updateCustomer(customer);
    }

}
