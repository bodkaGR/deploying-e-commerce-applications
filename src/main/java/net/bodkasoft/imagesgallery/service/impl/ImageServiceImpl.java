package net.bodkasoft.imagesgallery.service.impl;

import jakarta.persistence.PersistenceException;
import lombok.extern.slf4j.Slf4j;
import net.bodkasoft.imagesgallery.domain.image.Image;
import net.bodkasoft.imagesgallery.dto.image.ImageDto;
import net.bodkasoft.imagesgallery.repository.AuthorRepository;
import net.bodkasoft.imagesgallery.repository.ImageRepository;
import net.bodkasoft.imagesgallery.repository.entity.AuthorEntity;
import net.bodkasoft.imagesgallery.repository.entity.ImageEntity;
import net.bodkasoft.imagesgallery.service.ImageService;
import net.bodkasoft.imagesgallery.service.exception.AuthorNotFoundException;
import net.bodkasoft.imagesgallery.service.exception.ImageNotFoundException;
import net.bodkasoft.imagesgallery.service.mapper.ImageMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final AuthorRepository authorRepository;
    private final ImageMapper imageMapper;

    public ImageServiceImpl(ImageRepository imageRepository, AuthorRepository authorRepository, ImageMapper imageMapper) {
        this.imageRepository = imageRepository;
        this.authorRepository = authorRepository;
        this.imageMapper = imageMapper;
    }

    @Override
    public List<Image> getAllImages() {
        return imageMapper.toImageList(imageRepository.findAll());
    }

    @Override
    public Image getImageById(UUID imageId) {
        ImageEntity image = imageRepository.findById(imageId).orElseThrow(() -> {
            log.info("Image with id {} not found", imageId);
            return new ImageNotFoundException(imageId);
        });

        return imageMapper.toImage(image);
    }

    @Override
    public Image createImage(ImageDto imageDto) {
        AuthorEntity author = authorRepository.findById(imageDto.getAuthorId())
                .orElseThrow(() -> new AuthorNotFoundException(imageDto.getAuthorId()));

        ImageEntity image = ImageEntity.builder()
                .title(imageDto.getTitle())
                .description(imageDto.getDescription())
                .createdAt(LocalDateTime.now())
                .author(author)
                .build();

        ImageEntity saved = imageRepository.save(image);

        return imageMapper.toImage(saved);
    }

    @Override
    public void deleteImageById(UUID imageId) {
        try {
            imageRepository.deleteById(imageId);
        } catch (Exception ex) {
            log.error("Exception occured while deleting image with id {}", imageId);
            throw new PersistenceException(ex);
        }
    }
}
