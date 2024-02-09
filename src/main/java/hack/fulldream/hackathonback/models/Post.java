package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String title;
  private String description;
  private Date creationDate;
  private Double goal;
  private Date endDate;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User user;
}
