package dev.Shashank.BookMyShow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class bookTicketDTO {
    private List<Integer> showSeatIds;
    private Integer userId;
}
