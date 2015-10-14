package com.github.coryebner.calculator;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class Calculator 
{
	private final static Logger log = Logger.getLogger("myLogger");
	
    public static void main( String[] args )
    {
    	String equation = "";
    	String verbose = "";
    	Handler console = new ConsoleHandler();
    	console.setLevel(Level.ALL);
    	log.addHandler(console);
    	log.setUseParentHandlers(false);
    	
    	//rebuild the equation to solve from the command line
    	for(int i=0; i < args.length; i++){
    		if(args[i].startsWith("-"))
    			break;
    		equation += args[i];
    	}
    	
    	if(args[args.length-1].startsWith("-")){
    		verbose = args[args.length-1];
    		verbose = verbose.toUpperCase();
    	}
    	
    	if(verbose.equals("-INFO")){
    		log.setLevel(Level.INFO);
    	}else if(verbose.equals("-ERROR")){
    		log.setLevel(Level.SEVERE);
    	}else if(verbose.equals("-DEBUG")){
    		log.setLevel(Level.FINE);
    	}else{
    		log.setLevel(Level.OFF);	
    	}
    	
    	
    	log.info("Equation to solve is: " + equation);
    	log.info("Verbose level is: " + verbose);    	
    	
    	Parser parser = new Parser();
    	parser.parse(equation);
    }
}
