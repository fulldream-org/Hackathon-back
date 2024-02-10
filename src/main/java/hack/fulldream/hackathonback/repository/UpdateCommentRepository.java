package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.UpdateComment;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateCommentRepository extends JpaRepository<UpdateComment, UUID> {
    List<UpdateComment> findByUpdateId(UUID id);
}
