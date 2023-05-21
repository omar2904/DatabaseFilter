package databasefilter.DatabaseFilter.repository;

import databasefilter.DatabaseFilter.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    @Query("SELECT h FROM Hotel h WHERE (:country IS NULL OR h.country = :country) AND (:city IS NULL OR h.city = :city) AND (:price IS NULL OR h.avgPrice >= :price) AND (:rating IS NULL OR h.rating >= :rating)")
    List<Hotel> findByFilter(@Param("country") String country,
                             @Param("city") String city,
                             @Param("price") Long price,
                             @Param("rating") String rating);

}
