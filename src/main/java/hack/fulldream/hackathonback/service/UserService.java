package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.User;
import hack.fulldream.hackathonback.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  public final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User save(User user) {
    return userRepository.save(user);
  }

  public User findByUserName(String name) {
    return userRepository.findByUsername(name);
  }

  public Optional<User> findUserById(UUID id) {
    return userRepository.findById(id);
  }

  public List<User> findAllUsers() {
      return userRepository.findAll();
  }

  public Optional<User> deleteUser(UUID id) {
    Optional<User> toFind = userRepository.findById(id);

    if (toFind.isPresent()) {
      userRepository.deleteById(id);
    }
    return toFind;
  }
}
