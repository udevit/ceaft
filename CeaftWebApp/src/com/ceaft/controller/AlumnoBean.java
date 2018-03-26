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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.chart.PieChartModel;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dto.AlumnoDTO;
import com.ceaft.dto.HistoricoPieDTO;
import com.ceaft.enums.Sexo;
import com.ceaft.service.IAlumnoService;
import com.ceaft.util.StringUtil;

@ManagedBean
@SessionScoped
public class AlumnoBean extends CeaftBaseController{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IAlumnoService svc;
	private String alumnoId;
	private AlumnoDTO alumnoModel;
	private PieChartModel pieModel;
	private StreamedContent foto;
	@ManagedProperty(value="#{messageBean}")
	private MessageBean message;
	
	/**
	 * 
	 */
	public AlumnoBean(){
		
	}
	
	@PostConstruct
    public void init() {
		
	}
	
	/**
	 * @return the alumnoId
	 */
	public String getAlumnoId() {
		return alumnoId;
	}

	/**
	 * @param alumnoId the alumnoId to set
	 */
	public void setAlumnoId(String alumnoId) {
		this.alumnoId = alumnoId;
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
	 * @return the foto
	 */
	public StreamedContent getFoto() {
		FacesContext context = FacesContext.getCurrentInstance();
	    if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
	        return new DefaultStreamedContent();
	    }else {
	    	foto = obtenerFotoAlumno(alumnoModel);
		}
		return foto;
	}

	/**
	 * @param foto the foto to set
	 */
	public void setFoto(StreamedContent foto) {
		this.foto = foto;
	}

	/**
	 * @return the message
	 */
	public MessageBean getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(MessageBean message) {
		this.message = message;
	}

	/**
	 * 
	 */
	public String registrar(){
		try{
			if(!StringUtil.isEmpty(alumnoId)){
				alumnoModel = svc.registrar(alumnoId);
				
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
				message.setIcon("info.png");
				message.setMessage("Favor de ingresar la matrícula del alumno.");
				showWindowDialog("infoMessageDialog");
			}
		}catch(ResourceNotFoundException e){
			//show an error message
			e.printStackTrace();
			message.setIcon("warning.png");
			message.setMessage("El alumno ingreado no se encuentra matriculado.");
			showWindowDialog("infoMessageDialog");
		}catch (Exception e) {
			//show an error
			e.printStackTrace();
			message.setIcon("error.png");
			message.setMessage("Sistema no disponible por el momento. Si el error persiste contacte al administrador.");
			showWindowDialog("infoMessageDialog");
		}
		return "";
	}
	
	/**
	 * 
	 * @return
	 */
	public String cerrarSesion(){
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "cerrar";
	}
	
	/**
	 * 
	 * @param alumnoModel
	 * @return
	 */
	private StreamedContent obtenerFotoAlumno(AlumnoDTO alumnoModel){
		String path = "C:/ceaft/photo/" + alumnoModel.getNombreFoto();
		File file = new File(path);
		StreamedContent photo =  null;
		try{
			if(file.exists()){
				InputStream input = new FileInputStream(file);
				photo = new DefaultStreamedContent(input, Files.probeContentType(Paths.get(path)));
			}else{
				photo = crearFotoDefault(alumnoModel.getSexo());
			}
		}catch(Exception e){
			e.printStackTrace();
			try{
				photo = crearFotoDefault(alumnoModel.getSexo());
			}catch(FileNotFoundException ex){
				ex.printStackTrace();
			}
		}
		
		return photo;
	}
	
	/**
	 * 
	 * @param sexo
	 * @return
	 * @throws FileNotFoundException
	 */
	private StreamedContent crearFotoDefault(Sexo sexo) throws FileNotFoundException{
		String path = "/resources/images/" + (Sexo.MASCULINO.equals(sexo) ? "man.png" : "woman.png");
		String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(path);
		InputStream input = new FileInputStream(new File(realPath));
		return  new DefaultStreamedContent(input, "image/png");
	}

}
