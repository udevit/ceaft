package com.ceaft.controller;

import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.chart.PieChartModel;

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
@SessionScoped
public class StudentBean extends CeaftBaseController{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//@EJB
	private IStudentService svc;
	private String studentId;
	private StudentDTO studentVO;
	private PieChartModel pieModel;
	
	/**
	 * 
	 */
	public StudentBean(){
		
	}
	
	@PostConstruct
    public void init() {
		pieModel = new PieChartModel();
        
        pieModel.set("Lunes", 540);
        pieModel.set("Martes", 325);
        pieModel.set("Miercoles", 702);
        pieModel.set("Jueves", 421);
        pieModel.set("Viernes", 150);
        pieModel.set("Sabado", 289);
        pieModel.set("Domingo", 387);
         
        pieModel.setTitle("Historial de Asistencia");
        pieModel.setLegendPosition("w");
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
	 * @return the pieModel
	 */
	public PieChartModel getPieModel() {
		return pieModel;
	}

	/**
	 * @param pieModel the pieModel to set
	 */
	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	/**
	 * 
	 */
	public String register(){
		try{
			if(!StringUtil.isEmpty(studentId)){
				studentVO = svc.register(studentId);
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
