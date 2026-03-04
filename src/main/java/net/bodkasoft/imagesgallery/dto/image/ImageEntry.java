package net.bodkasoft.imagesgallery.dto.image;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import net.bodkasoft.imagesgallery.dto.author.AuthorEntry;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
@Builder
@Jacksonized
public class ImageEntry {
    UUID id;
    String title;
    String description;
    LocalDateTime createdAt;
    AuthorEntry authorEntry;
}
