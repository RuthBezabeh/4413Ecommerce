package com.ecommerce.CatalogServices;


import com.ecommerce.CatalogServices.Catalog;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class CatalogServiceDAO {

    private static List<Catalog> catalogs=new ArrayList<>();
    public Catalog create(Catalog item) {
    catalogs.add(item);
    return item;
    }
    public List<Catalog> readAll(){
        return catalogs;
    }

    public Catalog read(String itemName){
        return catalogs.stream().filter(s -> s.getItemName() ==
                itemName).findFirst().orElse(null);

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
    public void delete(Long itemId){
       catalogs.removeIf(s -> s.getItemId() == itemId);
    }
}