package com.oocl.avata;

import com.oocl.advanced.Customer;
import org.junit.Test;

import java.io.*;

/**
 * Created by CHENCO7 on 7/11/2017.
 */
public class Test2 {
    @Test
    public void testSerializable() throws Exception{
        Customer customer = new Customer();
        customer.setId(2);
        customer.setAge(23);
        customer.setName("chen");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("obj.data"));
        out.writeObject(customer);
        out.close();
    }

    @Test
    public void testReadSerializable() throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("obj.data"));
        Customer customer = (Customer) in.readObject();
        System.out.println(customer.getName());
        in.close();
    }

    @Test
    public void testWriter() throws Exception{
        Writer writer = new FileWriter("fwdata.txt");
        writer.write('珠');
        writer.close();
    }

    @Test
    public void testReader() throws Exception{
        Reader reader = new FileReader("fwdata.txt");
        System.out.println((char) reader.read());
        reader.close();
    }

    @Test
    public void testBufferReader() throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader("data1.txt"));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
    }

    @Test
    public void testBufferReader2() throws Exception{
//        InputStream in = new FileInputStream("data1.txt");
        InputStream in = new FileInputStream("data2.txt");

//        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in,"gbk"));
        String line;
        while ((line = reader.readLine()) != null){
            System.out.println(line);
        }
        reader.close();
    }


}
