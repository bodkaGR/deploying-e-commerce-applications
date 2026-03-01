package net.bodkasoft.imagesgallery.web;

import jakarta.validation.Valid;
import net.bodkasoft.imagesgallery.dto.image.ImageDto;
import net.bodkasoft.imagesgallery.dto.image.ImageListDto;
import net.bodkasoft.imagesgallery.dto.image.ImageResponseDto;
import net.bodkasoft.imagesgallery.service.ImageService;
import net.bodkasoft.imagesgallery.service.mapper.ImageMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.http.ResponseEntity.noContent;

@RestController
@Validated
@RequestMapping("/api/v1/images")
public class ImageController {

    private final ImageService imageService;
    private final ImageMapper imageMapper;

    public ImageController(ImageService imageService, ImageMapper imageMapper) {
        this.imageService = imageService;
        this.imageMapper = imageMapper;
    }

    @GetMapping
    public ResponseEntity<ImageListDto> getAllImages() {
        return ResponseEntity.ok(imageMapper.toImageListDto(imageService.getAllImages()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageResponseDto> getImageById(@PathVariable UUID id) {
        return ResponseEntity.ok(imageMapper.toImageResponseDto(imageService.getImageById(id)));
    }

    @PostMapping
    public ResponseEntity<ImageDto> createImage(@RequestBody @Valid ImageDto imageDto) {
        return ResponseEntity.ok(imageMapper.toImageDto(imageService.createImage(imageDto)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImageById(@PathVariable UUID id) {
        imageService.deleteImageById(id);
        return noContent().build();
    }
}
