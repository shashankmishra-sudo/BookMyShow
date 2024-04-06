package dev.Shashank.BookMyShow.service;

import dev.Shashank.BookMyShow.dto.AuditoriumRequestDTO;
import dev.Shashank.BookMyShow.model.Auditorium;
import dev.Shashank.BookMyShow.model.Theatre;
import dev.Shashank.BookMyShow.repository.AuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditoriumService {
    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private TheatreService theatreService;

    public Auditorium addAuditorium(String name,int capicity,int theatreId){
        Auditorium auditorium=new Auditorium();
        auditorium.setName(name);
        auditorium.setCapicity(capicity);
        Auditorium savedAuditorium=auditoriumRepository.save(auditorium);

        Theatre theatre=theatreService.getTheatrebyId(theatreId);
        List<Auditorium> auditoriums=theatre.getAuditoriums();
        auditoriums.add(savedAuditorium);
        theatre.setAuditoriums(auditoriums);
        theatreService.createTheatre(theatre);
        return savedAuditorium;
    }
}
