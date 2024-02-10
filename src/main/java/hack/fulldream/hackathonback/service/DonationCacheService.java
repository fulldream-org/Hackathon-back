package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.DonationCache;
import hack.fulldream.hackathonback.repository.DonationCacheRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DonationCacheService {
    public final DonationCacheRepository donationCacheRepository;

    public DonationCacheService(DonationCacheRepository donationRepository) {
        this.donationCacheRepository = donationRepository;
    }

    public Optional<DonationCache> findDonationCacheById(UUID id) {
        return donationCacheRepository.findById(id);
    }

    public DonationCache saveDonationCache(DonationCache toSave) {
        return donationCacheRepository.save(toSave);
    }

    public List<DonationCache> findAllDonationCache() {
        return donationCacheRepository.findAll();
    }
}
