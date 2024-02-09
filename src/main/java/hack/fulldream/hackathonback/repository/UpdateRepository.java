package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.Update;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdateRepository extends JpaRepository<Update, UUID> {
  Update updateById(UUID id);
}
