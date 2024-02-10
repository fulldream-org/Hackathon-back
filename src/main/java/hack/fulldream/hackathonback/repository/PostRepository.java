package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.Post;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, UUID> {
  Page<Post> findByTitleContainsIgnoreCase(Pageable pageable, String title);
}
