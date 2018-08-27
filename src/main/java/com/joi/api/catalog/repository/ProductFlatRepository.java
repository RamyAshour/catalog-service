/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.repository;

import com.joi.api.catalog.entity.ProductFlat;
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

    @Cacheable(value = "findMobileHomePageCatalog", key = "#p0")
    @Query(" select p from ProductFlat p where p.categoryShowOnMobileHomePage =true and "
            + "p.productShowOnHomePage=true and p.storeId=:storeId order by p.categoryId asc , p.productDisplayOrder asc")
    List<ProductFlat> findMobileHomePageCatalog(@Param("storeId") int storeId);

    @Cacheable(value = "findProductsByCategoryandStoreId", key = "#p0")
    @Query(" select p from ProductFlat p where p.categoryId=:categoryId and p.storeId=:storeId order by p.productDisplayOrder asc")
    List<ProductFlat> findProductsByCategoryandStoreId(@Param("storeId") int storeId, @Param("categoryId") int categoryId);

    @Cacheable(value = "findProductsByStoreId", key = "#p0")
    @Query(" select p from ProductFlat p where p.storeId=:storeId  order by p.productId asc")
    List<ProductFlat> findProductsByStoreId(@Param("storeId") int storeId);

//    @Cacheable(value = "findProductsByStoreIdForSegmentifyEn", key = "#p0")
//    @Query("select new ProductFlat(p.id, p.productId, p.productSku, p.productEnName,"
//            + " p.productEnShortDescription,"
//            + " p.productPrice, p.productPictureUrl, p.categoryId, p.categoryEnName, "
//            + " p.categoryEnDescription,p.storeId,1 ) from ProductFlat  p where p.id in (select min(p1.id) from ProductFlat p1 where p1.storeId=:storeId group by p1.productId)")
//    List<ProductFlat> findProductsByStoreIdForSegmentifyEn(@Param("storeId") int storeId);
    @Cacheable(value = "findProductsBasicDataByStoreIdEn", key = "#p0")
    @Query("select new ProductFlat(p.id, p.productId, p.productSku, p.productEnName,"
            + " p.productEnShortDescription,"
            + " p.productPrice, p.productPictureUrl,productSlug, p.categoryId, p.categoryEnName, "
            + " p.categoryEnDescription,p.storeId,1 ) from ProductFlat  p where p.id in (select min(p1.id) from ProductFlat p1 where p1.storeId=:storeId group by p1.productId)")
    List<ProductFlat> findProductsBasicDataByStoreIdEn(@Param("storeId") int storeId);

    @Cacheable(value = "findProductsBasicDataByStoreIdAr", key = "#p0")
    @Query("select new ProductFlat(p.id, p.productId, p.productSku, p.productArName,"
            + " p.productArShortDescription,"
            + " p.productPrice, p.productPictureUrl,productSlug, p.categoryId, p.categoryArName, "
            + " p.categoryArDescription,p.storeId,2 ) from ProductFlat  p where p.id in (select min(p1.id) from ProductFlat p1 where p1.storeId=:storeId group by p1.productId)")
    List<ProductFlat> findProductsBasicDataByStoreIdAr(@Param("storeId") int storeId);

//    @Cacheable(value = "findProductsByStoreIdForSegmentifyAr", key = "#p0")
//    @Query("select new ProductFlat(p.id, p.productId, p.productSku, p.productArName,"
//            + " p.productArShortDescription,"
//            + " p.productPrice, p.productPictureUrl, p.categoryId, p.categoryArName, "
//            + " p.categoryArDescription,p.storeId,2 ) from ProductFlat  p where p.id in (select min(p1.id) from ProductFlat p1 where p1.storeId=:storeId group by p1.productId)")
//    List<ProductFlat> findProductsByStoreIdForSegmentifyAr(@Param("storeId") int storeId);
    List<ProductFlat> findAllByProductIdAndStoreId(int productId, int storeId);

    @Query(" select distinct p.categoryArName from ProductFlat p where p.storeId=:storeId  and p.productId=:productId")
    List<String> findCategoryArNameByStoreIdAndProductId(@Param("storeId") int storeId, @Param("productId") int productId);

    @Query(" select distinct p.categoryEnName from ProductFlat p where p.storeId=:storeId  and p.productId=:productId")
    List<String> findCategoryEnNameByStoreIdAndProductId(@Param("storeId") int storeId, @Param("productId") int productId);

    @Cacheable(value = "findProductsAndCategoriesByStoreId", key = "#p0")
    @Query("select new ProductFlat(p.productId,p.categoryId,p.categoryEnName,p.categoryArName)"
            + " from ProductFlat p where p.storeId=:storeId")
    List<ProductFlat> findProductsAndCategoriesByStoreId(@Param("storeId") int storeId);
}
