package com.example.webservice_projet.Controller;

import com.example.webservice_projet.Entity.Etudiant;
import com.example.webservice_projet.Service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    private final EtudiantService etudiantService;

    @Autowired
    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

   @PostMapping
    public ResponseEntity<Etudiant> addEtudiant(@RequestBody Etudiant etudiant) {
        etudiantService.addEtudiant(etudiant);
        return new ResponseEntity<>(etudiant, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable Long id, @RequestBody Etudiant etudiant) {
        Optional<Etudiant> existingEtudiantOptional = etudiantService.getEtudiantById(id);
        if (existingEtudiantOptional.isPresent()) {
            Etudiant existingEtudiant = existingEtudiantOptional.get();
            existingEtudiant.setId(id);
            existingEtudiant.setNom(etudiant.getNom());
            existingEtudiant.setPrenom(etudiant.getPrenom());
            existingEtudiant.setAge(etudiant.getAge());
            existingEtudiant.setNiveau(etudiant.getNiveau());
            existingEtudiant.setAdresse(etudiant.getAdresse());
            // Update other fields similarly if needed

            etudiantService.updateEtudiant(existingEtudiant);
            return ResponseEntity.ok(existingEtudiant);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEtudiant(@PathVariable Long id) {
        Optional<Etudiant> existingEtudiantOptional = etudiantService.getEtudiantById(id);
        if (existingEtudiantOptional.isPresent()) {
            etudiantService.deleteEtudiant(id);
            return ResponseEntity.ok("Etudiant with ID " + id + " has been deleted successfully.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Etudiant with ID " + id + " not found.");
    }


    @GetMapping("/{id}")
    public ResponseEntity<Etudiant> getEtudiantById(@PathVariable Long id) {
        Optional<Etudiant> etudiantOptional = etudiantService.getEtudiantById(id);
        return etudiantOptional.map(etudiant -> new ResponseEntity<>(etudiant, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiants() {
        List<Etudiant> etudiants = etudiantService.getAllEtudiants();
        if (!etudiants.isEmpty()) {
            return new ResponseEntity<>(etudiants, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
