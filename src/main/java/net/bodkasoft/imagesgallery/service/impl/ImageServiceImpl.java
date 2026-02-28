package net.bodkasoft.imagesgallery.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bodkasoft.imagesgallery.domain.image.Image;
import net.bodkasoft.imagesgallery.dto.image.ImageRequestDto;
import net.bodkasoft.imagesgallery.repository.ImageRepository;
import net.bodkasoft.imagesgallery.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public List<Image> getAllImages() {
        return List.of();
    }

    @Override
    public Image getImageById(UUID id) {
        return null;
    }

    @Override
    public Image createImage(ImageRequestDto imageRequestDto) {
        return null;
    }

    @Override
    public void deleteImageById(UUID id) {

    }
}
