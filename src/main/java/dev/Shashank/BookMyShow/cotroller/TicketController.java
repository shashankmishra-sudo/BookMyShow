package dev.Shashank.BookMyShow.cotroller;

import dev.Shashank.BookMyShow.dto.bookTicketDTO;
import dev.Shashank.BookMyShow.model.Ticket;
import dev.Shashank.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping("/bookTicket")
    public ResponseEntity bookTicket(@RequestBody bookTicketDTO bookTicketDTO) throws Exception {
        //validate
        return ResponseEntity.ok(ticketService.bookTicket(bookTicketDTO.getShowSeatIds(),bookTicketDTO.getUserId()));
    }




    @GetMapping("/hello")
    public ResponseEntity greet(){
        String ans=ticketService.greet();
        return ResponseEntity.ok(ans);
    }


}
