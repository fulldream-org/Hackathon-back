package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.models.Post;
import hack.fulldream.hackathonback.repository.PostRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class PostService {
  public final PostRepository postRepository;

  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public Optional<Post> findById(UUID id) {
    return postRepository.findById(id);
  }

  public List<Post> findAll() {
    return postRepository.findAll();
  }

  public Optional<Post> findByTitle(String title) {
    return postRepository.findByTitle(title);
  }

  public Post updatePostById(UUID id) {
    return postRepository.updateById(id);
  }
}
