/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.novatec.dao.impl;

import co.com.novatec.dao.EspecialidadDao;
import co.com.novatec.dto.EspecialidadDTO;
import co.com.novatec.exceptions.DaoException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yeison Camilo Rincon
 */
@Service
public class EspecialidadDaoImpl implements EspecialidadDao {

    @Autowired
    @Qualifier("namedParameterJdbcTemplateMsBd")
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SQL_GET = "SELECT id, nombre, descripcion FROM especialidad ORDER BY nombre ASC";

    @Override
    public List<EspecialidadDTO> get() throws DaoException {
        List<EspecialidadDTO> respuesta = null;
        try {
            respuesta = this.jdbcTemplate.query(SQL_GET, rs -> {
                List<EspecialidadDTO> res = null;
                if (rs.isBeforeFirst()) {
                    res = new ArrayList<>();
                    while (rs.next()) {
                        res.add(EspecialidadDTO.builder()
                                .id(rs.getInt(EspecialidadDTO.ID))
                                .nombre(rs.getString(EspecialidadDTO.NOMBRE))
                                .descripcion(rs.getString(EspecialidadDTO.DESCRIPCION))
                                .build());
                    }
                }
                return res;
            });
        } catch (Throwable ex) {
            throw new DaoException(ex);
        }
        return respuesta;
    }

}
