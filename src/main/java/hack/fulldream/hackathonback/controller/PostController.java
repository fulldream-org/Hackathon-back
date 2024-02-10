package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.dto.NewPostDto;
import hack.fulldream.hackathonback.models.Post;
import hack.fulldream.hackathonback.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @GetMapping
    public Page<Post> getAllPost(Pageable pageable) {
        return postService.findAll(pageable);
    }

    @PostMapping
    public Post newPost(@RequestBody NewPostDto post, Principal principal) {
        return postService.save(postService.toPost(post, principal));
    }

    @GetMapping("/search")
    public Page<Post> findByTitle(@RequestParam String title, Pageable pageable) {
        return postService.findByTitle(pageable, title);
    }
}
