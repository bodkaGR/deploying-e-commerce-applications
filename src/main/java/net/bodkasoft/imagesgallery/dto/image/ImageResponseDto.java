package net.bodkasoft.imagesgallery.dto.image;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import net.bodkasoft.imagesgallery.dto.author.AuthorDto;

import java.time.LocalDateTime;

@Value
@Builder
@Jacksonized
public class ImageResponseDto {
    String title;
    String description;
    LocalDateTime createdAt;
    AuthorDto author;
}
