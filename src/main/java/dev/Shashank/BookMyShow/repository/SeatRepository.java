package dev.Shashank.BookMyShow.repository;

import dev.Shashank.BookMyShow.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer > {
    Seat findSeatBySeatNumber(String seatNumber);
}
