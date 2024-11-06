package mataedu.jpastudy.repository;

import mataedu.jpastudy.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("유저를 저장한다.")
    void addUser() {
        // given
        User user = User.builder()
                .id(1L)
                .name("test")
                .email("test@test.com")
                .build();

        // when
        User saveUser = userRepository.save(user);

        // then
        assertThat(saveUser.getId()).isNotNull();

    }

    @Test
    @DisplayName("유저를 ID 조회한다.")
    void findUser() {
        // given
        User user = User.builder()
                .name("test")
                .email("test.test.com")
                .build();

        // when
        Long id = user.getId();
        Optional<User> optionalUser = userRepository.findById(id);

        // then
        assertTrue(optionalUser.isPresent());
    }


}