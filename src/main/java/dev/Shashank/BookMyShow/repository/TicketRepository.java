package dev.Shashank.BookMyShow.repository;

import dev.Shashank.BookMyShow.model.ShowSeat;
import dev.Shashank.BookMyShow.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
