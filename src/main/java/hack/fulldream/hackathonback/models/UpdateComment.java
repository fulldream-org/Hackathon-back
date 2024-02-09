package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "update_comment")
public class UpdateComment {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String value;
  private Timestamp time;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User user;

  @ManyToOne
  @JoinColumn(name = "id_update")
  private Update update;
}
