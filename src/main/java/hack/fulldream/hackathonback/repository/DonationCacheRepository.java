package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.DonationCache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DonationCacheRepository extends JpaRepository<DonationCache, UUID> {
    List<DonationCache> findByUserIdAndDonation_PostId(UUID userId, UUID postId);
}
