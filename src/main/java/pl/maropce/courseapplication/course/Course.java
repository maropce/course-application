package pl.maropce.courseapplication.course;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.maropce.courseapplication.material.Material;
import pl.maropce.courseapplication.quiz.Quiz;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private CourseLevel level;
    private Boolean isFree;
    private Integer numberOfPurchases = 0;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Material> materials = new HashSet<>();

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Quiz> quizzes = new HashSet<>();
}
