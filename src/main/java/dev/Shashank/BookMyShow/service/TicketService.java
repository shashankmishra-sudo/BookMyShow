package dev.Shashank.BookMyShow.service;

import dev.Shashank.BookMyShow.model.Constats.ShowSeatStatus;
import dev.Shashank.BookMyShow.model.Constats.TicketStatus;
import dev.Shashank.BookMyShow.model.ShowSeat;
import dev.Shashank.BookMyShow.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private ShowSeatService showSeatService;

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Integer> showSeatIds,int UserId) throws Exception {
        //Check if selected seat is availble
        for(int showSeatId:showSeatIds){
            ShowSeat showSeat=showSeatService.getShowSeat(showSeatId);
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.Available)){
                throw new Exception("Seat is not available");
            }
        }

//        Update the seat to locked state
        for(int showSeatId:showSeatIds){
            ShowSeat showSeat=showSeatService.getShowSeat(showSeatId);
            showSeat.setShowSeatStatus(ShowSeatStatus.Locked);
            showSeatService.saveShowSeat(showSeat);
        }

        //Initiate payment flow
        startPayment(showSeatIds);

        //        Update the seat to booked state
        for(int showSeatId:showSeatIds){
            ShowSeat showSeat=showSeatService.getShowSeat(showSeatId);
            showSeat.setShowSeatStatus(ShowSeatStatus.Booked);
            showSeatService.saveShowSeat(showSeat);
        }
    Ticket ticket=new Ticket();
        ShowSeat showSeat=showSeatService.getShowSeat(showSeatIds.get(0));
        ticket.setTicketStatus(TicketStatus.Booked);
        ticket.setAmount(showSeatIds.size()*1250);
        ticket.setBookTime(LocalDateTime.now());
        ticket.setShow(showSeat.getShow());
//        ticket.setShowSeat();


        return ticket;
    }

    public boolean startPayment(List<Integer> showSeatIds){return true;}
    public String greet(){
        return "Hello world";
    }
}
