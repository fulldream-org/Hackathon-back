package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.dto.NewFaqDto;
import hack.fulldream.hackathonback.models.Faq;
import hack.fulldream.hackathonback.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/faq")
public class FaqController {
    private final FaqService faqService;

    @GetMapping("/{postId}")
    public List<Faq> getByPostId(@PathVariable UUID postId) {
        return faqService.findByPostId(postId);
    }

    @PostMapping
    public Faq saveFaq(@RequestBody NewFaqDto faqDto) {
        return faqService.save(faqService.toFaq(faqDto));
    }
}
