package dev.Shashank.BookMyShow.dto;

import dev.Shashank.BookMyShow.model.Constats.AuditoriumFeature;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuditoriumRequestDTO {
    private String name;
    private int capicity;
    private int theatreId;
}
