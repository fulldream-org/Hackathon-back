package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
    Optional<Post> findByTitle(String title);

    Post updateById(UUID id);
}
