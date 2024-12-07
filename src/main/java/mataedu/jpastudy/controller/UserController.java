package mataedu.jpastudy.controller;

import lombok.RequiredArgsConstructor;
import mataedu.jpastudy.entity.User;
import mataedu.jpastudy.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public Long addUser(String name, String email) {
        return userService.addUser(name, email);
    }

    @GetMapping("/user/find")
    public List<User> findUser(String name) {
        return userService.findUser(name);
    }

    @DeleteMapping("/user")
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }

    @PutMapping("/user")
    public void updateUser(Long id, String name, String email) {
        userService.updateUser(id, name, email);
    }
}
