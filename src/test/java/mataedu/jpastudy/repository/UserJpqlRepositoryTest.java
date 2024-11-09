package mataedu.jpastudy.repository;

import mataedu.jpastudy.entity.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class UserJpqlRepositoryTest {

    @Autowired
    private UserJpqlRepository userJpqlRepository;

    @Test
    @DisplayName("JPQL로 유저를 저장한다.")
    void save() {
        // given
        User user = User.builder()
                .name("test")
                .email("test@test.com")
                .build();

        // when
        User saveUser = userJpqlRepository.saveUser(user);

        // then
        assertThat(saveUser.getId()).isNotNull();
    }

    @Test
    @DisplayName("JPQL로 유저들을 이름으로 조회한다.")
    void findUserName() {
        //given
        User user = User.builder()
                .name("홍길동")
                .email("test@test.com")
                .build();

        String searchName = "홍길동";
        userJpqlRepository.saveUser(user);

        //when
        List<User> users = userJpqlRepository.findUserName(searchName);

        //then
        assertThat(users).hasSize(1);

    }

}