package com.oocl.client;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit com.oocl.chat_room.test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the com.oocl.chat_room.test case
     *
     * @param testName name of the com.oocl.chat_room.test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}
