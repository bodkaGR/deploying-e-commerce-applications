package net.bodkasoft.imagesgallery.repository;

import net.bodkasoft.imagesgallery.repository.entity.AuthorEntity;
import net.bodkasoft.imagesgallery.repository.entity.ImageEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class ImageRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ImageRepository imageRepository;

    @Test
    void shouldSaveAndFindImage() {
        AuthorEntity author = new AuthorEntity();
        author.setName("John");
        entityManager.persist(author);

        ImageEntity image = new ImageEntity();
        image.setTitle("Test");
        image.setDescription("Description");
        image.setCreatedAt(LocalDateTime.now());
        image.setAuthor(author);

        imageRepository.save(image);

        List<ImageEntity> all = imageRepository.findAll();

        assertThat(all).hasSize(1);
        assertThat(all.getFirst().getTitle()).isEqualTo("Test");
    }
}
