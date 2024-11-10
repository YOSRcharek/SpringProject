package tn.esprit.charekyosr4twin5.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.charekyosr4twin5.entities.Registration;
import tn.esprit.charekyosr4twin5.Services.RegistrationServiceImpl;

import java.util.List;
@Tag(name = "Gestion Registrations")
@RestController
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationRestController {

    private final RegistrationServiceImpl registrationService;

    @Operation(description = "ajouter un registration de la base de données")
    @PostMapping("/add")
    public Registration addRegistration(@RequestBody Registration registration) {
        return registrationService.addRegistration(registration);
    }
    @Operation(description = "modifier un registration de la base de données")
    @PutMapping("/update")
    public Registration updateRegistration(@RequestBody Registration registration) {
        return registrationService.updateRegistration(registration);
    }
    @Operation(description = "récupérer un registration par num de la base de données")
    @GetMapping("/get/{numRegistration}")
    public Registration getRegistration(@PathVariable Long numRegistration) {
        return registrationService.retrieveRegistration(numRegistration);
    }
    @Operation(description = "récupérer tous les registrations de la base de données")
    @GetMapping("/all")
    public List<Registration> getAllRegistrations() {
        return registrationService.getAllRegistrations();
    }
    @Operation(description = "supprimer un registration par num de la base de données")
    @DeleteMapping("/delete/{numRegistration}")
    public void deleteRegistration(@PathVariable Long numRegistration) {
        registrationService.removeRegistration(numRegistration);
    }
}
