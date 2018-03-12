package com.ceaft.service.impl;

import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.primefaces.model.chart.PieChartModel;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.dao.IAlumnoDAO;
import com.ceaft.dao.IAlumnoMatriculadoDAO;
import com.ceaft.dao.IAsistenciaDAO;
import com.ceaft.dto.AlumnoDTO;
import com.ceaft.dto.AsistenciaDTO;
import com.ceaft.model.Alumno;
import com.ceaft.model.AlumnoMatriculado;
import com.ceaft.model.Asistencia;
import com.ceaft.service.IStudentService;

@Stateless
public class StudentServiceImpl implements IStudentService{

	@EJB
	private IAlumnoDAO iAlumnoDAO;
	
	@EJB
	private IAlumnoMatriculadoDAO iAlumnoMatriculadoDAO;
	
	@EJB
	private IAsistenciaDAO iAsistenciaDAO;
	
	@Override
	public AlumnoDTO register(String id) throws ResourceNotFoundException {
		try{
			AlumnoMatriculado alumnoMatriculado = iAlumnoMatriculadoDAO.buscarAlumno(id);
			if(alumnoMatriculado != null){
				Alumno alumno= iAlumnoDAO.buscarAlumno(alumnoMatriculado.getMatric());
				AlumnoDTO alumnoDTO = new AlumnoDTO(id, alumno.getNom());
				alumnoDTO.setNombreCurso(alumnoMatriculado.getGrupo().getCurso().getNombre());
				alumnoDTO.setNombreProfesor(alumnoMatriculado.getGrupo().getProf());
				alumnoDTO.setHorario(alumnoMatriculado.getGrupo().getHorario());
				List<Asistencia> asistencias = iAsistenciaDAO.obtenerAsistencias(id);
				String estados[] = {"green-circle.png", "yellow-circle.png", "red-circle.png"};
				for(Asistencia attdnc : asistencias){
					alumnoDTO.getAsistencia().add(new AsistenciaDTO(attdnc.getFecha(), estados[new Random().nextInt(3)]));
				}
				
				PieChartModel pieModel = new PieChartModel();
				pieModel.set("Lunes", 540);
		        pieModel.set("Martes", 325);
		        pieModel.set("Miercoles", 702);
		        pieModel.set("Jueves", 421);
		        pieModel.set("Viernes", 150);
		        pieModel.set("Sabado", 289);
		        pieModel.set("Domingo", 387);
		         
		        pieModel.setTitle("Historial de Asistencia");
		        pieModel.setLegendPosition("w");
				alumnoDTO.setPieModel(pieModel);
				return alumnoDTO;
			}else{
				throw new ResourceNotFoundException("<< Estudiante no encontrado >>");
			}
		}catch(Exception e){
			throw e;
		}
	}

}
