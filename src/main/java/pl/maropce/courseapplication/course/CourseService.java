package pl.maropce.courseapplication.course;

import org.springframework.stereotype.Service;
import pl.maropce.courseapplication.course.dto.CourseDTO;
import pl.maropce.courseapplication.course.dto.CourseMapper;

import java.util.List;


@Service
public class CourseService {

    private final CourseRepository courseRepository;


    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseDTO save(Course course) {
        Course save = courseRepository.save(course);
        return CourseMapper.toDto(save);
    }

    public List<CourseDTO> getAllCourses() {
       return courseRepository.findAll()
               .stream()
               .map(CourseMapper::toDto)
               .toList();
    }

    public CourseDTO getCourse(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
        return CourseMapper.toDto(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

}
