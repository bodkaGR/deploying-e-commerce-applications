package net.bodkasoft.imagesgallery.domain.author;


import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class Author {

    UUID id;
    String name;

}
