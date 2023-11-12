package com.ecommerce.CatalogServices;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CatalogController {
    private Sell s;
    private Search s1;
    private CatalogServiceDAO c;
    @PostMapping(value = "/")
    public Catalog createItem(@RequestBody Catalog catalog){
        return c.create(catalog);
    }
    @GetMapping(value = "/items")
    public List<Catalog> getAllItems(){
        return c.readAll();
    }
@GetMapping(value="item/{itemName}")
    public Catalog getItem(String itemName){
return c.read(itemName);
    }

}
