package dev.Shashank.BookMyShow.repository;

import dev.Shashank.BookMyShow.model.Actor;
import dev.Shashank.BookMyShow.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
}
