/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.repository;

import com.joi.api.catalog.entity.ProductFlat;
import java.util.Collection;
import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ramy
 */
@Repository
public interface ProductFlatRepository extends JpaRepository<ProductFlat, Integer> {

    @Cacheable(value = "MobileHomePageCatalog", key = "#storeId")
    @Query(" select p from ProductFlat p where p.categoryShowOnMobileHomePage =true and "
            + "p.productShowOnHomePage=true and p.storeId=:storeId order by p.categoryId asc , p.productDisplayOrder asc")
    List<ProductFlat> findMobileHomePageCatalog(@Param("storeId")int storeId);

    @Cacheable(value = "ProductsByCategoryandStoreId", key = "#storeId + #categoyId")
    @Query(" select p from ProductFlat p where p.categoryId=:categoryId and p.storeId=:storeId order by p.productDisplayOrder asc")
    List<ProductFlat> findProductsByCategoryandStoreId(@Param("storeId") int storeId, @Param("categoryId") int categoryId);

    @Cacheable(value = "ProductsByStoreId", key = "#storeId")
    @Query(" select p from ProductFlat p where p.storeId=:storeId order by p.productId asc")
    List<ProductFlat> findProductsByStoreId(@Param("storeId") int storeId);

    
}
