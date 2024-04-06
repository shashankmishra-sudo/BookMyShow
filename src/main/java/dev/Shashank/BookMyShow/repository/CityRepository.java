package dev.Shashank.BookMyShow.repository;

import dev.Shashank.BookMyShow.model.City;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;


@Repository
public interface CityRepository extends JpaRepository<City,Integer> {
City findCityByName(String name);
}
