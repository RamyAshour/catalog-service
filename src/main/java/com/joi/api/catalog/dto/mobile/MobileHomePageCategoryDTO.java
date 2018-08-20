/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.dto.mobile;

import com.joi.api.catalog.entity.ProductFlat;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Ramy
 */
public class MobileHomePageCategoryDTO {

    private int id;
    private String name;
    private String description;
    private Collection<MobileCategoryProductDTO> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {

        this.id = id ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? "" : name;
    }

    public Collection<MobileCategoryProductDTO> getProducts() {
        return products;
    }

    public void setProducts(Collection<MobileCategoryProductDTO> products) {
        this.products = (products == null || products.size() == 0) ? new ArrayList<MobileCategoryProductDTO>() : products;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {

        this.description = description == null ? "" : description;
    }

    public MobileHomePageCategoryDTO() {
    }

    public MobileHomePageCategoryDTO(ProductFlat product, String languageId) {
        if (languageId == null) {
            languageId = "1";
        }
        setId(product.getCategoryId());
        if (languageId.equals("1")) {
            setName(product.getCategoryEnName());
            setDescription(product.getCategoryEnDescription());
        } else {
            setName(product.getCategoryArName());
            setDescription(product.getCategoryArDescription());
        }

        setProducts(new ArrayList<MobileCategoryProductDTO>());

    }

    @Override
    public boolean equals(Object obj) {
        return (this.id ==((MobileHomePageCategoryDTO) obj).id);
    }

}
