package pl.maropce.courseapplication.material.dto;

import pl.maropce.courseapplication.material.Material;

public class MaterialMapper {

    public static MaterialDTO toDto(Material material) {
        MaterialDTO materialDTO = new MaterialDTO();
        materialDTO.setId(material.getId());
        materialDTO.setTitle(material.getTitle());
        materialDTO.setDescription(material.getDescription());
        materialDTO.setUrl(material.getUrl());

        return materialDTO;
    }
}
