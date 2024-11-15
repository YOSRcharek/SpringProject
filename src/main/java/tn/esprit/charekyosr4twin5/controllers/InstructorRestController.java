package tn.esprit.charekyosr4twin5.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.charekyosr4twin5.entities.Instructor;
import tn.esprit.charekyosr4twin5.Services.InstructorServiceImpl;

import java.util.List;
@Tag(name = "Gestion Instructors")
@RestController
@RequiredArgsConstructor
@RequestMapping("/instructor")
public class InstructorRestController {

    private final InstructorServiceImpl instructorService;

    @Operation(description = "ajouter une instructor de la base de données")
    @PostMapping("/add")
    public Instructor addInstructor(@RequestBody Instructor instructor) {
        return instructorService.addInstructor(instructor);
    }
    @Operation(description = "modifier une instructor de la base de données")
    @PutMapping("/update")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorService.updateInstructor(instructor);
    }
    @Operation(description = "récupérer une instructor par num de la base de données")
    @GetMapping("/get/{numInstructor}")
    public Instructor getInstructor(@PathVariable Long numInstructor) {
        return instructorService.retrieveInstructor(numInstructor);
    }
    @Operation(description = "récupérer tous les instructors de la base de données")
    @GetMapping("/all")
    public List<Instructor> getAllInstructors() {
        return instructorService.getAllInstructors();
    }
    @Operation(description = "supprimer une instructor par num de la base de données")
    @DeleteMapping("/delete/{numInstructor}")
    public void deleteInstructor(@PathVariable Long numInstructor) {
        instructorService.removeInstructor(numInstructor);
    }
    @Operation(description = "ajouter une instructor a une course de la base de données")
    @PostMapping("/addToCourse")
    public Instructor addInstructorToCourse(@RequestBody Instructor instructor,List<Long> numCourse) {
        return instructorService.addInstructorToCourse(instructor, numCourse);
    }

    @Operation(description = "ajouter une instructor et les assigners a des courses de la base de données")
    @PostMapping("/addAndAssignToCourses")
    public Instructor addInstructorAndAssignToCourses(@RequestBody Instructor instructor) {
        return instructorService.addInstructorAndAssignToCourses(instructor);
    }
}
