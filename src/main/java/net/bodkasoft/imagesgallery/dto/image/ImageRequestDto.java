package net.bodkasoft.imagesgallery.dto.image;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Value
@Builder
@Jacksonized
public class ImageRequestDto {

    String title;

    String description;

    LocalDateTime createdAt;

    String authorName;
}
