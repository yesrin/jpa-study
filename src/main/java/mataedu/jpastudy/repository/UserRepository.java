package mataedu.jpastudy.repository;

import mataedu.jpastudy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
