package net.bodkasoft.imagesgallery.dto.author;

import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;
import jakarta.validation.constraints.NotBlank;

@Value
@Builder
@Jacksonized
public class AuthorEntryDto {

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100, message = "Name cannot exceed 100 characters")
    String name;

}
