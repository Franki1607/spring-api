package com.springboot.project.gestionedu.core.services.studentnote;

import com.springboot.project.gestionedu.core.dao.entities.StudentNote;
import com.springboot.project.gestionedu.core.dao.repositories.StudentNoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentNoteImpl implements StudentNoteService {

    private final StudentNoteRepository studentNoteRepository;

    @Override
    public StudentNote save(StudentNote noteEtudiant) {
        return studentNoteRepository.save(noteEtudiant);
    }

    @Override
    public StudentNote update(Long id, StudentNote noteEtudiant) {
        return studentNoteRepository.findById(id).map(studentNote -> {
            studentNote.setNom(noteEtudiant.getNom());
            studentNote.setPrenom(noteEtudiant.getPrenom());
            studentNote.setAge(noteEtudiant.getAge());
            studentNote.setMatiere(noteEtudiant.getMatiere());
            studentNote.setNote(noteEtudiant.getNote());
            return studentNoteRepository.save(studentNote);
        }).orElseThrow(() -> new RuntimeException("Student note not found with id " + noteEtudiant.getId()));
    }

    @Override
    public String delete(StudentNote noteEtudiant) {
        studentNoteRepository.deleteById(noteEtudiant.getId());
        return "Student note deleted successfully";
    }

    @Override
    public StudentNote find(Long id) {
        return studentNoteRepository.findById(id).orElseThrow(() -> new RuntimeException("Student note not found with id " + id));
    }

    @Override
    public List<StudentNote> findAll() {
        return studentNoteRepository.findAll();
    }
}
