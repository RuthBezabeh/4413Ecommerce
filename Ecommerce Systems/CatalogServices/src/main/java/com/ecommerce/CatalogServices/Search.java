package com.ecommerce.CatalogServices;
import com.ecommerce.CatalogServices.*;
public interface Search {
    CatalogServiceDAO c=new CatalogServiceDAO();
    default void seatchItem(String itemName){
        c.read(itemName);
    }
}
