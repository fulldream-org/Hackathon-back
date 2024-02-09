package hack.fulldream.hackathonback.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.util.UUID;

@Entity
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    String name;
}
