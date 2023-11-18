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


    @Query("SELECT ae FROM Catalog ae WHERE ae.auctionEndDate >= :currentDate " +
            "AND ae.auctionEndTime >= :currentTime ORDER BY ae.auctionEndTime ASC")
   Catalog findClosestToEndDateTime(
            @Param("currentDate") Date currentDate,
            @Param("currentTime") Time currentTime
    );
}
