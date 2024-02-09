package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.Update;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UpdateRepository extends JpaRepository<Update, UUID> {
    Update updateById(UUID id);
}
