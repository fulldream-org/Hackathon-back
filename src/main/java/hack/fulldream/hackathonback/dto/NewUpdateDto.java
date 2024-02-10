package hack.fulldream.hackathonback.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class NewUpdateDto {
    private UUID id;
    private String title;
    private String content;
    private Date date;
    private UUID postId;
}
