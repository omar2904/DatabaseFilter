package databasefilter.DatabaseFilter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Table(name = "Hotels")
public class Hotel {
    @Id
    @SequenceGenerator(
            name = "hotel_sequence",
            sequenceName = "hotel_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hotel_sequence"


    )
    private Long hotelId;
    private String hotelName;
    private String hotel_description;
    private String city;
    private String country;
    private String phone_number;
    private String rating;
    private Long avgPrice;
}
