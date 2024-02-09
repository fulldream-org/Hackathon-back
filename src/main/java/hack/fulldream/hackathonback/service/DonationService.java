package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Donation;
import hack.fulldream.hackathonback.repository.DonationRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class DonationService {
  public final DonationRepository donationRepository;

  public DonationService(DonationRepository donationRepository) {
    this.donationRepository = donationRepository;
  }

  public Optional<Donation> findDonationById(UUID id) {
    return donationRepository.findById(id);
  }

  public Donation saveDonation(Donation toSave) {
    return donationRepository.save(toSave);
  }

  public List<Donation> findAllDonation() {
    return donationRepository.findAll();
  }
}
