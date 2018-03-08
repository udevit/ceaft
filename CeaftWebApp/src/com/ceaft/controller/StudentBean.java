package com.ceaft.controller;

//import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dto.StudentDTO;
import com.ceaft.service.IStudentService;
import com.ceaft.util.StringUtil;

/**
 * 
 * @author Gary
 *
 */
@ManagedBean(name="student")
public class StudentBean {
	//@EJB
	private IStudentService svc;
	private String studentId;
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
	public String getStudentId() {
		return studentId;
	}

	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(String studentId) {
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
			if(!StringUtil.isEmpty(studentId)){
				//studentVO = svc.register(studentId);
			}else{
				//show an error
				RequestContext context = RequestContext.getCurrentInstance();
				context.execute("PF('infoMessageDialog').show();");
			}
		}/*catch(ResourceNotFoundException e){
			//show an error message
			e.printStackTrace();
		}*/catch (Exception e) {
			//show an error
			e.printStackTrace();
		}
	}
	
}
