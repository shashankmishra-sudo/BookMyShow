package dev.Shashank.BookMyShow.model;

import dev.Shashank.BookMyShow.model.Constats.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends BaseModel{
    private String name;
    private String discription;
    @ManyToMany
    private List<Actor> actors;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> movieFeature;

    public Movie() {
    }

    public Movie(String name, String description) {
        this.name = name;
        this.discription = description;
    }
}
