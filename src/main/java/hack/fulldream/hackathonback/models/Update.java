package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Update {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String title;
  private String content;

  @ManyToOne
  @JoinColumn(name = "id_post")
  private Post post;
}
