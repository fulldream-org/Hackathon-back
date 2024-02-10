package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.dto.NewRewardDto;
import hack.fulldream.hackathonback.models.Reward;
import hack.fulldream.hackathonback.service.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/reward")
public class RewardController {
    private final RewardService rewardService;

    @GetMapping("/{postId}")
    public List<Reward> getPostRewards(@PathVariable UUID postId) {
        return rewardService.findByPostId(postId);
    }

    @PostMapping
    public Reward addReward(NewRewardDto rewardDto) {
        return rewardService.save(rewardService.toReward(rewardDto));
    }
}
