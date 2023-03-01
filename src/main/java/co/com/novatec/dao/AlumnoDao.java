/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.novatec.dao;

import co.com.novatec.dto.AlumnoDTO;
import co.com.novatec.exceptions.DaoException;
import java.util.List;

/**
 *
 * @author Yeison Camilo Rincon
 */
public interface AlumnoDao {

    /**
     * Metodo que almacena un objeto profesor
     *
     * @param alumnoDTO
     * @return
     * @throws DaoException
     */
    AlumnoDTO create(AlumnoDTO alumnoDTO) throws DaoException;

    /**
     * Consulta todos los alumnos almacenados
     *
     * @return
     * @throws DaoException
     */
    List<AlumnoDTO> get() throws DaoException;

}
