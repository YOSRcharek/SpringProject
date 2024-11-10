package tn.esprit.charekyosr4twin5.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.charekyosr4twin5.entities.Piste;
import tn.esprit.charekyosr4twin5.Services.PisteServiceImpl;

import java.util.List;
@Tag(name = "Gestion Pistes")
@RestController
@RequiredArgsConstructor
@RequestMapping("/piste")
public class PisteRestController {

    private final PisteServiceImpl pisteService;

    @Operation(description = "ajouter une piste de la base de données")
    @PostMapping("/add")
    public Piste addPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }
    @Operation(description = "modifier une piste de la base de données")
    @PutMapping("/update")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteService.updatePiste(piste);
    }
    @Operation(description = "récupérer une piste par num de la base de données")
    @GetMapping("/get/{numPiste}")
    public Piste getPiste(@PathVariable Long numPiste) {
        return pisteService.retrievePiste(numPiste);
    }

    @Operation(description = "récupérer tous les pistes de la base de données")
    @GetMapping("/all")
    public List<Piste> getAllPistes() {
        return pisteService.getAllPistes();
    }

    @Operation(description = "supprimer une piste par num de la base de données")
    @DeleteMapping("/delete/{numPiste}")
    public void deletePiste(@PathVariable Long numPiste) {
        pisteService.removePiste(numPiste);
    }
    @Operation(description = "assigner une num skieur a un num piste")
    @PostMapping("/assign/{numSkier}/{numPiste}")
    public ResponseEntity<String> assignSkierToPiste(
            @PathVariable Long numSkier,
            @PathVariable Long numPiste) {
        pisteService.assignSkierToPiste(numSkier, numPiste);
        return ResponseEntity.ok("Le skieur a été assigné à la piste avec succès.");
    }
}
