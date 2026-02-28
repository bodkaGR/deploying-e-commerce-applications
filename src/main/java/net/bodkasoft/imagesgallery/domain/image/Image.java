package net.bodkasoft.imagesgallery.domain.image;

import lombok.Builder;
import lombok.Value;
import net.bodkasoft.imagesgallery.domain.author.Author;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
public class Image {

    UUID id;
    String title;
    String description;
    LocalDateTime createdAt;
    Author author;

}
