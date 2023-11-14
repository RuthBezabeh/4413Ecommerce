package com.ecommerce.CatalogServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.ui.Model;

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

    @GetMapping(path = "/item/{itemId}")
    public Catalog getItem(@PathVariable Long item_id){
        return catalogServiceDAO.read(item_id);
    }

//    @GetMapping(path = "/item/{item_name}")
//    public List<Catalog> getItemName(@PathVariable String item_name){
//        return catalogServiceDAO.readName(item_name);
//    }
@GetMapping(path = "/Search", produces = MediaType.TEXT_HTML_VALUE)
public String getSearchPage(@RequestParam(name = "itemId") Long itemId,
                            @RequestParam(name = "itemName") String itemName,
                            Model model) {

   return catalogServiceDAO.getSearchPage(itemId,itemName,model);

}


}
