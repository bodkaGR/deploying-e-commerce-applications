package net.bodkasoft.imagesgallery.dto.author;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.UUID;

@Value
@Builder
@Jacksonized
public class AuthorEntry {
    UUID id;
    String name;
}
