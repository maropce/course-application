package pl.maropce.courseapplication.material;

import org.springframework.stereotype.Service;
import pl.maropce.courseapplication.material.dto.MaterialDTO;
import pl.maropce.courseapplication.material.dto.MaterialMapper;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository repository) {
        this.materialRepository = repository;
    }

    public MaterialDTO save(Material material) {
        Material save = materialRepository.save(material);
        return MaterialMapper.toDto(save);
    }

    public List<MaterialDTO> getAllMaterials() {
        return materialRepository.findAll()
                .stream()
                .map(MaterialMapper::toDto)
                .toList();
    }

    public MaterialDTO getMaterial(Long id) {
        Material material = materialRepository.findById(id)
                .orElseThrow(() -> new MaterialNotFoundException(id));
        return MaterialMapper.toDto(material);

    }

    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }


}
