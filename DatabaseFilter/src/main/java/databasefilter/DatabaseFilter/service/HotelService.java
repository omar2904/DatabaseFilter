package databasefilter.DatabaseFilter.service;

import databasefilter.DatabaseFilter.entity.Hotel;
import databasefilter.DatabaseFilter.modals.HotelDTO;
import databasefilter.DatabaseFilter.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> findByFilters(HotelDTO hotelDTO) {
        List<Hotel> h = hotelRepository.findByFilter(hotelDTO.getCountry(), hotelDTO.getCity(), hotelDTO.getAvgPrice(), hotelDTO.getRating());
        return h;

    }
}
