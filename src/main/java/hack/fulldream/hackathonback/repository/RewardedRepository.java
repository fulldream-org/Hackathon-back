package hack.fulldream.hackathonback.repository;


import hack.fulldream.hackathonback.models.Reward;
import hack.fulldream.hackathonback.models.Rewarded;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RewardedRepository extends JpaRepository<Rewarded, UUID> {
}
