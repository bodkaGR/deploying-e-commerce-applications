package net.bodkasoft.imagesgallery.service.exception;

import java.util.UUID;

public class AuthorNotFoundException extends RuntimeException {
    private static final String AUTHOR_NOT_FOUND_MESSAGE = "Author with id %s not found";

    public AuthorNotFoundException(UUID authorId) {
        super(String.format(AUTHOR_NOT_FOUND_MESSAGE, authorId));
    }
}
