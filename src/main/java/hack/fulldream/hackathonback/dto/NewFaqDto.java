package hack.fulldream.hackathonback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class NewFaqDto {
    private String question;
    private String answer;
    private UUID postId;
}
