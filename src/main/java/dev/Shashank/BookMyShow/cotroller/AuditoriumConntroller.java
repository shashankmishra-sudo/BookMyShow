package dev.Shashank.BookMyShow.cotroller;

import dev.Shashank.BookMyShow.dto.AuditoriumRequestDTO;
import dev.Shashank.BookMyShow.model.Auditorium;
import dev.Shashank.BookMyShow.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuditoriumConntroller {
    @Autowired
    private AuditoriumService auditoriumService;

    @PostMapping("/auditorium")
    public ResponseEntity saveAuditorium(@RequestBody AuditoriumRequestDTO auditoriumRequestDTO){
       Auditorium savedAudi= auditoriumService.addAuditorium(
                auditoriumRequestDTO.getName(),
                auditoriumRequestDTO.getCapicity(),
                auditoriumRequestDTO.getTheatreId()
        );
       return ResponseEntity.ok(
               savedAudi
       );
    }
}
