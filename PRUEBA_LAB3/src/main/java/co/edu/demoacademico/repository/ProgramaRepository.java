// ProgramaRepository.java
package co.edu.demoacademico.repository;

import co.edu.demoacademico.model.Programa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramaRepository extends JpaRepository<Programa, Long> {
    boolean existsByCodigo(String codigo);
}

// AsignaturaRepository.java
package co.edu.demoacademico.repository;

import co.edu.demoacademico.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

// GrupoRepository.java
package co.edu.demoacademico.repository;

import co.edu.demoacademico.model.Grupo;
import org.springframework.data.jpa.repository.JpaRepository;

// MatriculaRepository.java
package co.edu.demoacademico.repository;

import co.edu.demoacademico.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

