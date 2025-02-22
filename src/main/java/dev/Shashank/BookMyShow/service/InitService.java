package dev.Shashank.BookMyShow.service;

import dev.Shashank.BookMyShow.model.*;
import dev.Shashank.BookMyShow.model.Constats.AuditoriumFeature;
import dev.Shashank.BookMyShow.model.Constats.SeatStatus;
import dev.Shashank.BookMyShow.model.Constats.SeatType;
import dev.Shashank.BookMyShow.model.Constats.ShowSeatStatus;
import dev.Shashank.BookMyShow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class InitService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;


    public boolean initialise() {
        City delhi = new City("Delhi");
        City bangalore = new City("Bangalore");
        City canberra = new City("Canberra");

        cityRepository.save(delhi);
        cityRepository.save(bangalore);
        cityRepository.save(canberra);

        City savedDelhi = cityRepository.findCityByName("Delhi");
        Theatre ashishTheatre = new Theatre("AshishMultiplex", "CP, Delhi");
        Theatre nithinTheatre = new Theatre("NithinIMAX", "Select City, Delhi");

        theatreRepository.save(ashishTheatre);
        theatreRepository.save(nithinTheatre);

        Theatre savedAshishTheatre = theatreRepository.findTheatreByName("AshishMultiplex");
        Theatre savedNithinTheatre = theatreRepository.findTheatreByName("NithinIMAX");

        List<Theatre> delhiTheatres = new ArrayList<>();
        delhiTheatres.add(savedAshishTheatre);
        delhiTheatres.add(savedNithinTheatre);
        savedDelhi.setTheatres(delhiTheatres);
        cityRepository.save(savedDelhi);


        for (int i = 1; i <= 5; i++) {
            Seat s = new Seat(i, i, i + "" + i, SeatType.Gold, SeatStatus.Available);
            seatRepository.save(s);
        }

        List<Seat> savedSeats = seatRepository.findAll(); // returns all the data of the table, "select * from table"

        Auditorium auditorium = new Auditorium();
        auditorium.setName("Audi01");
        auditorium.setCapicity(5);

        auditorium.setAuditoriumFeatures(List.of(AuditoriumFeature.Dolby, AuditoriumFeature.IMax));
        auditorium.setSeats(savedSeats);
        auditoriumRepository.save(auditorium);


        Auditorium savedAudi = auditoriumRepository.findAuditoriumByName("Audi01");
        Theatre savedTheatre = theatreRepository.findTheatreByName("AshishMultiplex");
        List<Auditorium> auditoriums = new ArrayList<>();
        auditoriums.add(savedAudi);
        savedTheatre.setAuditoriums(auditoriums);
        theatreRepository.save(savedTheatre);

        Movie movie = new Movie("Titanic", "best movie ever");
        movieRepository.save(movie);

        TheatreShow show = new TheatreShow();
        show.setShowStartTime(LocalDateTime.now());
        show.setShowEndTime(LocalDateTime.now().plusMinutes(180));
        show.setMovie(movieRepository.findMovieByName("Titanic"));
        show.setAuditorium(auditoriumRepository.findAuditoriumByName("Audi01"));

        showRepository.save(show);

        for (int i = 1; i <= 5; i++) {
            ShowSeat s = new ShowSeat(1251, showRepository.findById(1).get(), seatRepository.findSeatBySeatNumber(i + " " + i), ShowSeatStatus.Available);
            showSeatRepository.save(s);
        }


        return true;
    }

    }
