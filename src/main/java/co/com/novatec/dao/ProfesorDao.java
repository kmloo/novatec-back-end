/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.novatec.dao;

import co.com.novatec.dto.ProfesorDTO;
import co.com.novatec.exceptions.DaoException;
import java.util.List;

/**
 *
 * @author Yeison Camilo Rincon
 */
public interface ProfesorDao {

    /**
     * Metodo que almacena un objeto profesor
     *
     * @param profesorDTO
     * @return
     * @throws DaoException
     */
    ProfesorDTO create(ProfesorDTO profesorDTO) throws DaoException;

    /**
     * Consulta la lista de profesores en la bd
     *
     * @return
     * @throws DaoException
     */
    List<ProfesorDTO> get() throws DaoException;

}
