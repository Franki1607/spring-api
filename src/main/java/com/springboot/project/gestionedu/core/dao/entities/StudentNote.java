package com.springboot.project.gestionedu.core.dao.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "NoteEtudiant")
@Getter
@Setter
@NoArgsConstructor
public class StudentNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false, name = "nom")
    String nom;

    @Column(length = 100, nullable = false, name = "prenom")
    String prenom;

    @Column(nullable = false, name = "age")
    int age ;

    @Column(length = 100, nullable = false, name = "matiere")
    String matiere;

    @Column(nullable = false, name = "note")
    Double note;
}
