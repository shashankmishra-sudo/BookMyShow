package dev.Shashank.BookMyShow.repository;

import dev.Shashank.BookMyShow.model.Payment;
import dev.Shashank.BookMyShow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepositiry extends JpaRepository<Payment,Integer> {
}
