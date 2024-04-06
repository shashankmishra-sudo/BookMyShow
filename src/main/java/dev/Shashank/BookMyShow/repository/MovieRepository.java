package dev.Shashank.BookMyShow.repository;

import dev.Shashank.BookMyShow.model.Auditorium;
import dev.Shashank.BookMyShow.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    Movie findMovieByName(String movieName);
}
