/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.novatec.service;

import co.com.novatec.dto.http.AlumnoResponse;
import co.com.novatec.dto.http.ProfesorResponse;
import co.com.novatec.exceptions.ServiceException;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Yeison Camilo Rincon
 */
public interface CrudService {

    /**
     * Procesa y almacena al objeto profesor enviado
     *
     * @param request
     * @return
     * @throws ServiceException
     */
    ResponseEntity<?> createProfesor(ProfesorResponse request) throws ServiceException;

    /**
     * Procesa y almacena al objeto alumno enviado
     *
     * @param request
     * @return
     * @throws ServiceException
     */
    ResponseEntity<?> createAlumno(AlumnoResponse request) throws ServiceException;

    /**
     * Consulta la lista de estudiantes disponibles en bd
     *
     * @return
     * @throws ServiceException
     */
    ResponseEntity<?> getAlumnos() throws ServiceException;

    /**
     * Consulta la lista de profesores disponibles en bd
     *
     * @return
     * @throws ServiceException
     */
    ResponseEntity<?> getProfesores() throws ServiceException;

    /**
     * Consulta la lista de especialidades disponibles en bd
     *
     * @return
     * @throws ServiceException
     */
    ResponseEntity<?> getEspecialidades() throws ServiceException;

    /**
     * Elimina un profesor por identificador
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    ResponseEntity<?> deleteProfesor(Integer id) throws ServiceException;

    /**
     * Elimina un alumno por identificador
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    ResponseEntity<?> deleteAlumno(Integer id) throws ServiceException;

    /**
     * Edita un objeto profesor
     *
     * @param profesorResponse
     * @return
     * @throws ServiceException
     */
    ResponseEntity<?> editProfesor(ProfesorResponse profesorResponse) throws ServiceException;

    /**
     * Edita un objeto alumno
     *
     * @param alumnoResponse
     * @return
     * @throws ServiceException
     */
    ResponseEntity<?> editAlumno(AlumnoResponse alumnoResponse) throws ServiceException;

}
