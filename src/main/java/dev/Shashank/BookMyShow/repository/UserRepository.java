package dev.Shashank.BookMyShow.repository;

import dev.Shashank.BookMyShow.model.Actor;
import dev.Shashank.BookMyShow.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByEmail(String email);
}
