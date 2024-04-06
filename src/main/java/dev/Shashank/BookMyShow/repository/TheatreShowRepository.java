package dev.Shashank.BookMyShow.repository;

import dev.Shashank.BookMyShow.model.Theatre;
import dev.Shashank.BookMyShow.model.TheatreShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TheatreShowRepository extends JpaRepository<Theatre,Integer> {
}
