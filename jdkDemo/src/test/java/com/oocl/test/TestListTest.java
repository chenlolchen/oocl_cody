package com.oocl.test;

import com.oocl.AgeComparator;
import com.oocl.Customer;
import com.oocl.NameComparator;
import org.junit.Test;

import java.util.*;

/**
 * Created by CHENCO7 on 7/10/2017.
 */
public class TestListTest {

    @Test
    public void testStack(){
        Stack<String> stack = new Stack<String>();
        stack.push("aa");
        stack.push("bb");
        String p = stack.pop();
        System.out.println(p);
        System.out.println(stack.size());
    }

    @Test
    public void testQueue(){
        Queue<String> queue = new LinkedList<String>();
        queue.add("abc");
        queue.add("xyz");
        String s = queue.poll();
        System.out.println(s);
        System.out.println(queue.size());
    }

    @Test
    public void testSet(){
        Set<String> set = new HashSet<String>();
        set.add("abc");
        set.add("bcd");
        set.add("123");
        set.add("abc");
        for(String s : set){
            System.out.println(s);
        }
    }

    @Test
    public void testTreeSet(){
        Set<String> set = new TreeSet<String>();
        set.add("abc");
        set.add("bcd");
        set.add("123");
        set.add("abc");
        for(String s : set){
            System.out.println(s);
        }
    }

    @Test
    public void testTreeSetCustomer(){
        Set<Customer> set = new HashSet<Customer>();

        Customer c1 = new Customer();
        c1.id = 2;
        c1.age = 12;
        c1.name = "zhang";

        Customer c2 = new Customer();
        c2.id = 1;
        c2.age = 18;
        c2.name = "chen";

        Customer cc = new Customer();
        cc.age = 18;

        set.add(c1);
        set.add(c2);
        for(Customer c : set){
            System.out.println(c);
        }

        System.out.println(set.contains(cc));
    }


}