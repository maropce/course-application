package pl.maropce.courseapplication.quiz;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.maropce.courseapplication.course.Course;

@Entity
@Data
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

}
