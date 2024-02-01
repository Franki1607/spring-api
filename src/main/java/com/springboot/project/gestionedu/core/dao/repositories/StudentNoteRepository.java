package com.springboot.project.gestionedu.core.dao.repositories;

import com.springboot.project.gestionedu.core.dao.entities.StudentNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentNoteRepository extends JpaRepository<StudentNote, Long> {
}
