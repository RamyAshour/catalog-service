/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.rest;

import com.joi.api.catalog.dto.mobile.MobileHomePageCategoryDTO;
import com.joi.api.catalog.help.DTOHelper;
import com.joi.api.catalog.service.IProductFlatService;
import java.util.Collection;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ramy
 */
@RestController
@RequestMapping("/category")
public class CategoryRestController {

    @Autowired
    IProductFlatService productFlatService;

    @GetMapping("/mobile/homepage")
    HashMap<String, Collection<MobileHomePageCategoryDTO>> getMobileHomePageCategoryByStoreId(@RequestHeader HttpHeaders headers) {

        String languageId;
        int storeId;
        HashMap<String, Collection<MobileHomePageCategoryDTO>> returnMap = new HashMap<>();
        if (headers.get("LanguageId") == null) {
            languageId = "1";

        } else {
            languageId = headers.get("LanguageId").get(0);

        }
        if (headers.get("StoreId") == null) {

            storeId = 1;
        } else {

            storeId = Integer.parseInt(headers.get("StoreId").get(0));
        }

        returnMap.put("categories", DTOHelper.toMobileHomePageCategoryDTOList(productFlatService.getMobileHomePageCatalog(storeId), languageId, 5));
        return returnMap;
    }

    @GetMapping("/mobile/{id}/products")
    HashMap<String, Collection<MobileHomePageCategoryDTO>> getMobileCategoryProducts(@PathVariable("id") int categoryId, @RequestHeader HttpHeaders headers) {

        if (categoryId <= 0) {
            return null;
        }
        String languageId;
        int storeId;

        HashMap<String, Collection<MobileHomePageCategoryDTO>> returnMap = new HashMap<>();

        if (headers.get("LanguageId") == null) {
            languageId = "1";

        } else {
            languageId = headers.get("LanguageId").get(0);

        }
        if (headers.get("StoreId") == null) {

            storeId = 1;
        } else {

            storeId = Integer.parseInt(headers.get("StoreId").get(0));
        }
        returnMap.put("categories",
                DTOHelper.toMobileCategoryProductDTOList(
                        productFlatService.getProductsByCategory(storeId, categoryId), languageId, 0));
        return returnMap;
    }

}
