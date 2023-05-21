package databasefilter.DatabaseFilter.modals;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {

    String hotelName;
    String hotel_description;
    String city;
    String country;
    String phone_number;
    String rating;
    Long avgPrice;

}
