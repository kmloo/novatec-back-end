/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.novatec.dao;

import co.com.novatec.dto.EspecialidadDTO;
import co.com.novatec.exceptions.DaoException;
import java.util.List;

/**
 *
 * @author Yeison Camilo Rincon
 */
public interface EspecialidadDao {

    /**
     * Consulta todas las especialidades de la bd
     *
     * @return
     * @throws DaoException
     */
    List<EspecialidadDTO> get() throws DaoException;

}
