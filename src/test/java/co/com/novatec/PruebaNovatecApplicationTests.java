package co.com.novatec;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import co.com.novatec.dao.impl.EspecialidadDaoImpl;
import co.com.novatec.dao.impl.ProfesorDaoImpl;
import co.com.novatec.dto.EspecialidadDTO;
import co.com.novatec.dto.ProfesorDTO;
import co.com.novatec.exceptions.DaoException;
import co.com.novatec.exceptions.ServiceException;
import co.com.novatec.helper.UtilHelper;
import co.com.novatec.service.impl.CrudServiceImpl;

@ExtendWith(MockitoExtension.class)
class PruebaNovatecApplicationTests {

    @Mock
    private ProfesorDaoImpl profesorDao;

    @Mock
    private EspecialidadDaoImpl especialidadDao;

    @InjectMocks
    private CrudServiceImpl crudService;

    private ProfesorDTO profesorDTO;

    @BeforeEach
    void setup() {
        profesorDTO = ProfesorDTO.builder()
                .id(1)
                .apellido("Perez")
                .nombre("Jesus")
                .idEspecialidad(1)
                .build();
    }

    @DisplayName("Se almacena un Profesor")
    @Test
    void testCrearProfesor() throws DaoException, ServiceException {

        given(profesorDao.create(profesorDTO)).willReturn(profesorDTO);

        ResponseEntity<?> response = crudService.createProfesor(UtilHelper.dtoToResponse(profesorDTO));

        Assertions.assertThat(response.getStatusCode().equals(HttpStatus.OK));
    }

    @DisplayName("Se edita un Profesor")
    @Test
    void testEditarProfesor() throws DaoException, ServiceException {

        given(profesorDao.edit(profesorDTO)).willReturn(Boolean.TRUE);

        ResponseEntity<?> response = crudService.editProfesor(UtilHelper.dtoToResponse(profesorDTO));

        Assertions.assertThat(response.getStatusCode().equals(HttpStatus.OK));

    }

    @DisplayName("Se elimina un Profesor")
    @Test
    void testEliminarProfesor() throws DaoException, ServiceException {

        given(profesorDao.delete(profesorDTO.getId())).willReturn(Boolean.TRUE);

        ResponseEntity<?> response = crudService.deleteProfesor(profesorDTO.getId());

        Assertions.assertThat(response.getStatusCode().equals(HttpStatus.OK));

    }

    @DisplayName("Consultar profesores")
    @Test
    void testConsultarProfesores() throws DaoException, ServiceException {
    	List<ProfesorDTO> lista = new ArrayList<>();

        given(profesorDao.get()).willReturn(lista);

        ResponseEntity<?> response = crudService.getProfesores();

        Assertions.assertThat(response.getStatusCode().equals(HttpStatus.OK));

    }

    @DisplayName("Consultar especialidades")
    @Test
    void testConsultarEspecialidades() throws DaoException, ServiceException {
    	List<EspecialidadDTO> lista = new ArrayList<>();

        given(especialidadDao.get()).willReturn(lista);

        ResponseEntity<?> response = crudService.getEspecialidades();

        Assertions.assertThat(response.getStatusCode().equals(HttpStatus.OK));

    }

}
