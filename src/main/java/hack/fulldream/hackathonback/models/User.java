package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "\"user\"")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  UUID id;

  String firstName;
  String lastName;
  String username;
  String email;
  String password;
}
