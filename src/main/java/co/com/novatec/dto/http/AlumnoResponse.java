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
public class AlumnoResponse {

    @JsonProperty("id")
    @SerializedName("id")
    @ApiModelProperty(name = "id", value = "Id del alumno", required = false)
    private Integer id;

    @JsonProperty("nombre")
    @SerializedName("nombre")
    @ApiModelProperty(name = "nombre", value = "Nombre del alumno", required = true)
    private String nombre;

    @JsonProperty("apellido")
    @SerializedName("apellido")
    @ApiModelProperty(name = "apellido", value = "Apellido del alumno", required = true)
    private String apellido;

    @JsonProperty("curso")
    @SerializedName("curso")
    @ApiModelProperty(name = "curso", value = "Nombre del curso al que asiste el alumno", required = true)
    private String curso;

}
