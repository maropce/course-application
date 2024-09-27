package pl.maropce.courseapplication.material;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maropce.courseapplication.material.dto.MaterialDTO;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("api/material")
public class MaterialController {

    private final MaterialService materialService;

    public MaterialController(MaterialService materialService) {
        this.materialService = materialService;
    }


    @GetMapping
    public ResponseEntity<List<MaterialDTO>> getAllMaterials() {
        return ResponseEntity.ok(materialService.getAllMaterials());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaterialDTO> getMaterial(@PathVariable Long id) {
        return ResponseEntity.ok(materialService.getMaterial(id));
    }

    @PostMapping
    public ResponseEntity<Void> addMaterial(
            @RequestBody Material material) throws URISyntaxException {
        MaterialDTO savedMaterial = materialService.save(material);
        return ResponseEntity.created(new URI("http://localhost:8080/api/course/" + savedMaterial.getId())).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(MaterialNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleMaterialNotFoundException(MaterialNotFoundException ex) {
        return ex.getMessage();
    }
}
