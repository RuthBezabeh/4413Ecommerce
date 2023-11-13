package com.ecommerce.CatalogServices;


import com.ecommerce.CatalogServices.Catalog;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogServiceDAO {
    private final CatalogRepo catalogRepo;

    public CatalogServiceDAO(final CatalogRepo catalogRepo) {
        this.catalogRepo = catalogRepo;
        System.out.println("service created or rep");
    }

    //private static List<Catalog> catalogs=new ArrayList<>();
    public Catalog create(Catalog item) {
        //1. Set time for start date, time, end time, and end date
        setCatalogueTimeInfo(item);
        //2. Seller exists as user; now want to upload item into catalogue
        return catalogRepo.save(item);
    }

    public List<Catalog> readAll() {
        return catalogRepo.findAll();
    }

    public Catalog read(Long itemId) {
        return catalogRepo.findById(itemId).get();

    }

//    public List<Catalog> readName (String item_name){
//        return catalogRepo.findByItemName(item_name);
//
//    }


    //    public void update(Long itemId,Catalog item){
//        for (int i = 0; i < catalogs.size(); i++) {
//            Catalog c = catalogs.get(i);
//            if (c.getItemId() == itemId) {
//                c.setItemName(item.getItemName());
//                c.setAuctionType(item.getDescription());
//
//                return c;
//            }
//        }
//
//        return null;
//
//    }

    public void delete(Long itemId) {
        catalogRepo.deleteById(itemId);
    }

    public void soldItem(){
    }

    //Set time for start date, time, end time, and end date
    private void setCatalogueTimeInfo(Catalog item) {
        //2. Obtain Start time and Start Date
        item.setAuction_start_time(LocalTime.now());
        item.setAuction_start_date(LocalDate.now());

        //3. Obtain end time and end date
        //Converts start date and start time to a date-time object
        LocalDateTime startDateTime = LocalDateTime.of(item.getAuction_start_date(), item.getAuction_start_time());

        //converts duration into seperate parts; hours, min, seconds
        int durationHours = item.getAuction_duration().getHour();
        int durationMinutes = item.getAuction_duration().getMinute();
        int durationSeconds = item.getAuction_duration().getSecond();

        //creates a duration object using the hr, min, sc
        Duration duration = Duration.ofHours(durationHours)
                .plusMinutes(durationMinutes)
                .plusSeconds(durationSeconds);

        //extracting time by adding duration
        LocalDateTime endDateTime = startDateTime.plus(duration);

        //setting end date and time
        item.setAuction_end_date(endDateTime.toLocalDate());
        item.setAuction_end_time(endDateTime.toLocalTime());
    }
}