package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.Faq;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaqRepository extends JpaRepository<Faq, UUID> {
}
