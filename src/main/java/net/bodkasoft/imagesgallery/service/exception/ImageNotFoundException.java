package net.bodkasoft.imagesgallery.service.exception;

import java.util.UUID;

public class ImageNotFoundException extends RuntimeException {
    private static final String IMAGE_NOT_FOUND_MESSAGE = "Image with id %s not found";

    public ImageNotFoundException(UUID imageId) {
        super(String.format(IMAGE_NOT_FOUND_MESSAGE, imageId));
    }
}
