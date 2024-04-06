package dev.Shashank.BookMyShow.repository;

import dev.Shashank.BookMyShow.model.Auditorium;
import dev.Shashank.BookMyShow.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium,Integer> {
    Auditorium findAuditoriumByName(String name);
}
