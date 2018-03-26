package com.ceaft.service.impl;

import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ceaf.exception.ResourceNotFoundException;
import com.ceaft.enums.Sexo;
import com.ceaft.dao.IAdeudoDAO;
import com.ceaft.dao.IAlumnoDAO;
import com.ceaft.dao.IAlumnoMatriculadoDAO;
import com.ceaft.dao.IAsistenciaDAO;
import com.ceaft.dto.AlumnoDTO;
import com.ceaft.dto.AsistenciaDTO;
import com.ceaft.dto.DeudaDTO;
import com.ceaft.dto.HistoricoPieDTO;
import com.ceaft.model.Alumno;
import com.ceaft.model.AlumnoMatriculado;
import com.ceaft.model.Asistencia;
import com.ceaft.model.Deuda;
import com.ceaft.service.IAlumnoService;

@Stateless
public class AlumnoServiceImpl implements IAlumnoService{

	@EJB
	private IAlumnoDAO iAlumnoDAO;
	
	@EJB
	private IAlumnoMatriculadoDAO iAlumnoMatriculadoDAO;
	
	@EJB
	private IAsistenciaDAO iAsistenciaDAO;
	
	@EJB
	private IAdeudoDAO iAdeudoDAO;
	
	@Override
	public AlumnoDTO registrar(String id) throws ResourceNotFoundException {
		try{
			AlumnoMatriculado alumnoMatriculado = iAlumnoMatriculadoDAO.buscarAlumno(id);
			if(alumnoMatriculado != null){
				Alumno alumno = iAlumnoDAO.buscarAlumno(alumnoMatriculado.getMatric());
				AlumnoDTO alumnoDTO = new AlumnoDTO(id, alumno.getNom());
				alumnoDTO.setSexo(Sexo.MASCULINO);
				String photoTmp[] = {"IMG-201.png", "udev-logo.jpg"};
				alumnoDTO.setNombreFoto(photoTmp[new Random().nextInt(2)]);
				alumnoDTO.setNombreCurso(alumnoMatriculado.getGrupo().getCurso().getNombre());
				alumnoDTO.setNombreProfesor(alumnoMatriculado.getGrupo().getProf());
				alumnoDTO.setHorario(alumnoMatriculado.getGrupo().getHorario());
				alumnoDTO.setDiasClase(alumnoMatriculado.getGrupo().getCurso().getDiasClase());
				List<Asistencia> asistencias = iAsistenciaDAO.obtenerAsistencias(id);
				//TODO remover cuando se tenga la funcionalidad
				String estados[] = {"green-circle.png", "yellow-circle.png", "red-circle.png"};
				//
				for(Asistencia attdnc : asistencias){
					alumnoDTO.getAsistencia().add(new AsistenciaDTO(attdnc.getFecha(), estados[new Random().nextInt(3)]));
				}
				List<Deuda> dedudas = iAdeudoDAO.obtenerDeudas(id);
				for(Deuda deuda : dedudas){
					alumnoDTO.getDeuda().add(new DeudaDTO(deuda.getFolio(), deuda.getAdeudoTot().doubleValue(), 
						deuda.getMontoRecup(), deuda.getMontoExtra()));
				}
				
				List<HistoricoPieDTO> historicoPie = iAsistenciaDAO.obtenerHistoricoPie(id);
				for(HistoricoPieDTO historico :  historicoPie){
					alumnoDTO.getHistoricoPieData().add(new HistoricoPieDTO(historico.getDia(), historico.getValor()));
				}
				
				return alumnoDTO;
			}else{
				throw new ResourceNotFoundException("<< Estudiante no encontrado >>");
			}
		}catch(Exception e){
			throw e;
		}
	}

}
