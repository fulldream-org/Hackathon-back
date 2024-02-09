package hack.fulldream.hackathonback.repository;

import hack.fulldream.hackathonback.models.Faq;
import hack.fulldream.hackathonback.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FaqRepository extends JpaRepository<Faq, UUID> {
    Faq updateById(UUID id);
}
