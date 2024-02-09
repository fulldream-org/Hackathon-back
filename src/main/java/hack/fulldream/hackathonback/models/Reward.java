package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Reward {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private Double tiers;
  private String title;
  private String description;
  private Date estimatedDeliveryDate;

  @ManyToOne
  @JoinColumn(name = "id_post")
  private Post post;
}
