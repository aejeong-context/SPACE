package so.ego.space.domains.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import so.ego.space.domains.user.application.dto.UserLoginResponse;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email);
}
