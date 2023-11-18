package com.ecommerce.AuctionServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long>{

    Catalog findByItemId(Long item_id);
    //Catalog findByEndDateTimeAfterAndEndDateTimeIsNotNullOrderByEndDateTimeAsc();


    @Query("SELECT c FROM Catalog c WHERE c.auctionEndDate >= :currentDate " +
            "ORDER BY c.auctionEndDate ASC, c.auctionEndTime ASC")
   List<Catalog> findClosestToEndDateTime(
            @Param("currentDate") Date currentDate
    );
}
