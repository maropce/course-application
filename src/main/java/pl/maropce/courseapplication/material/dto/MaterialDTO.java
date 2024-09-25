package pl.maropce.courseapplication.material.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialDTO {
    private Long id;
    private String title;
    private String description;
    private String url;
}
