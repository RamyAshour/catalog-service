/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.rest;

import com.joi.api.catalog.Global;
import com.joi.api.catalog.dto.web.SegmentifyChannelDTO;
import com.joi.api.catalog.entity.ProductFlat;
import com.joi.api.catalog.help.Helper;
import com.joi.api.catalog.repository.ProductFlatRepository;
import com.joi.api.catalog.service.ProductFlatService;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ramy
 */
@RestController
@RequestMapping("/product")
public class ProductRestController {

    @Autowired
    ProductFlatService productFlatService;
    @Autowired
    ProductFlatRepository flatRepository;

    @Cacheable(value = "getAllProductsForSegmentify", key = "#p0#p1")
    @GetMapping("/segmentify/{language}/{storeName}")
    SegmentifyChannelDTO getAllProductsForSegmentify( @PathVariable("language") String language,@PathVariable("storeName") String storeName) {
       
        int langId=1;
        if(language.equalsIgnoreCase("en")){
            langId=Global.LANGUAGE_EN;
        }
        if(language.equalsIgnoreCase("ar")){
            langId=Global.LANGUAGE_AR;
        }
        int storeId=Helper.getStoreIdByName(storeName);
        List<ProductFlat> result = productFlatService.getProductsBasicDataByStoreIdAndLangugeId(storeId, langId);
        return new SegmentifyChannelDTO(result, langId, productFlatService);
    }
}
