package com.github.coryebner.calculator;

import java.util.Stack;

/**
 * Parser to parse an equation, compute the result and then print it to the screen
 * 
 * @author Cory Ebner
 *
 */
public class Parser{
	private static final String REGEX = "(?=[\\(\\),])|(?<=[\\(\\),])";
	private Stack<String> operations;
	private Stack<String> values;
	
	Parser(){
		this.operations = new Stack<>();
		this.values = new Stack<>();
	}
	
	/**
	 * Takes an equation and parses it, solving it as it goes along.
	 * This method is based upon code written by Prashant Gautam posted at
	 * http://stackoverflow.com/a/32652277
	 * Original Thread: http://stackoverflow.com/questions/3422673/evaluating-a-math-expression-given-in-string-form
	 * 
	 * @param equation The equation to solve
	 */
	public void parse(String equation){
		calculations calc = new calculations();
		
		String[] split = equation.trim().split(REGEX);
		
		//System.out.println("Printing splits");
		for(int i=0; i < split.length; i++){
			split[i] = split[i].trim();
			//System.out.print("Split " + i + ": ");
    		//System.out.println(split[i]);
    		
    		if(isNumeric(split[i])){
    			values.push(split[i]);
    			System.out.println("pushed " + split[i] + " to values stack");
    		}else if(split[i].equals("(")){
    			operations.push(split[i]);
    			System.out.println("pushed " + split[i] + " to operations stack");
    		}else if(split[i].equals(")")){
    			System.out.println("Reached )");
    			while(!operations.peek().equals("(")){    				
    				performOperand();
    			}
    			System.out.println("popped " + operations.peek() + " from the operations stack");
    			operations.pop(); // remove (
    			performOperand(); // perform the operation before (
    		}else if(split[i].matches("mult|add|sub|div|let")){
    			while(!operations.isEmpty() && 
    					(calc.operationPrescendence(split[i]) 
    							>= calc.operationPrescendence(operations.peek()))){    				
    				performOperand();
    			}
    			operations.push(split[i]);
    			System.out.println("pushed " + split[i] + " to the operations stack");
    		}else if(isCharString(split[i])){
    			values.push(split[i]);
    			System.out.println("pushed " + split[i] + " to the value stack");
    		}else if(split[i].equals(",")){
    
    		}
    		else{
    			System.out.println("invalid expression: " + split[i]);
    		}
    	}
		while(!operations.empty()){
			performOperand();
		}
		System.out.println(values.peek());
	}
	
	/**
	 * Checks to see if the given string is numeric.
	 * 
	 * @param str
	 * @return true if the string is numeric, otherwise false
	 */
	private static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
	
	/**
	 * Checks to see if the string consists of just characters (a-z or A-Z)
	 * @param s
	 * @return
	 */
	private boolean isCharString(String s) {
	    return s.matches("[a-zA-Z]+");
	}
	
	/**
	 * performs the operation at the top of the operations stack.
	 */
	private void performOperand() {
		calculations calc = new calculations();

		String operation = operations.pop();
		String a, b;
		String result = "";
		String temp;

		// printStacks();

		if (operation.equals("let")) {
			System.out.println("Found let operation");
			String top = values.pop();
			System.out.println("temporarily removing value " + top + " from the value stack");
			System.out.println("popped " + values.peek() + " from the value stack");
			values.pop();
			System.out.println("adding value " + top + " back to the value stack");
			values.push(top);
		} else {

			System.out.println("after let");

			b = values.pop();
			a = values.pop();

			System.out.println("Removed " + operation + " from the operation stack");
			System.out.println("removed " + b + " and " + a + " from the values stack");

			if (isCharString(b)) {
				temp = b;
				b = values.peek();
				System.out.println("Setting " + temp + " to " + b);
				if (temp.equals(a)) {
					a = b;
				}
			} else if (isCharString(a)) {
				temp = a;
				a = values.peek();
				System.out.println("Setting " + temp + " to " + a);
				if (temp.equals(b))
					b = a;
			}

			if(isCharString(a)){
				boolean valueFound = false;
				int i = 0;
				int firstLocation = -1;
				firstLocation = values.indexOf(a);
				
				if(firstLocation != -1){
					while(!valueFound && i < values.size()-1){
						if(isNumeric(values.get(i+1))){
							a = values.get(i+1);
							valueFound = true;
						}
						i++;
					}
				}
			}if(isCharString(b)){
				boolean valueFound = false;
				int i = 0;
				int firstLocation = -1;
				firstLocation = values.indexOf(b);
				
				if(firstLocation != -1){
					while(!valueFound && i < values.size()-1){
						if(isNumeric(values.get(i+1))){
							b = values.get(i+1);
							valueFound = true;
						}
						i++;
					}
				}
			}
			
			System.out.println("Performing " + operation + " with " + a + " and " + b);

			if (operation.equals("mult")) {
				result = String.valueOf((calc.mult(Integer.valueOf(a), Integer.valueOf(b))));
			} else if (operation.equals("div")) {
				result = String.valueOf((calc.div(Integer.valueOf(a), Integer.valueOf(b))));
			} else if (operation.equals("add")) {
				result = String.valueOf((calc.add(Integer.valueOf(a), Integer.valueOf(b))));
			} else if (operation.equals("sub")) {
				result = String.valueOf((calc.sub(Integer.valueOf(a), Integer.valueOf(b))));
			} else if (operation.equals("let")) {

			}
			System.out.println("Pushed result " + result + " to the values stack");
			values.push(result);
		}
	}
    
	/**
	 * Prints the current state of the operation and value stack
	 */
    private void printStacks(){
    	System.out.print("operators:");
    	for(int i=0; i<operations.size(); i++){
    		System.out.print(operations.elementAt(i));
    	}
    	System.out.println();
    	System.out.print("values:");
    	for(int i=0; i<values.size(); i++){
    		System.out.print(values.elementAt(i));
    	}
    	System.out.println();
    }
}