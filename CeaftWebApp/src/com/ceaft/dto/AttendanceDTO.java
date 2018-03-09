package com.ceaft.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Gary
 *
 */
public class AttendanceDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date arrivalTime;
	
	/**
	 * 
	 */
	public AttendanceDTO(){
		
	}
	
	/**
	 * 
	 * @param arrivalTime
	 */
	public AttendanceDTO(Date arrivalTime){
		this.arrivalTime = arrivalTime;
	}
	
	/**
	 * @return the arrivalTime
	 */
	public Date getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
}
