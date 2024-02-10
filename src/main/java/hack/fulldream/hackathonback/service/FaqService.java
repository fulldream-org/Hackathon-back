package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.dto.NewFaqDto;
import hack.fulldream.hackathonback.models.Faq;
import hack.fulldream.hackathonback.models.Post;
import hack.fulldream.hackathonback.repository.FaqRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class FaqService {
  private final FaqRepository faqRepository;
  private final PostService postService;

  public FaqService(FaqRepository faqRepository, PostService postService) {
    this.faqRepository = faqRepository;
      this.postService = postService;
  }

  public Faq updateById(Faq toSave) {
    return faqRepository.save(toSave);
  }

  public Optional<Faq> deleteFaq(UUID id) {
    Optional<Faq> toDelete = faqRepository.findById(id);
    if (toDelete.isPresent()) {
      faqRepository.deleteById(id);
    }
    return toDelete;
  }

  public List<Faq> findByPostId(UUID id) {
    return faqRepository.findAllByPostId(id);
  }

  public Faq save(Faq faq) {
    return faqRepository.save(faq);
  }

  public Faq toFaq(NewFaqDto faqDto) {
    Optional<Post> post = postService.findById(faqDto.getPostId());
    if (post.isPresent()) {
      Faq faq = new Faq();
      faq.setQuestion(faqDto.getQuestion());
      faq.setAnswer(faqDto.getAnswer());
      faq.setPost(post.get());
      return faq;
    }
    return null;
  }
}
