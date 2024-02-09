package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Faq;
import hack.fulldream.hackathonback.repository.FaqRepository;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class FaqService {
  public final FaqRepository faqRepository;

  public FaqService(FaqRepository faqRepository) {
    this.faqRepository = faqRepository;
  }

  public Faq updateById(UUID id) {
    return faqRepository.updateById(id);
  }

  public Optional<Faq> deleteFaq(UUID id) {
    Optional<Faq> toDelete = faqRepository.findById(id);
    if (toDelete.isPresent()) {
      faqRepository.deleteById(id);
    }
    return toDelete;
  }
}
