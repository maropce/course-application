package pl.maropce.courseapplication.course.dto;

import pl.maropce.courseapplication.course.Course;
import pl.maropce.courseapplication.material.dto.MaterialMapper;
import pl.maropce.courseapplication.quiz.dto.QuizMapper;

import java.util.stream.Collectors;

public class CourseMapper {

    public static CourseDTO toDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setName(course.getName());
        courseDTO.setDescription(course.getDescription());
        courseDTO.setPrice(course.getPrice());
        courseDTO.setLevel(course.getLevel());
        courseDTO.setIsFree(course.getIsFree());
        courseDTO.setNumberOfPurchases(course.getNumberOfPurchases());

        courseDTO.setMaterials(course
                .getMaterials()
                .stream()
                .map(MaterialMapper::toDto)
                .collect(Collectors.toSet()));


        courseDTO.setQuizzes(course
                .getQuizzes()
                .stream()
                .map(QuizMapper::toDto)
                .collect(Collectors.toSet()));

        return courseDTO;
    }
}
