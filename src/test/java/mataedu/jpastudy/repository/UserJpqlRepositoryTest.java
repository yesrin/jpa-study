package mataedu.jpastudy.repository;

import mataedu.jpastudy.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UserJpqlRepositoryTest {

    @Autowired
    private UserJpqlRepository userJpqlRepository;

    @Test
    @DisplayName("JPQL로 유저를 저장한다.")
    void save() {
        // given
        User user = User.builder()
                .id(1L)
                .name("test")
                .email("test@test.com")
                .build();

        // when
        User saveUser = userJpqlRepository.saveUser(user);

        // then
        assertThat(saveUser.getId()).isNotNull();

    }
}