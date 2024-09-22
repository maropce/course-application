package pl.maropce.courseapplication.course;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/course")
class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(
            @PathVariable Long id) {
        Optional<Course> course = courseService.getCourse(id);


        return ResponseEntity.ok(
                course.orElseThrow(
                        () -> new CourseNotFoundException("Course with id: " + id + " does not exist!")
                ));
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping
    public ResponseEntity<Void> saveCourse(
            @RequestBody Course course) throws URISyntaxException {
        Course savedCourse = courseService.save(course);
        return ResponseEntity.created(new URI("http://localhost:8080/api/course/" + savedCourse.getId())).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }



    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<?> exceptionHandler(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


}
