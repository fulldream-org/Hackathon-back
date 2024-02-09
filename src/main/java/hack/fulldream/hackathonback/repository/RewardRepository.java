package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.Reward;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<Reward, UUID> {
  Reward updateById(UUID id);
}
