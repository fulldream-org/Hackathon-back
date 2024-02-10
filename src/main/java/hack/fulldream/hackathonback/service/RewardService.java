package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.dto.NewRewardDto;
import hack.fulldream.hackathonback.models.Post;
import hack.fulldream.hackathonback.models.Reward;
import hack.fulldream.hackathonback.repository.RewardRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class RewardService {
  public final RewardRepository rewardRepository;
  public final PostService postService;

  public RewardService(RewardRepository rewardRepository, PostService postService) {
    this.rewardRepository = rewardRepository;
      this.postService = postService;
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

  public List<Reward> findByPostId(UUID postId) {
    return rewardRepository.findByPostId(postId);
  }

  public Reward toReward(NewRewardDto rewardDto) {
    Optional<Post> post = postService.findById(rewardDto.getPostId());

    if (post.isPresent()) {
      Reward reward = new Reward();
      reward.setDescription(rewardDto.getDescription());
      reward.setTitle(rewardDto.getTitle());
      reward.setTiers(rewardDto.getTiers());
      reward.setEstimatedDeliveryDate(rewardDto.getEstimatedDeliveryDate());
      reward.setPost(post.get());
      return reward;
    }
    return null;
  }

  public List<Reward> getByIdAndTierLessThan(UUID id, Double tier) {
    return rewardRepository.findByPostIdAndTiersLessThanEqual(id, tier);
  }
}
