package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RewardRepository extends JpaRepository<Reward, UUID> {
    Reward updateById(UUID id);
}
