/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.novatec.service.impl;

import co.com.novatec.constantes.EnumCodificacion;
import co.com.novatec.dao.EspecialidadDao;
import co.com.novatec.dao.ProfesorDao;
import co.com.novatec.dto.http.EspecialidadResponse;
import co.com.novatec.dto.http.ProfesorResponse;
import co.com.novatec.exceptions.DaoException;
import co.com.novatec.exceptions.ServiceException;
import co.com.novatec.helper.UtilHelper;
import co.com.novatec.service.CrudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Yeison Camilo Rincon
 */
@Service
public class CrudServiceImpl implements CrudService {

    @Autowired
    private ProfesorDao profeDao;

    @Autowired
    private EspecialidadDao especialidadDao;

    private final HttpHeaders httpHeaders;

    public CrudServiceImpl() {
        this.httpHeaders = new HttpHeaders();
        this.httpHeaders.add(EnumCodificacion.CONTENT_TYPE_UTF_8.getValor(), EnumCodificacion.CONTENT_TYPE_UTF_8_DESCRIBE.getValor());
    }

    @Override
    public ResponseEntity<?> createProfesor(ProfesorResponse request) throws ServiceException {
        try {
            ResponseEntity<?> response = UtilHelper.validateRequestProfesor(request, httpHeaders);
            if (response == null) {
                request = UtilHelper.dtoToResponse(this.profeDao.create(UtilHelper.restponseToDto(request)));
                response = new ResponseEntity<>(request, httpHeaders, HttpStatus.OK);
            }
            return response;
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public ResponseEntity<?> getProfesores() throws ServiceException {
        try {
            List<ProfesorResponse> list = UtilHelper.dtoToResponse(this.profeDao.get());
            return new ResponseEntity<>(list, httpHeaders, HttpStatus.OK);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public ResponseEntity<?> getEspecialidades() throws ServiceException {
        try {
            List<EspecialidadResponse> list = UtilHelper.dtoToResponseEspecialidad(this.especialidadDao.get());
            return new ResponseEntity<>(list, httpHeaders, HttpStatus.OK);
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public ResponseEntity<?> deleteProfesor(Integer id) throws ServiceException {
        try {
            if (id != null && id != 0) {
                Boolean delete = this.profeDao.delete(id);
                return new ResponseEntity<>(delete, httpHeaders, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Debe enviar un identificador valido", httpHeaders, HttpStatus.BAD_REQUEST);
            }
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

    @Override
    public ResponseEntity<?> editProfesor(ProfesorResponse profesorResponse) throws ServiceException {
        try {
            ResponseEntity<?> response = UtilHelper.validateRequestProfesor(profesorResponse, httpHeaders);
            if (response == null) {
                Boolean res = this.profeDao.edit(UtilHelper.restponseToDto(profesorResponse));
                response = new ResponseEntity<>(res, httpHeaders, HttpStatus.OK);
            }
            return response;
        } catch (DaoException ex) {
            throw new ServiceException(ex);
        }
    }

}
