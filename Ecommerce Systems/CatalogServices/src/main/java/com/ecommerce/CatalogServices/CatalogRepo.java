package com.ecommerce.CatalogServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface CatalogRepo extends JpaRepository <Catalog, Long> {

}
