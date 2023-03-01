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
@ApiModel("Model profesor response")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProfesorResponse {
    
    @JsonProperty("id")
    @SerializedName("id")
    @ApiModelProperty(name = "id", value = "Id del profesor", required = false)
    private Integer id;
    
    @JsonProperty("nombre")
    @SerializedName("nombre")
    @ApiModelProperty(name = "nombre", value = "Nombre del profesor", required = true)
    private String nombre;
    
    @JsonProperty("apellido")
    @SerializedName("apellido")
    @ApiModelProperty(name = "apellido", value = "Apellido del profesor", required = true)
    private String apellido;
    
    @JsonProperty("idEspecialidad")
    @SerializedName("idEspecialidad")
    @ApiModelProperty(name = "idEspecialidad", value = "Id de la especialidad del profesor", required = true)
    private Integer idEspecialidad;
    
    
}
