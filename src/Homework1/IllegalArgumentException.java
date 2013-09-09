package Homework1;

public class IllegalArgumentException extends Exception{
	/**
	 * Creates new default IllegalArgumentException exception
	 */
	public IllegalArgumentException(){
		super("Invalid range of the position");
	}

	/**
	 * Creates new IllegalArgumentException exception with a String parameter
	 * @param message
	 * the String for a new exception 
	 */
	public IllegalArgumentException(String message){
		super(message);
	}
}