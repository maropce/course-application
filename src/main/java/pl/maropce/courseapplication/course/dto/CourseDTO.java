package pl.maropce.courseapplication.course.dto;

import lombok.Getter;
import lombok.Setter;
import pl.maropce.courseapplication.course.CourseLevel;
import pl.maropce.courseapplication.material.dto.MaterialDTO;
import pl.maropce.courseapplication.quiz.dto.QuizDTO;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CourseDTO {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private CourseLevel level;
    private Boolean isFree;
    private Integer numberOfPurchases = 0;
    private Set<MaterialDTO> materials = new HashSet<>();
    private Set<QuizDTO> quizzes = new HashSet<>();
}
