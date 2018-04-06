package com.ceaft.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.ceaf.exception.ResourceAlreadyExistsException;
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
	public AlumnoDTO registrar(String id) throws ResourceNotFoundException, ResourceAlreadyExistsException {
		try{
			//buscar al alumno
			AlumnoDTO alumnoDTO = buscarAlumno(id);
			//validar si el alumno ya está registrado
			Asistencia asistencia = iAsistenciaDAO.obtenerAsistencia(alumnoDTO.getId());
			if(asistencia == null){
				asistencia = new Asistencia();
				asistencia.setFecha(new Date());
				asistencia.setMatric(id);
				asistencia.setAlumnoMatriculado(iAlumnoMatriculadoDAO.buscarAlumno(id));
				iAsistenciaDAO.registraAsistencia(asistencia);
				
				alumnoDTO.getAsistencia().addAll(obtenerHistorialAsistencia(id));
				alumnoDTO.getHistoricoPieData().addAll(iAsistenciaDAO.obtenerHistoricoPie(id));
				
				return alumnoDTO;
			}else{
				throw new ResourceAlreadyExistsException("El alumno ya registró sus asistencia.");
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	@Override
	public AlumnoDTO obtenerInformacion(String id) throws ResourceNotFoundException, ResourceAlreadyExistsException {
		try{
			AlumnoDTO alumnoDTO = buscarAlumno(id);
			alumnoDTO.getAsistencia().addAll(obtenerHistorialAsistencia(id));
			alumnoDTO.getHistoricoPieData().addAll(iAsistenciaDAO.obtenerHistoricoPie(id));
			return alumnoDTO;
		}catch(Exception e){
			throw e;
		}
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws ResourceNotFoundException
	 * @throws ResourceAlreadyExistsException
	 */
	private AlumnoDTO buscarAlumno(String id) throws ResourceNotFoundException, ResourceAlreadyExistsException {
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
				
				List<Deuda> dedudas = iAdeudoDAO.obtenerDeudas(id);
				for(Deuda deuda : dedudas){
					alumnoDTO.getDeuda().add(new DeudaDTO(deuda.getFolio(), deuda.getAdeudoTot().doubleValue(), 
						deuda.getMontoRecup(), deuda.getMontoExtra()));
				}
				
				return alumnoDTO;
			}else{
				throw new ResourceNotFoundException("El Alumno no está matriculado.");
			}
		}catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	private List<AsistenciaDTO> obtenerHistorialAsistencia(String id){
		List<AsistenciaDTO> asistenciaDTOs = new ArrayList<>();
		List<Asistencia> asistencias = iAsistenciaDAO.obtenerAsistencias(id);
		//TODO remover cuando se tenga la funcionalidad
		String estados[] = {"green-circle.png", "yellow-circle.png", "red-circle.png"};
		//
		for(Asistencia attdnc : asistencias){
			asistenciaDTOs.add(new AsistenciaDTO(attdnc.getFecha(), estados[new Random().nextInt(3)]));
		}
		return asistenciaDTOs;
	}

}
