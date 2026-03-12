// ProgramaService.java
package co.edu.demoacademico.service;

import co.edu.demoacademico.model.Programa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProgramaService {
    Programa crear(Programa p);
    Programa obtenerPorId(Long id);
    Page<Programa> listar(Pageable pageable);
    Programa actualizar(Long id, Programa p);
    void eliminar(Long id);
}

// ProgramaServiceImpl.java
package co.edu.demoacademico.service;

import co.edu.demoacademico.exception.BusinessException;
import co.edu.demoacademico.exception.NotFoundException;
import co.edu.demoacademico.model.Programa;
import co.edu.demoacademico.repository.ProgramaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

