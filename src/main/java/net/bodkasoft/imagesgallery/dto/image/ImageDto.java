package net.bodkasoft.imagesgallery.dto.image;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Data
@Builder
@Jacksonized
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ImageDto {

    @NotBlank(message = "Title is mandatory")
    @Size(max = 100, message = "Title cannot exceed 100 characters")
    String title;

    @Size(max = 500, message = "Description cannot exceed 100 characters")
    String description;

    @NotBlank(message = "Author id is mandatory")
    UUID authorId;
}
