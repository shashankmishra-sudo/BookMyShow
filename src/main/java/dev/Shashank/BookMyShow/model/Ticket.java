package dev.Shashank.BookMyShow.model;

import dev.Shashank.BookMyShow.model.Constats.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Ticket extends BaseModel{
    private LocalDateTime bookTime;
    private int amount;
    @OneToMany
    private List<ShowSeat> showSeat;
    @ManyToOne
    private TheatreShow show;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;

}
