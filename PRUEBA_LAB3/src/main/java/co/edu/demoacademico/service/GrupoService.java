// GrupoService.java
package co.edu.demoacademico.service;

import co.edu.demoacademico.model.Grupo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GrupoService {
    Grupo crear(Grupo g);
    Grupo obtenerPorId(Long id);
    Page<Grupo> listar(Pageable pageable);
    void eliminar(Long id);
}

// GrupoServiceImpl.java
package co.edu.demoacademico.service;

import co.edu.demoacademico.exception.NotFoundException;
import co.edu.demoacademico.model.Grupo;
import co.edu.demoacademico.repository.GrupoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

