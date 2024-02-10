package hack.fulldream.hackathonback.controller;

import hack.fulldream.hackathonback.dto.NewDonationDto;
import hack.fulldream.hackathonback.models.Donation;
import hack.fulldream.hackathonback.service.DonationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/donation")
@CrossOrigin
public class DonationController {
    private final DonationService donationService;

    @GetMapping
    public Page<Donation> getAllDonations(Pageable pageable) {
        return donationService.findAll(pageable);
    }

    @GetMapping("/{postId}")
    public List<Donation> getDonationByPost(@PathVariable UUID postId) {
        return donationService.findByPostId(postId);
    }

    @PostMapping
    public Donation makeDonation(@RequestBody NewDonationDto donation) {
        return donationService.saveDonation(donationService.toDonation(donation));
    }
}
