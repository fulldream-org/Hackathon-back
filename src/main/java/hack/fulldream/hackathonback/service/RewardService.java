package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Reward;
import hack.fulldream.hackathonback.repository.RewardRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class RewardService {
  public final RewardRepository rewardRepository;

  public RewardService(RewardRepository rewardRepository) {
    this.rewardRepository = rewardRepository;
  }

  public Reward save(Reward reward) {
    return rewardRepository.save(reward);
  }

  public Optional<Reward> deleteReward(UUID id) {
    Optional<Reward> toDelete = rewardRepository.findById(id);
    if (toDelete.isPresent()) {
      rewardRepository.deleteById(id);
    }
    return toDelete;
  }

  public Reward updateReward(UUID id) {
    return rewardRepository.updateById(id);
  }
}
