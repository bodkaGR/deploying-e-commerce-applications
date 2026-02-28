package net.bodkasoft.imagesgallery.web;

import net.bodkasoft.imagesgallery.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/images")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public ResponseEntity<Void> getAllImages() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Void> getImageById(@PathVariable UUID id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @PostMapping
    public ResponseEntity<Void> createImage() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageById(@PathVariable UUID id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
