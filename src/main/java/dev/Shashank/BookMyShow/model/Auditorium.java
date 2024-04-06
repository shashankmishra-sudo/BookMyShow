package dev.Shashank.BookMyShow.model;

import dev.Shashank.BookMyShow.model.Constats.AuditoriumFeature;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Auditorium extends BaseModel{
    private String name;
    private int capicity;
    @OneToMany
    private List<TheatreShow> show;
    @OneToMany
    private List<Seat> seats;
    @Enumerated(EnumType.STRING)
    private List<AuditoriumFeature> auditoriumFeatures;
}
