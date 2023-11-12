package com.ecommerce.CatalogServices;


import com.ecommerce.CatalogServices.Catalog;
import org.springframework.stereotype.Service;

import java.sql.*;
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
        return catalogRepo.save(item);
    }

    public List<Catalog> readAll() {
        return catalogRepo.findAll();
    }

    public Catalog read(Long itemId) {
        return catalogRepo.getById(itemId);

    }

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
}