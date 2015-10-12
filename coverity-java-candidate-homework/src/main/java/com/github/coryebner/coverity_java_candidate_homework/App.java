package com.github.coryebner.coverity_java_candidate_homework;

import javax.swing.plaf.OptionPaneUI;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String equation = "";
    	String verbose = "";

    	for(int i=0; i < args.length; i++){
    		if(args[i].startsWith("-"))
    			break;
    		equation += args[i];
    	}
    	
    	if(args[args.length-1].startsWith("-")){
    		verbose = args[args.length-1];
    	}
    	System.out.println(equation);
    	System.out.println(verbose);
    	
    	
//    	System.out.println("Argument one is " + args[0]);
//    	
//    	String[] split = args[0].split("\\(", 2);
//    	
//    	for(int i=0; i<split.length; i++){
//    		System.out.println(split[i]);
//    	}
    }
    
    /**
     * Multiplies two integers together and returns the result
     * @param a The first Integer
     * @param b The second integer
     * @return
     */
    private int mult(int a, int b){
    	return a*b;
    }
    
    /**
     * Subtracts integer a from integer b and returns the result
     * @param a integer to subtract from
     * @param b integer to subtract
     * @return
     */
    private int sub(int a, int b){
    	return a-b;
    }
    
    /**
     * Adds two Integers together and returns the result.
     * @param a The first Integer to be added together
     * @param b The second integer to be added together
     * @return	The sum of the addition.
     */
    private int add(int a, int b){
		return a + b;
    }
}
