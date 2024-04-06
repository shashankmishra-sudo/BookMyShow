package dev.Shashank.BookMyShow.repository;

import dev.Shashank.BookMyShow.model.City;
import dev.Shashank.BookMyShow.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TheatreRepository extends JpaRepository<Theatre,Integer> {
    Theatre findTheatreByName(String theatreName);
}
