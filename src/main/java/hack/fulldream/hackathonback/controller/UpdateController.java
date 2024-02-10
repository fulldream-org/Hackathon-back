package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.dto.NewUpdateDto;
import hack.fulldream.hackathonback.models.Update;
import hack.fulldream.hackathonback.service.UpdateService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/update")
public class UpdateController {
    private final UpdateService updateService;

    @GetMapping("/{postId}")
    public List<Update> getPostUpdates(@PathVariable UUID postId) {
        return updateService.findByPostId(postId);
    }

    @PutMapping
    public Update addUpdate(@RequestBody NewUpdateDto updateDto) {
        return updateService.save(updateService.toUpdate(updateDto));
    }
}
