package net.bodkasoft.imagesgallery.service;

import net.bodkasoft.imagesgallery.dto.image.ImageDto;
import net.bodkasoft.imagesgallery.repository.AuthorRepository;
import net.bodkasoft.imagesgallery.repository.ImageRepository;
import net.bodkasoft.imagesgallery.repository.entity.AuthorEntity;
import net.bodkasoft.imagesgallery.repository.entity.ImageEntity;
import net.bodkasoft.imagesgallery.service.exception.AuthorNotFoundException;
import net.bodkasoft.imagesgallery.service.impl.ImageServiceImpl;
import net.bodkasoft.imagesgallery.service.mapper.ImageMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ImageServiceTest {
    @Mock
    private ImageRepository imageRepository;

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private ImageMapper imageMapper;

    @InjectMocks
    private ImageServiceImpl imageService;

    private UUID authorId;
    private ImageDto imageDto;

    @BeforeEach
    void init() {
        authorId = UUID.randomUUID();
        imageDto = ImageDto.builder()
                .title("Mountain")
                .authorId(authorId)
                .build();
    }

    @Test
    void createImage_ShouldSaveAndReturnImage_WhenAuthorExists() {
        // 1. Given
        AuthorEntity author = new AuthorEntity();
        author.setId(authorId);

        String expectedTitle = "Mountain";
        imageDto = ImageDto.builder()
                .title(expectedTitle)
                .authorId(authorId)
                .build();

        ImageEntity savedEntity = ImageEntity.builder()
                .title(expectedTitle)
                .author(author)
                .build();

        net.bodkasoft.imagesgallery.domain.image.Image expectedImage =
                net.bodkasoft.imagesgallery.domain.image.Image.builder()
                        .title(expectedTitle)
                        .build();

        when(authorRepository.findById(authorId)).thenReturn(Optional.of(author));
        when(imageRepository.save(any(ImageEntity.class))).thenReturn(savedEntity);
        when(imageMapper.toImage(any(ImageEntity.class))).thenReturn(expectedImage);

        // 2. When
        var result = imageService.createImage(imageDto);

        // 3. Then
        assertNotNull(result);
        verify(imageRepository).save(argThat(entity ->
                entity.getTitle().contains("Mountain") &&
                        entity.getAuthor().getId().equals(authorId)
        ));
    }

    @Test
    void createImage_ShouldThrowException_WhenAuthorNotFound() {
        // Given
        UUID fakeId = UUID.randomUUID();
        ImageDto dtoWithFakeAuthor = ImageDto.builder().authorId(fakeId).build();

        when(authorRepository.findById(fakeId)).thenReturn(Optional.empty());

        // When & Then
        AuthorNotFoundException exception = assertThrows(AuthorNotFoundException.class, () -> {
            imageService.createImage(dtoWithFakeAuthor);
        });

        assertTrue(exception.getMessage().contains(fakeId.toString()));

        verify(imageRepository, never()).save(any());
    }
}
