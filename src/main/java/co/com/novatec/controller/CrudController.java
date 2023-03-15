/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.novatec.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import co.com.novatec.constantes.EnumCodificacion;
import co.com.novatec.dto.http.EspecialidadResponse;
import co.com.novatec.dto.http.ProfesorResponse;
import co.com.novatec.exceptions.ServiceException;
import co.com.novatec.service.CrudService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Yeison Camilo Rincon
 */
@CrossOrigin(value = "*")
@RestController
@RequestMapping
@Api(value = "Group microservice", description = "This API has a get crud for app")
public class CrudController {

    private static final Logger logger = Logger.getLogger(CrudController.class.getName());

    private final Gson gson = new Gson();

    private final HttpHeaders httpHeaders;

    public CrudController() {
        this.httpHeaders = new HttpHeaders();
        this.httpHeaders.add(EnumCodificacion.CONTENT_TYPE_UTF_8.getValor(), EnumCodificacion.CONTENT_TYPE_UTF_8_DESCRIBE.getValor());
    }

    @Autowired
    private CrudService crudService;

    @PutMapping("/create/teacher")
    @ApiOperation(value = "Create teacher", notes = "Return teacher create")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful operation", response = ProfesorResponse.class),
        @ApiResponse(code = 400, message = "Invalid or null data"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 404, message = "create not found"),
        @ApiResponse(code = 500, message = "Operation exception")})
    public ResponseEntity<?> crearProfesor(@ApiParam(value = "Group to create", required = true)
            @RequestBody ProfesorResponse profesorResponse) {
        String nombreMetodo = new Object() {
        }.getClass().getEnclosingMethod().getName();
        logger.log(Level.INFO, "Ejecucion metodo: {0}", nombreMetodo);
        ResponseEntity<?> response = null;
        try {
            response = this.crudService.createProfesor(profesorResponse);
        } catch (ServiceException ex) {
            logger.log(Level.SEVERE, "Error ejecutando metodo: " + nombreMetodo, ex);
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.log(Level.INFO, "Respuesta metodo: {0} = {1}", new Object[]{nombreMetodo, this.gson.toJson(response)});
        return response;
    }

    @GetMapping("/teacher")
    @ApiOperation(value = "Get list teacher", notes = "Return list teacher")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful operation", response = ProfesorResponse.class),
        @ApiResponse(code = 400, message = "Invalid or null data"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 404, message = "create not found"),
        @ApiResponse(code = 500, message = "Operation exception")})
    public ResponseEntity<?> consultarProfesores() {
        String nombreMetodo = new Object() {
        }.getClass().getEnclosingMethod().getName();
        logger.log(Level.INFO, "Ejecucion metodo: {0}", nombreMetodo);
        ResponseEntity<?> response = null;
        try {
            response = this.crudService.getProfesores();
        } catch (ServiceException ex) {
            logger.log(Level.SEVERE, "Error ejecutando metodo: " + nombreMetodo, ex);
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.log(Level.INFO, "Respuesta metodo: {0} = {1}", new Object[]{nombreMetodo, this.gson.toJson(response)});
        return response;
    }

    @GetMapping("/resources/specialty")
    @ApiOperation(value = "Get list specialty", notes = "Return list specialty")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful operation", response = EspecialidadResponse.class),
        @ApiResponse(code = 400, message = "Invalid or null data"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 404, message = "create not found"),
        @ApiResponse(code = 500, message = "Operation exception")})
    public ResponseEntity<?> consultarEspecialidades() {
        String nombreMetodo = new Object() {
        }.getClass().getEnclosingMethod().getName();
        logger.log(Level.INFO, "Ejecucion metodo: {0}", nombreMetodo);
        ResponseEntity<?> response = null;
        try {
            response = this.crudService.getEspecialidades();
        } catch (ServiceException ex) {
            logger.log(Level.SEVERE, "Error ejecutando metodo: " + nombreMetodo, ex);
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.log(Level.INFO, "Respuesta metodo: {0} = {1}", new Object[]{nombreMetodo, this.gson.toJson(response)});
        return response;
    }

    @DeleteMapping("/teacher/{identificador}")
    @ApiOperation(value = "Delete teacher", notes = "Return delete")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful operation", response = Boolean.class),
        @ApiResponse(code = 400, message = "Invalid or null data"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 404, message = "create not found"),
        @ApiResponse(code = 500, message = "Operation exception")})
    public ResponseEntity<?> borrarProfesor(@ApiParam(name = "identificador", value = "User id", example = "1", required = true)
            @PathVariable("identificador") Integer id) {
        String nombreMetodo = new Object() {
        }.getClass().getEnclosingMethod().getName();
        logger.log(Level.INFO, "Ejecucion metodo: {0}", nombreMetodo);
        ResponseEntity<?> response = null;
        try {
            response = this.crudService.deleteProfesor(id);
        } catch (ServiceException ex) {
            logger.log(Level.SEVERE, "Error ejecutando metodo: " + nombreMetodo, ex);
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        logger.log(Level.INFO, "Respuesta metodo: {0} = {1}", new Object[]{nombreMetodo, this.gson.toJson(response)});
        return response;
    }

    @PatchMapping("/teacher")
    @ApiOperation(value = "Edit teacher", notes = "Return  edit")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successful operation", response = Boolean.class),
        @ApiResponse(code = 400, message = "Invalid or null data"),
        @ApiResponse(code = 401, message = "Unauthorized"),
        @ApiResponse(code = 404, message = "create not found"),
        @ApiResponse(code = 500, message = "Operation exception")})
    public ResponseEntity<?> editProfesor(@ApiParam(value = "Group to create", required = true)
            @RequestBody ProfesorResponse profesorResponse) {
        String nombreMetodo = new Object() {
        }.getClass().getEnclosingMethod().getName();
        logger.log(Level.INFO, "Ejecucion metodo: {0}", nombreMetodo);
        ResponseEntity<?> response = null;
        try {
            response = this.crudService.editProfesor(profesorResponse);
        } catch (ServiceException ex) {
            logger.log(Level.SEVERE, "Error ejecutando metodo: " + nombreMetodo, ex);
            response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } 
        logger.log(Level.INFO, "Respuesta metodo: {0} = {1}", new Object[]{nombreMetodo, this.gson.toJson(response)});
        return response;
    }

}
