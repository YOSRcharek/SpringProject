package tn.esprit.charekyosr4twin5.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.charekyosr4twin5.entities.Course;
import tn.esprit.charekyosr4twin5.Services.CourseServiceImpl;

import java.util.List;
@Tag(name = "Gestion courses")
@RestController
@RequiredArgsConstructor
@RequestMapping("course")
public class CourseRestController {

    private final CourseServiceImpl courseService;

    @Operation(description = "ajouter une course de la base de données")
    @PostMapping("/add")
    public Course addCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }
    @Operation(description = "modifier une course de la base de données")
    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }
    @Operation(description = "récupérer une course par num de la base de données")
    @GetMapping("/get/{numCourse}")
    public Course getCourse(@PathVariable Long numCourse) {
        return courseService.retrieveCourse(numCourse);
    }
    @Operation(description = "récupérer tous les courses de la base de données")
    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.retriveAll();
    }
    @Operation(description = "supprimer une course par num de la base de données")
    @DeleteMapping("/delete/{numCourse}")
    public void deleteCourse(@PathVariable Long numCourse) {
        courseService.remouveCourse(numCourse);
    }
}
