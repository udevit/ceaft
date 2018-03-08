package com.ceaft.model;

import java.io.Serializable;

/*import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;*/

/*@Entity
@Table(name = "user")*/
public class Student implements Serializable {

	/*@Id
	@Basic(optional = false)
    @Column(name = "ID")*/
	private Integer id;
	
	//@Column(name = "NAME")
	private String name;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		return "Student[id=" + id + ", name= " + name + "]";
	}

}
