package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.User;
import hack.fulldream.hackathonback.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUserName(String name){
        return userRepository.findByUsername(name);
    }

    public Optional<User> findUserById(UUID id){
        return userRepository.findById(id);
    }

    public List<User> findAllUsers(){
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    public User updateUser(UUID id){
        return userRepository.updateById(id);
    }

    public Optional<User> deleteUser(UUID id){
        Optional<User> toFind = userRepository.findById(id);

        if(toFind.isPresent()){
            userRepository.deleteById(id);
        }
        return toFind;
    }
}
