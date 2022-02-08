package netology.homework.springboot2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;
    public static GenericContainer<?> devapp=new GenericContainer<>("devapp").withExposedPorts(8080);
    public static GenericContainer<?> prodapp=new GenericContainer<>("prodapp").withExposedPorts(8081);

    @BeforeAll
    public static void setUp() {
        devapp.start();
        prodapp.start();

    }

    @Test
    void devappContextLoads() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + devapp.getMappedPort(8080) +"/authorize?user=user&password=password", String.class);
        assertEquals(forEntity.getBody(),"Unknown user user");
    }
    @Test
    void prodappContextLoads() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + prodapp.getMappedPort(8081) +"/authorize?user=user&password", String.class);
        assertEquals(forEntity.getBody(),"User name or password is empty");
    }
}
