package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.Donation;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonationRepository extends JpaRepository<Donation, UUID> {
    List<Donation> findByPostId(UUID postId);
}
