package com.ceaft.dto;

import java.io.Serializable;

/**
 * 
 * @author Gary
 *
 */
public class StudentDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private RecordDTO record;

	/**
	 * 
	 */
	public StudentDTO(){
		
	}
	
	public StudentDTO(Integer id, String name){
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the record
	 */
	public RecordDTO getRecord() {
		return record;
	}

	/**
	 * @param record the record to set
	 */
	public void setRecord(RecordDTO record) {
		this.record = record;
	}
	
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		hash += (name != null ? name.hashCode() : 0);
		
		return hash;
	}

	@Override
	public boolean equals(Object e) {
		return false;
	}

	@Override
	public String toString() {
		return "StudentDTO[id=" + id + ", name= " + name + "]";
	}
	
}
