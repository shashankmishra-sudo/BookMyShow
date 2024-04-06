package dev.Shashank.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity(name = "TheatreShow")
public class TheatreShow extends BaseModel{
    private LocalDateTime showStartTime;
    private  LocalDateTime showEndTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private  Auditorium auditorium;
    @OneToMany
    private List<ShowSeat> showSeats;
}
