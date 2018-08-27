/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.service;

import com.joi.api.catalog.Global;
import com.joi.api.catalog.entity.ProductFlat;
import com.joi.api.catalog.repository.ProductFlatRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ramy
 */
@Service
public class ProductFlatService implements IProductFlatService {
    
    @Autowired
    ProductFlatRepository productFlatRepository;
    
    public List<ProductFlat> getMobileHomePageCatalog(int storeId) {
        
        return productFlatRepository.findMobileHomePageCatalog(storeId);
    }
    
    @Override
    public List<ProductFlat> getProductsByCategory(int storeId, int categoryId) {
        
        return productFlatRepository.findProductsByCategoryandStoreId(storeId, categoryId);
    }
    
    @Cacheable(value = "getProductsByStoreId", key = "#storeId")
    @Override
    public List<ProductFlat> getProductsByStoreId(int storeId) {
        return productFlatRepository.findProductsByStoreId(storeId);
    }
    
    @Cacheable(value = "getAllByProductId", key = "#productId")
    @Override
    public List<ProductFlat> getAllByProductId(int productId, int StoreId) {
        return productFlatRepository.findAllByProductIdAndStoreId(productId, productId);
    }
    
    @Cacheable({"getProductsByStoreIdForSegmentify", "directory"})
    @Override
    public List<ProductFlat> getProductsBasicDataByStoreIdAndLangugeId(int storeId, int languageId) {
        if (languageId == Global.LANGUAGE_EN) {
            return productFlatRepository.findProductsBasicDataByStoreIdEn(storeId);
        } else if (languageId == Global.LANGUAGE_AR) {
            return productFlatRepository.findProductsBasicDataByStoreIdAr(storeId);
            
        }
        return null;
    }
    
    @Override
    public List<String> getCategoriesNameByProductIdAndStoreId(int storeId, int productId, int languageId) {
        if (languageId == Global.LANGUAGE_AR) {
            return productFlatRepository.findCategoryArNameByStoreIdAndProductId(storeId, productId);
        } else if (languageId == Global.LANGUAGE_EN) {
            return productFlatRepository.findCategoryEnNameByStoreIdAndProductId(storeId, productId);
        }
        return null;
    }
    
    @Override
    public List<ProductFlat> getProductsAndCategoriesByStoreId(int storeId) {
        return productFlatRepository.findProductsAndCategoriesByStoreId(storeId);
    }
    
}
