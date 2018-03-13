package com.ceaft.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.chart.PieChartModel;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dto.AlumnoDTO;
import com.ceaft.dto.HistoricoPieDTO;
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
	private PieChartModel pieModel;
	private StreamedContent photo;
	
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
	 * @return the photo
	 */
	public StreamedContent getPhoto() {
		if(photo == null){
			photo = getPhotoFromDisk(alumnoModel.getPhotoName());
		}
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(StreamedContent photo) {
		this.photo = photo;
	}

	/**
	 * 
	 */
	public String register(){
		try{
			if(!StringUtil.isEmpty(studentId)){
				alumnoModel = svc.register(studentId);
				
				//creating pie model
				pieModel = new PieChartModel();
				for(HistoricoPieDTO pieData : alumnoModel.getHistoricoPieData()){
					pieModel.set(pieData.getDia(), pieData.getValor());
				}
				pieModel.setTitle("Historial de Asistencia");
		        pieModel.setLegendPosition("w");
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
	
	/**
	 * 
	 * @param photoName
	 * @return
	 * @throws FileNotFoundException
	 */
	private StreamedContent getPhotoFromDisk(String photoName){
		String path = "C:/ceaft/photo/" + photoName;
		File file = new File(path);
		StreamedContent photo =  null;
		try{
			if(file.exists()){
				InputStream input = new FileInputStream(file);
				photo = new DefaultStreamedContent(input, Files.probeContentType(Paths.get(path)));
			}else{
				photo = createDefaultContent();
			}
		}catch(Exception e){
			e.printStackTrace();
			try{
				photo = createDefaultContent();
			}catch(FileNotFoundException ex){
				ex.printStackTrace();
			}
		}
		
		return photo;
	}
	
	/**
	 * 
	 * @return
	 * @throws FileNotFoundException
	 */
	private StreamedContent createDefaultContent() throws FileNotFoundException{
		String path = "/resources/images/man.png";
		String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(path);
		InputStream input = new FileInputStream(new File(realPath));
		return  new DefaultStreamedContent(input, "image/png");
	}
	
}
