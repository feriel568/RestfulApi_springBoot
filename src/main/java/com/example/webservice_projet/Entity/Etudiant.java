package com.example.webservice_projet.Entity;

import jakarta.persistence.*;

@Entity
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private int age;
    private String niveau;

    private String adresse;


    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNiveau() {
        return niveau;
    }

    public String getAdresse() {
        return adresse;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Etudiant(Long id, String nom, String prenom, int age, String niveau, String adresse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.niveau = niveau;
        this.adresse = adresse;
    }

    public Etudiant(){

    }
}
