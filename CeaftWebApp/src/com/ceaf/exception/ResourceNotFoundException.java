package com.ceaf.exception;

/**
 * 
 * @author Gary
 *
 */
public class ResourceNotFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg){
		super(msg);
	}
	
	public ResourceNotFoundException(String msg, Throwable cause){
		super(msg, cause);
	}
	
}
