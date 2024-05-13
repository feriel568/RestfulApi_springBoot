package com.example.webservice_projet.Service;

import com.example.webservice_projet.Entity.Etudiant;
import com.example.webservice_projet.Repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService {
    @Autowired
    private EtudiantRepository etudiantRepository;


    public void addEtudiant(Etudiant etudiant) {
        etudiantRepository.save(etudiant);
    }

    public void updateEtudiant(Etudiant etudiant) {
        etudiantRepository.save(etudiant);
    }

    public void deleteEtudiant(Long etudiantId) {
        etudiantRepository.deleteById(etudiantId);
    }

    public Optional<Etudiant> getEtudiantById(Long etudiantId) {
        return etudiantRepository.findById(etudiantId);
    }

    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }
}
