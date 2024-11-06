package mataedu.jpastudy.service;

import lombok.RequiredArgsConstructor;
import mataedu.jpastudy.entity.User;
import mataedu.jpastudy.repository.UserJpqlRepository;
import mataedu.jpastudy.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserJpqlRepository userJpqlRepository;

    public Long addUser(String name, String email) {
        User user = User.toUser(name, email);
        return userRepository.save(user).getId();
    }

    public List<User> findUser(String name) {
        return userJpqlRepository.findUserName(name);
    }
}
