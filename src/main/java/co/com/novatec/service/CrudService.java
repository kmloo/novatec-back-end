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
     * Consulta la lista de profesores disponibles en bd
     *
     * @return
     * @throws ServiceException
     */
    ResponseEntity<?> getEspecialidades() throws ServiceException;

}
