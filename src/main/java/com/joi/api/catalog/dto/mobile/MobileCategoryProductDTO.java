/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.dto.mobile;
import com.joi.api.catalog.Global;
import com.joi.api.catalog.entity.ProductFlat;

/**
 *
 * @author Ramy
 */
public class MobileCategoryProductDTO {
    private int id;
    private String name;
    private float price;
    private String currency;
    private String imageUrl;
   
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id =id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name==null?"":name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency==null?"":currency;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl==null?"":imageUrl;
    }

    
    public MobileCategoryProductDTO() {
    }
   
     public MobileCategoryProductDTO(ProductFlat product, String languageId) {
    
        setId(product.getProductId());
        setCurrency(product.getCurrency());
        setImageUrl(product.getProductPictureUrl());
        
        setPrice(product.getProductPrice());
        
        if(languageId.equals(Global.LANGUAGE_EN)){
            setName(product.getProductEnName());
        }else{
            setName(product.getProductArName());
        }
        
        
    }  

   
    
    
    
}
