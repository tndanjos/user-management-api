package fiap.techchallenge._ADJT.restaurant_management_api.repository;

import fiap.techchallenge._ADJT.restaurant_management_api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
}