/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.novatec.dao.impl;

import co.com.novatec.exceptions.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import co.com.novatec.dao.AlumnoDao;
import co.com.novatec.dto.AlumnoDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yeison Camilo Rincon
 */
@Repository
public class AlumnoDaoImpl implements AlumnoDao {

    @Autowired
    @Qualifier("namedParameterJdbcTemplateMsBd")
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final String SQL_INSERT = "INSERT INTO alumno(nombre, apellido, curso) VALUES(:nombre, :apellido, :curso)";

    private static final String SQL_GET = "SELECT ID, nombre, apellido, curso FROM  alumno";

    private static final String SQL_DELETE = "DELETE FROM alumno WHERE id = :id";

    private static final String SQL_EDIT = "UPDATE alumno SET nombre = :nombre, apellido = :apellido, curso = :curso where id = :id";

    @Override
    public AlumnoDTO create(AlumnoDTO alumnoDTO) throws DaoException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue(AlumnoDTO.NOMBRE, alumnoDTO.getNombre());
            params.addValue(AlumnoDTO.APELLIDO, alumnoDTO.getApellido());
            params.addValue(AlumnoDTO.CURSO, alumnoDTO.getCurso());

            this.jdbcTemplate.update(SQL_INSERT, params, keyHolder, new String[]{AlumnoDTO.ID});

            alumnoDTO.setId(keyHolder != null ? keyHolder.getKey() != null ? keyHolder.getKey().intValue() : null : null);

        } catch (Throwable ex) {
            throw new DaoException(ex);
        }
        return alumnoDTO;
    }

    @Override
    public List<AlumnoDTO> get() throws DaoException {
        List<AlumnoDTO> respuesta = null;
        try {
            respuesta = this.jdbcTemplate.query(SQL_GET, rs -> {
                List<AlumnoDTO> res = null;
                if (rs.isBeforeFirst()) {
                    res = new ArrayList<>();
                    while (rs.next()) {
                        res.add(AlumnoDTO.builder()
                                .apellido(rs.getString(AlumnoDTO.APELLIDO))
                                .curso(rs.getString(AlumnoDTO.CURSO))
                                .id(rs.getInt(AlumnoDTO.ID))
                                .nombre(rs.getString(AlumnoDTO.NOMBRE))
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
            params.addValue(AlumnoDTO.ID, id);

            int i = this.jdbcTemplate.update(SQL_DELETE, params);

            return i > 0 ? Boolean.TRUE : Boolean.FALSE;

        } catch (Throwable ex) {
            throw new DaoException(ex);
        }
    }

    @Override
    public Boolean edit(AlumnoDTO alumnoDTO) throws DaoException {
        try {
            MapSqlParameterSource params = new MapSqlParameterSource();
            params.addValue(AlumnoDTO.NOMBRE, alumnoDTO.getNombre());
            params.addValue(AlumnoDTO.APELLIDO, alumnoDTO.getApellido());
            params.addValue(AlumnoDTO.CURSO, alumnoDTO.getCurso());
            params.addValue(AlumnoDTO.ID, alumnoDTO.getId());

            int i = this.jdbcTemplate.update(SQL_EDIT, params);

            return i > 0 ? Boolean.TRUE : Boolean.FALSE;

        } catch (Throwable ex) {
            throw new DaoException(ex);
        }
    }

}
