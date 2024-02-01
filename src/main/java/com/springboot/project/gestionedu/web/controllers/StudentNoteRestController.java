package com.springboot.project.gestionedu.web.controllers;

import com.springboot.project.gestionedu.core.dao.entities.StudentNote;
import com.springboot.project.gestionedu.core.services.studentnote.StudentNoteService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/studentnotes")
@AllArgsConstructor
public class StudentNoteRestController {

    private final StudentNoteService studentNoteService;

    @PostMapping("/create")
    @PreAuthorize("hasRole('USER_ADMIN')")
    public StudentNote sauvegarderNoteEtudiant(@RequestBody StudentNote noteEtudiant) {
        return  studentNoteService.save(noteEtudiant);
    }

    @GetMapping("/all")
    public List<StudentNote> getAllNoteEtudiants() {
        System.out.println("hello");
        return studentNoteService.findAll();
    }

    @GetMapping("/get/{id}")
    public StudentNote getNotEtudiant (@PathVariable Long id) {
        return studentNoteService.find(id);
    }

    @PutMapping("/update/{id}")
    public StudentNote modifierNoteEtudiant(@PathVariable Long id, @RequestBody StudentNote noteEtudiant) {
        return studentNoteService.update(id, noteEtudiant);
    }

    @DeleteMapping("/delete/{id}")
    public String supprimerNoteEtudiant(@PathVariable Long id) {
        return studentNoteService.delete(studentNoteService.find(id));
    }

}
