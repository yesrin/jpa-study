package mataedu.jpastudy.repository;

import mataedu.jpastudy.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        userRepository.save(user);

        // then
        User getUser = userRepository.findById(user.getId()).orElseThrow(RuntimeException::new);
        assertThat(getUser.getId()).isEqualTo(user.getId());
        assertThat(getUser.getName()).isEqualTo(user.getName());
        assertThat(getUser.getEmail()).isEqualTo(user.getEmail());
    }

}