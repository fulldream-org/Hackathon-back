package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Donation;
import hack.fulldream.hackathonback.models.DonationCache;
import hack.fulldream.hackathonback.models.Post;
import hack.fulldream.hackathonback.models.User;
import hack.fulldream.hackathonback.repository.DonationCacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DonationCacheService {
    private final UserService userService;
    private final DonationCacheRepository donationCacheRepository;
    private final PostService postService;

    private DonationCache getRecentDonation(UUID userId, UUID postId) {
        List<DonationCache> donationCacheList = donationCacheRepository
                .findByUserIdAndDonation_PostId(userId, postId)
                .stream()
                .sorted(
                        Comparator
                                .comparing(donationCache -> donationCache
                                        .getDonation()
                                        .getDate()
                                )
                ).toList();
        return donationCacheList.isEmpty() ? null : donationCacheList.get(0);
    }

    private Double getRecentDonationValue(UUID userId, UUID postId) {
        DonationCache recentDonationCache = getRecentDonation(userId, postId);
        return recentDonationCache == null ? 0d : recentDonationCache.getAmount();
    }

    public DonationCache updateCache(Donation donation, Double donationValue) {
        Double recentDonationValue = getRecentDonationValue(
                donation
                        .getUser()
                        .getId(),
                donation
                        .getPost()
                        .getId()
        );
        User user = donation.getUser();
        DonationCache donationCache = new DonationCache();
        donationCache.setDonation(donation);
        donationCache.setUser(user);
        donationCache.setAmount(recentDonationValue + donationValue);
        return donationCacheRepository.save(donationCache);
    }
}
