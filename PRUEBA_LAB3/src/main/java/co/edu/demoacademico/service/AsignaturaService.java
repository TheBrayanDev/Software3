// AsignaturaService.java
package co.edu.demoacademico.service;

import co.edu.demoacademico.model.Asignatura;
import java.util.List;

public interface AsignaturaService {
    Asignatura crear(Asignatura a);
    Asignatura obtenerPorId(Long id);
    List<Asignatura> listar();
    void eliminar(Long id);
}

// AsignaturaServiceImpl.java
package co.edu.demoacademico.service;

import co.edu.demoacademico.exception.NotFoundException;
import co.edu.demoacademico.model.Asignatura;
import co.edu.demoacademico.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

