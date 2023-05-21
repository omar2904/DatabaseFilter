package databasefilter.DatabaseFilter.controller;

import databasefilter.DatabaseFilter.entity.Hotel;
import databasefilter.DatabaseFilter.modals.HotelDTO;
import databasefilter.DatabaseFilter.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;


    private final HotelDTO hotelDTO;

    @Autowired
    public HotelController(HotelService hotelService, HotelDTO hotelDTO) {
        this.hotelService = hotelService;
        this.hotelDTO = hotelDTO;
    }

    @GetMapping()
    public ResponseEntity<List<Hotel>> findByFilters(@RequestParam(name = "country", required = false) String country,
                                                     @RequestParam(name = "city", required = false) String city,
                                                         @RequestParam(name = "price", required = false) Long price,
                                                         @RequestParam(name = "rating", required = false) String rating
                                                         ) {

        hotelDTO.setCity(city);
        hotelDTO.setCountry(country);
        hotelDTO.setAvgPrice(price);
        hotelDTO.setRating(rating);
        List<Hotel> hotels = hotelService.findByFilters(hotelDTO);
        return new ResponseEntity<>(hotels, HttpStatus.OK);

    }

}
