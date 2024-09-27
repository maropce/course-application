package pl.maropce.courseapplication.material;

public class MaterialNotFoundException extends RuntimeException {
    public MaterialNotFoundException(Long id) {
        super("Could not find material with id " + id);
    }
}
