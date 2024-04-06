package dev.Shashank.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class City extends BaseModel{
    public City() {
    }
    private String name;
    public City(String name) {
        this.name = name;
    }

    @OneToMany
    private List<Theatre> theatres;
}
