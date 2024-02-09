package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "id_post")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
