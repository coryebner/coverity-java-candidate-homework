package com.github.coryebner.coverity_java_candidate_homework;

import java.beans.Expression;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class Calculator 
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
    	
    	
    	Parser parser = new Parser();
    	parser.parse(equation);
    }
}
