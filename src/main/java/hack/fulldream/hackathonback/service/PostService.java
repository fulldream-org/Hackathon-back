package hack.fulldream.hackathonback.service;

import hack.fulldream.hackathonback.dto.NewPostDto;
import hack.fulldream.hackathonback.models.Post;
import hack.fulldream.hackathonback.repository.PostRepository;

import java.security.Principal;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService {
  private final PostRepository postRepository;
  private final UserService userService;

  public PostService(PostRepository postRepository, UserService userService) {
    this.postRepository = postRepository;
      this.userService = userService;
  }

  public Optional<Post> findById(UUID id) {
    return postRepository.findById(id);
  }

  public List<Post> findAll() {
    return postRepository.findAll();
  }

  public Page<Post> findAll(Pageable pageable) {
    return postRepository.findAll(pageable);
  }

  public Page<Post> findByTitle(Pageable pageable, String title) {
    return postRepository.findByTitleContainsIgnoreCase(pageable, title);
  }

  public Post save(Post toSave) {
    return postRepository.save(toSave);
  }

  public Post toPost(NewPostDto postDto, Principal principal) {
    if (userService.findByEmail(principal.getName()) != null){
      Post post = new Post();
      post.setTitle(postDto.getTitle());
      post.setGoal(postDto.getGoal());
      post.setCreationDate(Date.valueOf(LocalDate.now()));
      post.setDescription(postDto.getDescription());
      post.setEndDate(postDto.getEndDate());
      post.setUser(userService.findByEmail(principal.getName()));
      return post;
    }
    return null;
  }
}
