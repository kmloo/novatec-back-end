/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.novatec.helper;

import co.com.novatec.dto.AlumnoDTO;
import co.com.novatec.dto.EspecialidadDTO;
import co.com.novatec.dto.ProfesorDTO;
import co.com.novatec.dto.http.AlumnoResponse;
import co.com.novatec.dto.http.EspecialidadResponse;
import co.com.novatec.dto.http.ProfesorResponse;
import co.com.novatec.dto.http.ResponseObject;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Yeison Camilo Rincon
 */
public class UtilHelper {

    /**
     * Procesa un objeto response a dto
     *
     * @param object
     * @return
     */
    public static ProfesorDTO restponseToDto(ProfesorResponse object) {
        return object != null
                ? ProfesorDTO.builder()
                        .apellido(object.getApellido())
                        .id(object.getId())
                        .idEspecialidad(object.getIdEspecialidad())
                        .nombre(object.getNombre())
                        .build()
                : null;
    }

    /**
     * Procesa un objeto dto a response
     *
     * @param object
     * @return
     */
    public static ProfesorResponse dtoToResponse(ProfesorDTO object) {
        return object != null
                ? ProfesorResponse.builder()
                        .apellido(object.getApellido())
                        .id(object.getId())
                        .idEspecialidad(object.getIdEspecialidad())
                        .nombre(object.getNombre())
                        .build()
                : null;
    }

    /**
     * Genera una lista de repuesta de profesro response
     *
     * @param list
     * @return
     */
    public static List<ProfesorResponse> dtoToResponse(List<ProfesorDTO> list) {
        List<ProfesorResponse> response = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            list.forEach((ProfesorDTO dto) -> {
                response.add(dtoToResponse(dto));
            });
        }
        return response;
    }

    /**
     * Metodo que valida los datos ingresados
     *
     * @param object
     * @param headers
     * @return
     */
    public static ResponseEntity<?> validateRequestProfesor(ProfesorResponse object, HttpHeaders headers) {
        if (object == null) {
            return new ResponseEntity<>(ResponseObject.builder().mensaje("Debe enviar un profesor").build(), headers, HttpStatus.BAD_REQUEST);
        }

        if (object.getApellido() == null || object.getApellido().isEmpty()) {
            return new ResponseEntity<>(ResponseObject.builder().mensaje("Debe enviar el apellido").build(), headers, HttpStatus.BAD_REQUEST);
        }

        if (object.getNombre() == null || object.getNombre().isEmpty()) {
            return new ResponseEntity<>(ResponseObject.builder().mensaje("Debe enviar el nombre").build(), headers, HttpStatus.BAD_REQUEST);
        }

        if (object.getIdEspecialidad() == null || object.getIdEspecialidad() == 0) {
            return new ResponseEntity<>(ResponseObject.builder().mensaje("Debe enviar la especialidad").build(), headers, HttpStatus.BAD_REQUEST);
        }

        return null;
    }

    /**
     * Procesa un objeto response a dto
     *
     * @param object
     * @return
     */
    public static AlumnoDTO restponseToDto(AlumnoResponse object) {
        return object != null
                ? AlumnoDTO.builder()
                        .apellido(object.getApellido())
                        .id(object.getId())
                        .curso(object.getCurso())
                        .nombre(object.getNombre())
                        .build()
                : null;
    }

    /**
     * Procesa un objeto dto a response
     *
     * @param object
     * @return
     */
    public static AlumnoResponse dtoToResponse(AlumnoDTO object) {
        return object != null
                ? AlumnoResponse.builder()
                        .apellido(object.getApellido())
                        .id(object.getId())
                        .curso(object.getCurso())
                        .nombre(object.getNombre())
                        .build()
                : null;
    }

    /**
     * Genera una lista de repuesta de profesro response
     *
     * @param list
     * @return
     */
    public static List<AlumnoResponse> dtoToResponseAlum(List<AlumnoDTO> list) {
        List<AlumnoResponse> response = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            list.forEach((AlumnoDTO dto) -> {
                response.add(dtoToResponse(dto));
            });
        }
        return response;
    }

    /**
     * Metodo que valida los datos ingresados
     *
     * @param object
     * @param headers
     * @return
     */
    public static ResponseEntity<?> validateRequestAlumno(AlumnoResponse object, HttpHeaders headers) {
        if (object == null) {
            return new ResponseEntity<>(ResponseObject.builder().mensaje("Debe enviar un profesor").build(), headers, HttpStatus.BAD_REQUEST);
        }

        if (object.getApellido() == null || object.getApellido().isEmpty()) {
            return new ResponseEntity<>(ResponseObject.builder().mensaje("Debe enviar el apellido").build(), headers, HttpStatus.BAD_REQUEST);
        }

        if (object.getNombre() == null || object.getNombre().isEmpty()) {
            return new ResponseEntity<>(ResponseObject.builder().mensaje("Debe enviar el nombre").build(), headers, HttpStatus.BAD_REQUEST);
        }

        if (object.getCurso() == null || object.getCurso().isEmpty()) {
            return new ResponseEntity<>(ResponseObject.builder().mensaje("Debe enviar el curso").build(), headers, HttpStatus.BAD_REQUEST);
        }

        return null;
    }

    /**
     * Procesa un objeto dto a response
     *
     * @param object
     * @return
     */
    public static EspecialidadResponse dtoToResponse(EspecialidadDTO object) {
        return object != null
                ? EspecialidadResponse.builder()
                        .id(object.getId())
                        .nombre(object.getNombre())
                        .descripcion(object.getDescripcion())
                        .build()
                : null;
    }

    /**
     * Genera una lista de repuesta de profesro response
     *
     * @param list
     * @return
     */
    public static List<EspecialidadResponse> dtoToResponseEspecialidad(List<EspecialidadDTO> list) {
        List<EspecialidadResponse> response = new ArrayList<>();
        if (list != null && !list.isEmpty()) {
            list.forEach((EspecialidadDTO dto) -> {
                response.add(dtoToResponse(dto));
            });
        }
        return response;
    }
}
