package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Donation {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String description;
  private Date date;
  private Boolean isAnonymous;

  @ManyToOne
  @JoinColumn(name = "id_post")
  private Post post;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User user;
}
