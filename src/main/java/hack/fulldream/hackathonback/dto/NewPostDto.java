package hack.fulldream.hackathonback.dto;

import hack.fulldream.hackathonback.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class NewPostDto {
    private String title;
    private String description;
    private Double goal;
    private Date endDate;
}
