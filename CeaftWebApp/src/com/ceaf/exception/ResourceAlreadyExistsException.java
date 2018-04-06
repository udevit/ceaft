package com.ceaf.exception;

/**
 * 
 * @author Gary
 *
 */
public class ResourceAlreadyExistsException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExistsException(String msg){
		super(msg);
	}
	
	public ResourceAlreadyExistsException(String msg, Throwable cause){
		super(msg, cause);
	}
	
}
