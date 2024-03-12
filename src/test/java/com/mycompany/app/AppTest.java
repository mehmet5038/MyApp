package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.TestCase;


//Unit test for simple App.
 
public class AppTest 
    extends TestCase
{
	
    //@param testName name of the test case  
    public AppTest( String testName )
    {
        super( testName );
    }    
    
    //@return the suite of tests being tested    
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testEmptyList() {
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] array = {3, 4};
        String result = new App().createUsername(list, array, "Mehmet", "Karatekin");
        assertEquals("Karatekin0Mehmet", result);
    }
    
    public void testEmptyArray() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Integer[] array = {};
        String result = new App().createUsername(list, array, "Mehmet", "Karatekin");
        assertEquals("Karatekin3Mehmet", result);
    }
    
    public void testEmptyStrings() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Integer[] array = {3, 4};
        String result = new App().createUsername(list, array, "", "");
        assertEquals("36", result);
    }
    
    public void testEmptyListAndArray() {
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] array = {};
        String result = new App().createUsername(list, array, "Mehmet", "Karatekin");
        assertEquals("Karatekin0Mehmet", result);
    }
    
    public void testAllParametersEmpty() {
        ArrayList<Integer> list = new ArrayList<>();
        Integer[] array = {};
        String result = new App().createUsername(list, array, "", "");
        assertEquals("0", result);
    }
    
    public void testNegativeNumbers() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-2);
        Integer[] array = {-3, -4};
        String result = new App().createUsername(list, array, "Mehmet", "Karatekin");
        assertEquals("Karatekin-36Mehmet", result);
    }
}
