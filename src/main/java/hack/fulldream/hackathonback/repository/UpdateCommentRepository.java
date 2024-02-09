package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.UpdateComment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdateCommentRepository extends JpaRepository<UpdateComment, UUID> {
  UpdateComment updateById(UUID id);
}
