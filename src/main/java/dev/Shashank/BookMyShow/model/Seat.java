package dev.Shashank.BookMyShow.model;

import dev.Shashank.BookMyShow.model.Constats.SeatStatus;
import dev.Shashank.BookMyShow.model.Constats.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    private int r;
    private int c;
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;

    public Seat() {
    }

    public Seat(int row, int col, String seatNumber, SeatType seatType, SeatStatus status) {
        this.r = row;
        this.c = col;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = status;
    }
}
