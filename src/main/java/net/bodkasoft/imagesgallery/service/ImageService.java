package net.bodkasoft.imagesgallery.service;

import net.bodkasoft.imagesgallery.domain.image.Image;
import net.bodkasoft.imagesgallery.dto.image.ImageRequestDto;

import java.util.List;
import java.util.UUID;

public interface ImageService {

    List<Image> getAllImages();

    Image getImageById(UUID id);

    Image createImage(ImageRequestDto imageRequestDto);

    void deleteImageById(UUID id);
}
