package com.springboot.project.gestionedu.core.services.studentnote;

import com.springboot.project.gestionedu.core.dao.entities.StudentNote;

import java.util.List;

public interface StudentNoteService {

    StudentNote save (StudentNote noteEtudiant);

    StudentNote update (Long id,StudentNote noteEtudiant);

    String delete (StudentNote noteEtudiant);

    StudentNote find (Long id);

    List<StudentNote> findAll ();
}
