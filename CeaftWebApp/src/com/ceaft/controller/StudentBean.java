package com.ceaft.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dto.StudentDTO;
import com.ceaft.service.IStudentService;

@ManagedBean(name="student")
public class StudentBean {
	@EJB
	private IStudentService svc;
	private int studentId;
	private StudentDTO studentVO;
	
	/**
	 * 
	 */
	public StudentBean(){
		
	}
	
	/**
	 * @return the svc
	 */
	public IStudentService getSvc() {
		return svc;
	}

	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	/**
	 * @return the studentVO
	 */
	public StudentDTO getStudentVO() {
		return studentVO;
	}

	/**
	 * @param studentVO the studentVO to set
	 */
	public void setStudentVO(StudentDTO studentVO) {
		this.studentVO = studentVO;
	}

	/**
	 * 
	 */
	public void register(){
		try{
			if(studentId > 0){
				studentVO = svc.register(studentId);
			}else{
				//show an error
			}
		}catch(ResourceNotFoundException e){
			//show an error message
			e.printStackTrace();
		}catch (Exception e) {
			//show an error
			e.printStackTrace();
		}
	}
	
}
