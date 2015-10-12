package com.github.coryebner.coverity_java_candidate_homework;

import java.beans.Expression;
import java.util.Stack;

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
    	
    	System.out.println(expressionParser(equation));
    	
/*    	System.out.println(mult(add(2,2), div(9, 3)));
    	
    	System.out.println("Argument one is " + args[0]);
    	
    	String[] split = equation.split("\\)", 2);
    	
    	for(int i=0; i<split.length; i++){
    		System.out.println(split[i]);
    	}*/
    }
    
    private static int expressionParser(String expression){
    	int result = 0;
    	String subExpression = "";
    	int bracketCount = 0;
    	String regexp = "[\\(+,]";
    	
    	String[] split = expression.split(regexp, 2);
    	System.out.println(split[0]);
    	System.out.println(split[1]);
    	
    	//if(split[0]))
    	
    	switch(split[0]){
    		case "add":
    			break;
    		case "sub":
    			break;
    		case "mult":
    			expressionParser(split[1]);
    			break;
    		case "div":
    			break;
    		case "let":
    			break;
    		default:
    			System.out.println("Not a valid expression");
    	}
    	
    	return result;
    }
    
    private int let(String var, int value, String equation){
    	int result = 0;
    	
    	return result;
    }
    
    /**
     * Divides integer a by integer b and returns the result
     * @param a integer to divide
     * @param b integer to divide a by.
     * @return
     */
    private static int div(int a, int b){
    	return a/b;
    }
    
    /**
     * Multiplies two integers together and returns the result
     * @param a The first Integer
     * @param b The second integer
     * @return
     */
    private static int mult(int a, int b){
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
    private static int add(int a, int b){
		return a + b;
    }
}
