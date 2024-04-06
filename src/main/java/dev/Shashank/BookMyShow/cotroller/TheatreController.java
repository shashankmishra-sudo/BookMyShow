package dev.Shashank.BookMyShow.cotroller;

import dev.Shashank.BookMyShow.dto.TheatreRequestDTO;
import dev.Shashank.BookMyShow.model.Theatre;
import dev.Shashank.BookMyShow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @PostMapping("/createTheatre")
    public ResponseEntity createTheare(@RequestBody TheatreRequestDTO theatreRequestDTO){
       return ResponseEntity.ok(theatreService.createTheare(
               theatreRequestDTO.getName(),
               theatreRequestDTO.getAddress(),
               theatreRequestDTO.getCityId())
       );
    }
}
