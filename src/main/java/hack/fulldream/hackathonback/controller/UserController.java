package hack.fulldream.hackathonback.controller;


import hack.fulldream.hackathonback.models.User;
import hack.fulldream.hackathonback.repository.UserRepository;
import hack.fulldream.hackathonback.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepo;
    private final PasswordService passwordService;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        user.setPassword(passwordService.encode(user.getPassword()));
        return userRepo.save(user);
    }
}
