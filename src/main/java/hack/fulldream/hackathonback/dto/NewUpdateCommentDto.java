package hack.fulldream.hackathonback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class NewUpdateCommentDto {
    private String value;
    private UUID userId;
    private UUID updateId;
    private Timestamp time;
}
