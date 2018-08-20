/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.rest;

import com.joi.api.catalog.dto.web.SegmentifyChannelDTO;
import com.joi.api.catalog.entity.ProductFlat;
import com.joi.api.catalog.repository.ProductFlatRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
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
    ProductFlatRepository productFlatRepository;

    @GetMapping("/segmentify/{storeId}/{languageId}")
    SegmentifyChannelDTO getAllProductsForSegmentify(@PathVariable("storeId") int storeId, @PathVariable("languageId") int languageId) {

        return new SegmentifyChannelDTO(productFlatRepository.findProductsByStoreId(storeId), languageId);
    }
}
