package com.ecommerce.CatalogServices;
import com.ecommerce.CatalogServices.*;

public interface Sell   {
    CatalogServiceDAO c = new CatalogServiceDAO();
    default void sellItem(Long id){
    c.delete(id);
    }

}
