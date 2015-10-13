package com.github.coryebner.coverity_java_candidate_homework;

public class calculations{

	public calculations() {
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
    public int div(int a, int b){
    	return Math.floorDiv(a, b);
    }
    
    /**
     * Multiplies two integers together and returns the result
     * @param a The first Integer
     * @param b The second integer
     * @return
     */
    public int mult(int a, int b){
    	return Math.multiplyExact(a, b);
    }
    
    /**
     * Subtracts integer a from integer b and returns the result
     * @param a integer to subtract from
     * @param b integer to subtract
     * @return
     */
    public int sub(int a, int b){
    	return Math.subtractExact(a, b);
    }
    
    /**
     * Adds two Integers together and returns the result.
     * @param a The first Integer to be added together
     * @param b The second integer to be added together
     * @return	The sum of the addition.
     */
    public int add(int a, int b){
    	return Math.addExact(a, b);
    }
    
    public int operationPrescendence(String s){
    	if(s.equals("("))
    		return 6;
    	else if(s.equals("div|mult"))
    		return 4;
    	else if(s.equals("add|sub"))
    		return 2;
    	return 0;
    }
}