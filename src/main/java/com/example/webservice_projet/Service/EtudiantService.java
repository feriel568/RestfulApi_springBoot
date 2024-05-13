package com.example.webservice_projet.Service;



import com.example.webservice_projet.Entity.Etudiant;
import java.util.List;
import java.util.Optional;
public interface EtudiantService {
    void addEtudiant(Etudiant etudiant);
    void updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long etudiantId);
    Optional<Etudiant> getEtudiantById(Long etudiantId);
    List<Etudiant> getAllEtudiants();
}