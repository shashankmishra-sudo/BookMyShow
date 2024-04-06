package dev.Shashank.BookMyShow.service;

import dev.Shashank.BookMyShow.model.City;
import dev.Shashank.BookMyShow.model.Theatre;
import dev.Shashank.BookMyShow.model.TheatreShow;
import dev.Shashank.BookMyShow.repository.CityRepository;
import dev.Shashank.BookMyShow.repository.TheatreRepository;
import dev.Shashank.BookMyShow.repository.TheatreShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private CityService cityService;


    public Theatre createTheare(String name, String address,int cityId){
        Theatre theatre=new Theatre();
        theatre.setAddress(address);
        theatre.setName(name);
        Theatre savedTheatre=theatreRepository.save(theatre);

        City city=cityService.getCityById(cityId);
        List<Theatre> theatres=city.getTheatres();
        theatres.add(savedTheatre);
        city.setTheatres(theatres);
        cityService.saveCity(city);

        return savedTheatre;
    }
    public Theatre createTheatre(Theatre theatre){
      Theatre savedTheatre=theatreRepository.save(theatre);
      return savedTheatre;
    }
    public Theatre getTheatrebyId(int id){
        return theatreRepository.findById(id).get();
    }


}
