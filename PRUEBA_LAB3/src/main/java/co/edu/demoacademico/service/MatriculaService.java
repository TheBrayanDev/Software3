// MatriculaService.java
package co.edu.demoacademico.service;

import co.edu.demoacademico.model.Matricula;

public interface MatriculaService {
    Matricula matricular(Long estudianteId, Long grupoId);
}

// MatriculaServiceImpl.java
package co.edu.demoacademico.service;

import co.edu.demoacademico.exception.BusinessException;
import co.edu.demoacademico.model.Estudiante;
import co.edu.demoacademico.model.Grupo;
import co.edu.demoacademico.model.Matricula;
import co.edu.demoacademico.repository.EstudianteRepository;
import co.edu.demoacademico.repository.GrupoRepository;
import co.edu.demoacademico.repository.MatriculaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

