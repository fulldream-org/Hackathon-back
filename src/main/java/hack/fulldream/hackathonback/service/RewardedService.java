package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Donation;
import hack.fulldream.hackathonback.models.Reward;
import hack.fulldream.hackathonback.repository.RewardedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RewardedService {
    private final RewardedRepository rewardedRepository;
    private final RewardService rewardService;

    public void checkReward() {

    }

    public List<Reward> getGainedRewards(Donation donation, Double tiers) {
        return rewardService.getByIdAndTierLessThan(donation.getPost().getId(), tiers);
    }
}
