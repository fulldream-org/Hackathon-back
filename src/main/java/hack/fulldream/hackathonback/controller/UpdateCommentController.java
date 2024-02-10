package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.dto.NewUpdateCommentDto;
import hack.fulldream.hackathonback.models.UpdateComment;
import hack.fulldream.hackathonback.service.UpdateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/update-comment")
public class UpdateCommentController {
    private final UpdateCommentService updateCommentService;

    @GetMapping("/{updateId}")
    public List<UpdateComment> getUpdateComment(@PathVariable UUID updateId) {
        return updateCommentService.findByUpdateId(updateId);
    }

    @PostMapping
    public UpdateComment comment(@RequestBody NewUpdateCommentDto updateCommentDto) {
        return updateCommentService.save(updateCommentService.toUpdateComment(updateCommentDto));
    }
}
