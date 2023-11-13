package com.ecommerce.PaymentServices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Long>{

    Catalog findByItemId(Long item_id);
}
