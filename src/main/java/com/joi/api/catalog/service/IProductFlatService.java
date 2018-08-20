/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.service;

import com.joi.api.catalog.entity.ProductFlat;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author Ramy
 */
public interface IProductFlatService {

    List<ProductFlat> getMobileHomePageCatalog(int storeId);

    List<ProductFlat> getProductsByCategory(int storeId, int categoryId);
    List<ProductFlat> getProductsByStoreId(int storeId);

}
