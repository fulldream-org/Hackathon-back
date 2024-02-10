package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.DonationCache;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DonationCacheRepository extends JpaRepository<DonationCache, UUID> {
}
