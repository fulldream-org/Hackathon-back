package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Faq {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String question;
  private String answer;

  @ManyToOne
  @JoinColumn(name = "id_post")
  private Post post;
}
