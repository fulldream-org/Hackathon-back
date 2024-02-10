package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.models.User;
import hack.fulldream.hackathonback.repository.UserRepository;
import hack.fulldream.hackathonback.service.PasswordService;
import hack.fulldream.hackathonback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
  private final UserService userService;
  private final PasswordService passwordService;

  @PostMapping("/signup")
  public User signup(@RequestBody User user) {
    user.setPassword(passwordService.encode(user.getPassword()));
    return userService.save(user);
  }

  @GetMapping("/user")
  public Page<User> getAllUsers(Pageable pageable) {
    return userService.findAllUsers(pageable);
  }

  @PutMapping("/user")
  public User saveUser(@RequestBody User user) {
    user.setPassword(passwordService.encode(user.getPassword()));
    return userService.save(user);
  }

  @GetMapping("/self")
  public User getSelf(Principal principal) {
    return userService.findByEmail(principal.getName());
  }
}
