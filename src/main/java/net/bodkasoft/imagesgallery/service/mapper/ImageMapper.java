package net.bodkasoft.imagesgallery.service.mapper;

import net.bodkasoft.imagesgallery.domain.author.Author;
import net.bodkasoft.imagesgallery.dto.image.ImageEntry;
import net.bodkasoft.imagesgallery.dto.image.ImageListDto;
import net.bodkasoft.imagesgallery.dto.image.ImageDto;
import net.bodkasoft.imagesgallery.dto.image.ImageResponseDto;
import net.bodkasoft.imagesgallery.repository.entity.ImageEntity;
import net.bodkasoft.imagesgallery.domain.image.Image;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {AuthorMapper.class})
public interface ImageMapper {

    default Image toImage(ImageEntity imageEntity) {
        return Image.builder()
                .id(imageEntity.getId())
                .title(imageEntity.getTitle())
                .description(imageEntity.getDescription())
                .createdAt(imageEntity.getCreatedAt())
                .author(
                        Author.builder()
                                .id(imageEntity.getAuthor().getId())
                                .name(imageEntity.getAuthor().getName())
                                .build()
                )
                .build();
    }

    List<Image> toImageList(List<ImageEntity> imageEntities);

    @Mapping(target = "authorId", source = "author.id")
    ImageDto toImageDto(Image image);

    @Mapping(target = "authorEntry", source = "author")
    ImageEntry toImageEntry(Image image);

    ImageResponseDto toImageResponseDto(Image image);

    default ImageListDto toImageListDto(List<Image> images) {
        return ImageListDto.builder().images(toImageEntryList(images)).build();
    }

    List<ImageEntry> toImageEntryList(List<Image> images);
}
