/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.com.novatec.dto.http;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("Model alumno response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EspecialidadResponse {

    @JsonProperty("id")
    @SerializedName("id")
    @ApiModelProperty(name = "id", value = "Id de la especialidad", required = false)
    private Integer id;

    @JsonProperty("nombre")
    @SerializedName("nombre")
    @ApiModelProperty(name = "nombre", value = "Nombre de la especialidad", required = true)
    private String nombre;

    @JsonProperty("descripcion")
    @SerializedName("descripcion")
    @ApiModelProperty(name = "descripcion", value = "Descripción de la especialidad", required = true)
    private String descripcion;

}
