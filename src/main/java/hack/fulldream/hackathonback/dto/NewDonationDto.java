package hack.fulldream.hackathonback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class NewDonationDto {
    private String description;
    private Date date;
    private Boolean isAnonymous;
    private UUID postId;
    private UUID userId;
    private Double amount;
}
