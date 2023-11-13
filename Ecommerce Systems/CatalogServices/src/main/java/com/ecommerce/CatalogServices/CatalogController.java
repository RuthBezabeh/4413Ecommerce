package com.ecommerce.CatalogServices;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("ecommerce/catalog")
public class CatalogController {

    private final CatalogServiceDAO catalogServiceDAO;
    @Autowired
    public CatalogController (CatalogServiceDAO catalogServiceDAO){
        this.catalogServiceDAO=catalogServiceDAO;
    }
    @PostMapping(path = "/")
    public Catalog createItem(@RequestBody Catalog catalog){
        return catalogServiceDAO.create(catalog);
    }
    @GetMapping(path = "/items")
    public List<Catalog> getAllItems(){
        return catalogServiceDAO.readAll();
    }
@GetMapping(path = "/item/{item_id}")
    public Catalog getItem(@PathVariable Long item_id){
return catalogServiceDAO.read(item_id);
    }
//    @GetMapping(path = "/item/{item_name}")
//    public List<Catalog> getItemName(@PathVariable String item_name){
//        return catalogServiceDAO.readName(item_name);
//    }


}
