package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Post;
import hack.fulldream.hackathonback.models.DonationCache;
import hack.fulldream.hackathonback.repository.DonationCacheRepository;
import hack.fulldream.hackathonback.repository.PostRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
@Service
public class PredictionService {

    private final PostRepository postRepository;
    private final DonationCacheRepository donationCacheRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public PredictionService(PostRepository postRepository, DonationCacheRepository donationCacheRepository, EntityManager entityManager) {
        this.postRepository = postRepository;
        this.donationCacheRepository = donationCacheRepository;
        this.entityManager = entityManager;
    }

    public Date predictTargetReachDate(UUID postId) {
        Optional<Post> post = postRepository.findById(postId);

        if (post.isEmpty()) {
            throw new RuntimeException("Post with ID " + postId + " not found.");
        }

        // Calculate total donated amount
        Double totalDonations = donationCacheRepository.findAllById(Collections.singleton(postId))
                .stream().mapToDouble(DonationCache::getAmount).sum();

        if (totalDonations == 0.0) {
            return null; // Indicate insufficient data for prediction
        }

        // Calculate average daily donations and days since creation
        long daysSinceCreation = ChronoUnit.DAYS.between(post.get().getCreationDate().toLocalDate(), LocalDate.now());
        double averageDailyDonations = totalDonations / daysSinceCreation;

        // Handle case where no days have passed
        if (daysSinceCreation == 0) {
            // Use the current date as a starting point
            return post.get().getCreationDate();
        }

        // Calculate remaining amount and estimated days remaining
        double remainingAmount = post.get().getGoal() - totalDonations;
        double estimatedDaysRemaining = Math.ceil(remainingAmount / averageDailyDonations);

        // Use JPA native query for PostgreSQL-specific interval addition
        String sql = "SELECT creation_date + interval '" + estimatedDaysRemaining + " days' AS target_reach_date FROM \"post\" WHERE id = :postId";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("postId", postId);

        return (Date) query.getSingleResult();
    }
}
