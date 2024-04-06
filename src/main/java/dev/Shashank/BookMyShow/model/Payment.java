package dev.Shashank.BookMyShow.model;

import dev.Shashank.BookMyShow.model.Constats.PaymentMode;
import dev.Shashank.BookMyShow.model.Constats.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Payment extends BaseModel{
    private LocalDateTime paymetTime;
    private int amount;
    private String referanceId;
    @ManyToOne
    private Ticket ticket;
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;
}
