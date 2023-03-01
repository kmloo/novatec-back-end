package co.com.novatec.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfesorDTO {

    private Integer id;

    private String nombre;

    private String apellido;

    private Integer idEspecialidad;
    
    public static final String ID = "id";
    public static final String NOMBRE = "nombre";
    public static final String APELLIDO = "apellido";
    public static final String ID_ESPECIALIDAD = "id_especialidad";

}
