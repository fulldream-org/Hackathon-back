package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
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

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User user;

  @ManyToOne
  @JoinColumn(name = "id_update")
  private Update update;
}
