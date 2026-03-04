package net.bodkasoft.imagesgallery.dto.image;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Builder(toBuilder = true)
@Jacksonized
public class ImageListDto {
    List<ImageEntry> images;
}
