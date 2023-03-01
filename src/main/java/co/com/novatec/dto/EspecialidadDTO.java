/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.novatec.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Yeison Camilo Rincon
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EspecialidadDTO {

    private Integer id;

    private String nombre;

    private String descripcion;

    public static final String ID = "id";

    public static final String NOMBRE = "nombre";

    public static final String DESCRIPCION = "descripcion";

}
