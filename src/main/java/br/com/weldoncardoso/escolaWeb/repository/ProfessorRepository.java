package br.com.weldoncardoso.escolaWeb.repository;

import br.com.weldoncardoso.escolaWeb.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
