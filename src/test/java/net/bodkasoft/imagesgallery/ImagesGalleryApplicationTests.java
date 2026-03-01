package net.bodkasoft.imagesgallery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.health.actuate.endpoint.HealthDescriptor;
import org.springframework.boot.health.actuate.endpoint.HealthEndpoint;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest()
class ImagesGalleryApplicationTests {

    @Autowired
    private HealthEndpoint healthEndpoint;

    @Test
    void contextLoadsAndHealthIsUp() {
        HealthDescriptor health = healthEndpoint.health();

        assertThat(health).isNotNull();
        assertThat(health.getStatus().getCode()).isEqualTo("UP");
    }
}
