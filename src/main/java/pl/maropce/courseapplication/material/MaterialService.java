package pl.maropce.courseapplication.material;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    private final MaterialRepository materialRepository;

    MaterialService(MaterialRepository repository) {
        this.materialRepository = repository;
    }

    public Material save(Material material) {
        return materialRepository.save(material);
    }

    public List<Material> getAllMaterials() {
        return materialRepository.findAll();
    }

    public Optional<Material> getMaterial(Long id) {
        return materialRepository.findById(id);
    }

    public void deleteMaterial(Long id) {
        materialRepository.deleteById(id);
    }


}
