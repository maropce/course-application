package pl.maropce.courseapplication.material;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.maropce.courseapplication.course.Course;

@Entity
@Data
@NoArgsConstructor
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

}
