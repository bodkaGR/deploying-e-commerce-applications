package net.bodkasoft.imagesgallery.controller;

import net.bodkasoft.imagesgallery.domain.image.Image;
import net.bodkasoft.imagesgallery.service.ImageService;
import net.bodkasoft.imagesgallery.service.mapper.ImageMapper;
import net.bodkasoft.imagesgallery.web.ImageController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ImageController.class)
class ImageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ImageService imageService;

    @MockitoBean
    private ImageMapper imageMapper;

    @Test
    void shouldReturnImages() throws Exception {
        when(imageService.getAllImages())
                .thenReturn(List.of(new Image()));

        mockMvc.perform(get("/api/v1/images"))
                .andExpect(status().isOk());
    }
}
