/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.novatec.dao.impl;

import co.com.novatec.dao.ProfesorDao;
import co.com.novatec.dto.AlumnoDTO;
import co.com.novatec.dto.ProfesorDTO;
import co.com.novatec.exceptions.DaoException;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Yeison Camilo Rincon
 */
@Repository
public class ProfesorDaoImpl implements ProfesorDao {

    @Autowired
    @Qualifier("namedParameterJdbcTemplateMsBd")
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SQL_INSERT = "INSERT INTO profesor(nombre, apellido, id_especialidad) VALUES(:nombre, :apellido, :id_especialidad)";

    private static final String SQL_SELEC = "SELECT id, nombre, apellido, id_especialidad FROM profesor ";

    private static final String SQL_DELETE = "DELETE FROM profesor WHERE id = :id";

    private static final String SQL_EDIT = "UPDATE profesor SET nombre = :nombre, apellido = :apellido, id_especialidad = :id_especialidad where id = :id";

    @Override
    public ProfesorDTO create(ProfesorDTO profesorDTO) throws DaoException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue(ProfesorDTO.NOMBRE, profesorDTO.getNombre());
            params.addValue(ProfesorDTO.APELLIDO, profesorDTO.getApellido());
            params.addValue(ProfesorDTO.ID_ESPECIALIDAD, profesorDTO.getIdEspecialidad());

            this.jdbcTemplate.update(SQL_INSERT, params, keyHolder, new String[]{ProfesorDTO.ID});

            profesorDTO.setId(keyHolder != null ? keyHolder.getKey() != null ? keyHolder.getKey().intValue() : null : null);

        } catch (Throwable ex) {
            throw new DaoException(ex);
        }
        return profesorDTO;
    }

    @Override
    public List<ProfesorDTO> get() throws DaoException {
        List<ProfesorDTO> respuesta = null;
        try {
            respuesta = this.jdbcTemplate.query(SQL_SELEC, rs -> {
                List<ProfesorDTO> res = null;
                if (rs.isBeforeFirst()) {
                    res = new ArrayList<>();
                    while (rs.next()) {
                        res.add(ProfesorDTO.builder()
                                .apellido(rs.getString(ProfesorDTO.APELLIDO))
                                .idEspecialidad(rs.getInt(ProfesorDTO.ID_ESPECIALIDAD))
                                .id(rs.getInt(ProfesorDTO.ID))
                                .nombre(rs.getString(ProfesorDTO.NOMBRE))
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

    @Override
    public Boolean delete(Integer id) throws DaoException {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue(ProfesorDTO.ID, id);

            int i = this.jdbcTemplate.update(SQL_DELETE, params);

            return i > 0 ? Boolean.TRUE : Boolean.FALSE;

        } catch (Throwable ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Boolean edit(ProfesorDTO profesorDTO) throws DaoException {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue(ProfesorDTO.NOMBRE, profesorDTO.getNombre());
            params.addValue(ProfesorDTO.APELLIDO, profesorDTO.getApellido());
            params.addValue(ProfesorDTO.ID_ESPECIALIDAD, profesorDTO.getIdEspecialidad());
            params.addValue(ProfesorDTO.ID, profesorDTO.getId());

            int i = this.jdbcTemplate.update(SQL_EDIT, params);

            return i > 0 ? Boolean.TRUE : Boolean.FALSE;
        } catch (Throwable ex) {
            throw new DaoException(ex);
        }
    }

}
