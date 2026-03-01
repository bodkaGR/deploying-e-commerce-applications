package net.bodkasoft.imagesgallery.service.mapper;

import net.bodkasoft.imagesgallery.domain.image.Image;
import net.bodkasoft.imagesgallery.repository.entity.AuthorEntity;
import net.bodkasoft.imagesgallery.repository.entity.ImageEntity;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class ImageMapperTest {

    private final ImageMapper mapper = new ImageMapperImpl();

    @Test
    void shouldMapEntityToDomain() {
        AuthorEntity author = new AuthorEntity();
        author.setId(UUID.randomUUID());
        author.setName("John");

        ImageEntity entity = new ImageEntity();
        entity.setTitle("Test");
        entity.setAuthor(author);

        Image image = mapper.toImage(entity);

        assertThat(image.getTitle()).isEqualTo("Test");
        assertThat(image.getAuthor().getName()).isEqualTo("John");
    }
}
