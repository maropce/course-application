package pl.maropce.courseapplication.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.maropce.courseapplication.course.Course;
import pl.maropce.courseapplication.course.CourseRepository;
import pl.maropce.courseapplication.course.CourseLevel;
import pl.maropce.courseapplication.material.Material;
import pl.maropce.courseapplication.material.MaterialRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {


    private final CourseRepository courseRepository;
    private final MaterialRepository materialRepository;

    public DataInitializer(CourseRepository courseRepository, MaterialRepository materialRepository) {
        this.courseRepository = courseRepository;
        this.materialRepository = materialRepository;
    }

    @Override
    public void run(String... args) throws Exception {
       createSampleCourses();
    }

    public List<Course> createSampleCourses() {
        List<Course> courses = new ArrayList<>();

        Course beginnerCourse = new Course();
        beginnerCourse.setName("Java for Beginners");
        beginnerCourse.setDescription("Learn the basics of Java programming from scratch.");
        beginnerCourse.setPrice(new BigDecimal("49.99"));
        beginnerCourse.setLevel(CourseLevel.BEGINNER);
        beginnerCourse.setIsFree(false);
        beginnerCourse.setNumberOfPurchases(0);
        courses.add(beginnerCourse);

        Course intermediateCourse = new Course();
        intermediateCourse.setName("Spring Boot Intermediate Guide");
        intermediateCourse.setDescription("Dive deeper into Spring Boot and build more complex applications.");
        intermediateCourse.setPrice(new BigDecimal("89.99"));
        intermediateCourse.setLevel(CourseLevel.INTERMEDIATE);
        intermediateCourse.setIsFree(false);
        intermediateCourse.setNumberOfPurchases(0);
        courses.add(intermediateCourse);

        Course advancedCourse = new Course();
        advancedCourse.setName("Advanced Java Performance Tuning");
        advancedCourse.setDescription("Master performance tuning in Java applications.");
        advancedCourse.setPrice(new BigDecimal("129.99"));
        advancedCourse.setLevel(CourseLevel.ADVANCED);
        advancedCourse.setIsFree(false);
        advancedCourse.setNumberOfPurchases(0);
        courses.add(advancedCourse);


        courseRepository.saveAll(courses);

        ///////////////////////////////////////////////////////////////////////////

        Material material1 = new Material();
        material1.setTitle("Java Introduction");
        material1.setDescription("Text material on Java basics.");
        material1.setUrl("https://example.com/java_intro");
        material1.setCourse(beginnerCourse);

        Material material2 = new Material();
        material2.setTitle("Spring Boot Introduction");
        material2.setDescription("Video on Spring Boot.");
        material2.setUrl("https://example.com/spring_boot_intro");
        material2.setCourse(intermediateCourse);

        materialRepository.save(material1);
        materialRepository.save(material2);



        return courses;
    }
}

