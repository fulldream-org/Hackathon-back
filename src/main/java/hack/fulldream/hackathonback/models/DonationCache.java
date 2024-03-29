package hack.fulldream.hackathonback.models;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "donation_cache")
public class DonationCache {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private Double amount;

  private String picture;

  @ManyToOne
  @JoinColumn(name = "id_user")
  private User user;

  @OneToOne
  @JoinColumn(name = "id_donation")
  private Donation donation;
}
