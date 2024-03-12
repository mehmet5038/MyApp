package com.mycompany.app;

import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
    
    //creates a mixed username of numbers and characters which depends on user's input
    
    public static String createUsername(ArrayList<Integer> list, Integer[] array, String string1, String string2) {
    	Integer result = 0;
    	for (Integer i : list) {
			result += i;
		}
    	for (Integer i : array) {
			result *= i;
		}
    	return string2 + result.toString() + string1;
    }
}
