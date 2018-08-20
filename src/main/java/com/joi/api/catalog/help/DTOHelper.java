/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.help;

import com.joi.api.catalog.dto.mobile.MobileHomePageCategoryDTO;
import com.joi.api.catalog.dto.mobile.MobileCategoryProductDTO;
import com.joi.api.catalog.dto.web.SegmentifyChannelDTO;
import com.joi.api.catalog.entity.ProductFlat;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Ramy
 */
public class DTOHelper {

    public static Collection<MobileHomePageCategoryDTO> toMobileHomePageCategoryDTOList(Collection<ProductFlat> productFlatList, String languageId, int productsLimit) {

        Collection<MobileHomePageCategoryDTO> categories = new ArrayList<MobileHomePageCategoryDTO>();
       
        
        for (ProductFlat p : productFlatList) {

            MobileHomePageCategoryDTO c = new MobileHomePageCategoryDTO(p, languageId);

            if (!categories.contains(c)) {
                if (c.getProducts().size() < productsLimit|| productsLimit==0) {
                    c.getProducts().add(new MobileCategoryProductDTO(p, languageId));
                }
                categories.add(c);

            } else {
                for (MobileHomePageCategoryDTO cat : categories) {
                    if (c.equals(cat)) {
                        if (cat.getProducts().size() < productsLimit|| productsLimit==0) {
                            cat.getProducts().add(new MobileCategoryProductDTO(p, languageId));   
                        }
                    }
                }
            }

        }
        return categories;
    }

     public static Collection<MobileHomePageCategoryDTO> toMobileCategoryProductDTOList(Collection<ProductFlat> productFlatList, String languageId, int productsLimit) {

        Collection<MobileHomePageCategoryDTO> categories = new ArrayList<MobileHomePageCategoryDTO>();
       
        
        for (ProductFlat p : productFlatList) {

            MobileHomePageCategoryDTO c = new MobileHomePageCategoryDTO(p, languageId);

            if (!categories.contains(c)) {
                if (c.getProducts().size() < productsLimit|| productsLimit==0) {
                    c.getProducts().add(new MobileCategoryProductDTO(p, languageId));
                }
                categories.add(c);

            } else {
                for (MobileHomePageCategoryDTO cat : categories) {
                    if (c.equals(cat)) {
                        if (cat.getProducts().size() < productsLimit|| productsLimit==0) {
                            cat.getProducts().add(new MobileCategoryProductDTO(p, languageId));   
                        }
                    }
                }
            }

        }
        return categories;
    }

    
}
