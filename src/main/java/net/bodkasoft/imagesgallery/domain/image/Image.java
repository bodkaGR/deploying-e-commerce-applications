package net.bodkasoft.imagesgallery.domain.image;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import net.bodkasoft.imagesgallery.domain.author.Author;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Image {

    UUID id;
    String title;
    String description;
    LocalDateTime createdAt;
    Author author;

}
