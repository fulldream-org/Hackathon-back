package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.dto.NewUpdateDto;
import hack.fulldream.hackathonback.models.Post;
import hack.fulldream.hackathonback.models.Update;
import hack.fulldream.hackathonback.repository.UpdateRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UpdateService {
  private final UpdateRepository updateRepository;
  private final PostService postService;


  public UpdateService(UpdateRepository updateRepository, PostService postService) {
    this.updateRepository = updateRepository;
      this.postService = postService;
  }

  public Update save(Update toSave) {
    return updateRepository.save(toSave);
  }

  public List<Update> findAllUpdate() {
    return updateRepository.findAll();
  }

  public Optional<Update> deleteUpdate(UUID id) {
    Optional<Update> toDelete = updateRepository.findById(id);
    if (toDelete.isPresent()) {
      updateRepository.deleteById(id);
    }
    return toDelete;
  }

  public List<Update> findByPostId(UUID postId) {
    return updateRepository.findByPostId(postId);
  }

  public Optional<Update> findById(UUID id) {
    return updateRepository.findById(id);
  }

  public Update toUpdate(NewUpdateDto updateDto) {
    Optional<Post> post = postService.findById(updateDto.getPostId());

    if (post.isPresent()) {
      Update update = new Update();
      update.setId(updateDto.getId());
      update.setContent(update.getContent());
      update.setTitle(updateDto.getTitle());
      update.setPost(post.get());
      return update;
    }
    return null;
  }
}
