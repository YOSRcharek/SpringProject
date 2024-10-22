package tn.esprit.charekyosr4twin5.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.charekyosr4twin5.Services.ISkierService;
import tn.esprit.charekyosr4twin5.Services.SkierServicesimpl;
import tn.esprit.charekyosr4twin5.entities.Skieur;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("skier")
public class SkierRestController {
private final ISkierService skierServices;

    @PostMapping("/add")
    public Skieur saveSkier(@RequestBody Skieur skier){
        return skierServices.addSkier(skier);
    }
    @PutMapping("/update")
    public Skieur updateSkieur(@RequestBody Skieur skieur) {
        return skierServices.updateSkier(skieur);
    }
    @GetMapping("/get/{numSkier}")
    public Skieur getSkier(@PathVariable Long numSkier){
            return skierServices.retriveSkier(numSkier);
    }
    @GetMapping("/all")
    public List<Skieur> getAllSkieurs() {
        return skierServices.retriveAll();
    }

    @DeleteMapping("/delete/{numSkier}")
    public void deleteSkieur(@PathVariable Long numSkier) {
        skierServices.remouveSkier(numSkier);
    }

    @GetMapping("/getByFLName/{firstName}/{lastName}")
    public Skieur getSkierByFLname(@PathVariable String firstName,String lastName){
        return skierServices.getByFLname(firstName,lastName);
    }

    @GetMapping("/getByDate/{birthDate}")
    public Skieur getByBirthDate(@PathVariable LocalDate birthDate) {
       return skierServices.getByDate(birthDate);
    }

}
