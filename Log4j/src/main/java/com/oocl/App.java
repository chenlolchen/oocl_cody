package com.oocl;


import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Logger logger = Logger.getLogger(App.class);
//        Logger logger = Logger.getRootLogger();
        logger.debug("test...");
        System.out.println( "Hello World!" );
    }
}
