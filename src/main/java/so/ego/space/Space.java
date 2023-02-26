package so.ego.space;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Space {
    public static void main(String[] args) {
        SpringApplication.run(Space.class, args);
    }
}
