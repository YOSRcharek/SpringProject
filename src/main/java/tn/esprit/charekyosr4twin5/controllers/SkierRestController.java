package tn.esprit.charekyosr4twin5.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.charekyosr4twin5.Services.ISkierService;
import tn.esprit.charekyosr4twin5.Services.SkierServicesimpl;
import tn.esprit.charekyosr4twin5.entities.Skieur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Tag(name = "Gestion Skieurs")
@RestController
@RequiredArgsConstructor
@RequestMapping("skier")
public class SkierRestController {
private final ISkierService skierServices;

    @Operation(description = "ajouter un skieur de la base de données")
    @PostMapping("/add")
    public Skieur saveSkier(@RequestBody Skieur skier){
        return skierServices.addSkier(skier);
    }
    @Operation(description = "modifier un skieur de la base de données")
    @PutMapping("/update")
    public Skieur updateSkieur(@RequestBody Skieur skieur) {
        return skierServices.updateSkier(skieur);
    }
    @Operation(description = "récupérer un skieur par num de la base de données")
    @GetMapping("/get/{numSkier}")
    public Skieur getSkier(@PathVariable Long numSkier){
            return skierServices.retriveSkier(numSkier);
    }
    @Operation(description = "récupérer tous les skieurs de la base de données")
    @GetMapping("/all")
    public List<Skieur> getAllSkieurs() {
        return skierServices.retriveAll();
    }
    @Operation(description = "supprimer un skieur par num de la base de données")
    @DeleteMapping("/delete/{numSkier}")
    public void deleteSkieur(@PathVariable Long numSkier) {
        skierServices.remouveSkier(numSkier);
    }
    @Operation(description = "récupérer un skieur par lastname et firstname de la base de données")
    @GetMapping("/getByFLName/{firstName}/{lastName}")
    public Skieur getSkierByFLname(@PathVariable String firstName,String lastName){
        return skierServices.getByFLname(firstName,lastName);
    }
    @Operation(description = "récupérer un skieur par birthdate de la base de données")
    @GetMapping("/getByDate/{birthDate}")
    public Skieur getByBirthDate(@PathVariable LocalDate birthDate) {
       return skierServices.getByDate(birthDate);
    }

}
