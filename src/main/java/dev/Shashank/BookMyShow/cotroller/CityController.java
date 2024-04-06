package dev.Shashank.BookMyShow.cotroller;

import dev.Shashank.BookMyShow.dto.CityRequestDTO;
import dev.Shashank.BookMyShow.model.City;
import dev.Shashank.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @PostMapping("/city")
    public ResponseEntity saveCity(@RequestBody CityRequestDTO cityRequestDTO) throws Exception {
        String cityName=cityRequestDTO.getName();
        if(cityName==null||cityName.isBlank()||cityName.isEmpty()){
            throw new Exception("Please enter CityName");
        }
       City savedCity=cityService.saveCity(cityName);
        return ResponseEntity.ok(savedCity);
    }

    @GetMapping("/city")
    public ResponseEntity getAllCities(){
        List<City> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);  // we would return cityResponseDTO
    }

    @GetMapping("/city/{id}")
    public ResponseEntity getCityById(@PathVariable("id") int id){
        return ResponseEntity.ok(
                cityService.getCityById(id)
                );
    }

    @GetMapping("/city/{name}")
    public ResponseEntity getCityByName(@PathVariable("name") String cityName){
        City city=cityService.getCityByName(cityName);
        return ResponseEntity.ok(
                city
        );
    }


}
