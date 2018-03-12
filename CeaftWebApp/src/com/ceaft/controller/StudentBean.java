package com.ceaft.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dto.AlumnoDTO;
import com.ceaft.service.IStudentService;
import com.ceaft.util.StringUtil;

/**
 * 
 * @author Gary
 *
 */
@ManagedBean(name="student")
@SessionScoped
public class StudentBean extends CeaftBaseController{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IStudentService svc;
	private String studentId;
	private AlumnoDTO alumnoModel;
	
	/**
	 * 
	 */
	public StudentBean(){
		
	}
	
	@PostConstruct
    public void init() {
		
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
	 * @return the alumnoModel
	 */
	public AlumnoDTO getAlumnoModel() {
		return alumnoModel;
	}

	/**
	 * @param alumnoModel the alumnoModel to set
	 */
	public void setAlumnoModel(AlumnoDTO alumnoModel) {
		this.alumnoModel = alumnoModel;
	}

	/**
	 * 
	 */
	public String register(){
		try{
			if(!StringUtil.isEmpty(studentId)){
				alumnoModel = svc.register(studentId);
				return "info";
			}else{
				//show an error
				addRequestParameter("logo", "info.png");
				addRequestParameter("message", "Favor de ingresar la matrícula del alumno.");
				hideWindowDialog("userDialog");
				showWindowDialog("infoMessageDialog");
			}
		}catch(ResourceNotFoundException e){
			//show an error message
			e.printStackTrace();
			addRequestParameter("logo", "warning.png");
			addRequestParameter("message", "Favor de ingresar la matrícula del alumno.");
			hideWindowDialog("userDialog");
			showWindowDialog("infoMessageDialog");
		}catch (Exception e) {
			//show an error
			e.printStackTrace();
			printErrorMessage("Ceaft Web App", "Sistema no disponible por el momento. Si el error persiste contacte al administrador.");
		}
		return "";
	}
	
}
