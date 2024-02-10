package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.dto.NewDonationDto;
import hack.fulldream.hackathonback.models.Donation;
import hack.fulldream.hackathonback.models.DonationCache;
import hack.fulldream.hackathonback.models.Post;
import hack.fulldream.hackathonback.models.User;
import hack.fulldream.hackathonback.repository.DonationRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DonationService {
  public final DonationRepository donationRepository;
  private final DonationCacheService donationCacheService;
  private final UserService userService;
  private final PostService postService;

  public DonationService(DonationRepository donationRepository, DonationCacheService donationCacheService, UserService userService, PostService postService) {
    this.donationRepository = donationRepository;
      this.donationCacheService = donationCacheService;
      this.userService = userService;
      this.postService = postService;
  }

  public Optional<Donation> findDonationById(UUID id) {
    return donationRepository.findById(id);
  }

  public Page<Donation> findAll(Pageable pageable) {
    return donationRepository.findAll(pageable);
  }

  public Donation saveDonation(Donation toSave) {
    return donationRepository.save(toSave);
  }

  public List<Donation> findByPostId(UUID postId) {
    return donationRepository.findByPostId(postId);
  }

  public List<Donation> findAllDonation() {
    return donationRepository.findAll();
  }

  public Donation toDonation(NewDonationDto donationDto) {
    Optional<User> user = userService.findUserById(donationDto.getUserId());
    Optional<Post> post = postService.findById(donationDto.getPostId());

    if (user.isPresent() && post.isPresent()) {
      Donation donation = new Donation();
      donation.setDate(donationDto.getDate());
      donation.setDescription(donationDto.getDescription());
      donation.setIsAnonymous(donationDto.getIsAnonymous());
      donation.setUser(user.get());
      donation.setPost(post.get());
      DonationCache donationCache = donationCacheService.updateCache(
              donation,
              donationDto.getAmount()
      );

      return donation;
    }
    return null;
  }
}
