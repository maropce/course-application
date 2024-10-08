package pl.maropce.courseapplication.course;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
class CourseNotFoundException extends RuntimeException {
    public CourseNotFoundException(Long id) {
        super("Could not find course with id " + id);
    }
}
