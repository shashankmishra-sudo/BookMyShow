package dev.Shashank.BookMyShow.service;

import dev.Shashank.BookMyShow.model.City;
import dev.Shashank.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;
    public City saveCity(String name){
        City city=new City();
        city.setName(name);

        return cityRepository.save(city);
    }
    public City saveCity(City city){
        return cityRepository.save(city);
    }
    
    public City getCityById(int cityId){
        return cityRepository.findById(cityId).get();
    }

    public City getCityByName(String cityName){
        City city=cityRepository.findCityByName(cityName);
        return city;
    }

    public List<City> getAllCities(){
        return cityRepository.findAll();
    }
}
