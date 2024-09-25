package pl.maropce.courseapplication.course;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maropce.courseapplication.course.dto.CourseDTO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("api/course")
class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourse(
            @PathVariable Long id) {

        CourseDTO course = courseService.getCourse(id);
        return ResponseEntity.ok(course);
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @PostMapping
    public ResponseEntity<Void> saveCourse(
            @RequestBody Course course) throws URISyntaxException {
        CourseDTO savedCourse = courseService.save(course);
        return ResponseEntity.created(new URI("http://localhost:8080/api/course/" + savedCourse.getId())).build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }



    @ExceptionHandler(CourseNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String exceptionHandler(CourseNotFoundException ex) {
        return ex.getMessage();
    }




}
