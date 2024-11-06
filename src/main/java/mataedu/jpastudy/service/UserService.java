package mataedu.jpastudy.service;

import lombok.RequiredArgsConstructor;
import mataedu.jpastudy.entity.User;
import mataedu.jpastudy.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Long addUser(String name, String email) {
        User user = User.toUser(name, email);
        return userRepository.save(user).getId();
    }
}
