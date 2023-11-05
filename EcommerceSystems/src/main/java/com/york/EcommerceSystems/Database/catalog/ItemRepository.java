package com.york.EcommerceSystems.Database.catalog;

import com.york.EcommerceSystems.Database.catalog.Item;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ItemRepository extends JpaRepository<Item, Long>{

}
