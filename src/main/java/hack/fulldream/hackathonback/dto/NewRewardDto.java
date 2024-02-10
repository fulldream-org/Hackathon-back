package hack.fulldream.hackathonback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class NewRewardDto {
    private String title;
    private String description;
    private Double tiers;
    private Date estimatedDeliveryDate;
    private UUID postId;
}
