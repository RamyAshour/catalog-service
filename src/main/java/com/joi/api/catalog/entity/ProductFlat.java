/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Ramy
 */
@Entity
@Table(name = "product_flat")
public class ProductFlat {

    @Id
    private Long id;

//    Product Section
    @Column(name = "product_id")
    private int productId;
    @Column(name = "product_sku")
    private String productSku;

    @Column(name = "product_en_name")
    private String productEnName;
    @Column(name = "product_en_short_description")
    private String productEnShortDescription;
    @Column(name = "product_en_full_description")
    private String productEnFullDescription;
    @Column(name = "product_en_meta_title")
    private String productEnMetaTitle;
    @Column(name = "product_ar_name")
    private String productArName;
    @Column(name = "product_ar_short_description")
    private String productArShortDescription;
    @Column(name = "product_ar_full_description")
    private String productArFullDescription;
    @Column(name = "product_ar_meta_title")
    private String productArMetaTitle;
    @Column(name = "product_ar_luxury_short_description")
    private String productArLuxuryShortDescription;
    @Column(name = "product_ar_luxury_full_description")
    private String productArLuxuryFullDescription;
    @Column(name = "product_price")
    private float productPrice;
    @Column(name = "product_image_url")
    private String productPictureUrl;
    @Column(name = "product_display_order")
    private int productDisplayOrder;
    @Column(name = "product_showonhomepage")
    private boolean productShowOnHomePage;

    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "category_en_name")
    private String categoryEnName;
    @Column(name = "category_en_description")
    private String categoryEnDescription;
    @Column(name = "category_ar_name")
    private String categoryArName;
    @Column(name = "category_ar_description")
    private String categoryArDescription;
    @Column(name = "category_showonhomepage")
    private boolean categoryShowOnHomePage;
    @Column(name = "category_showonmobilehomepage")
    private boolean categoryShowOnMobileHomePage;
    @Column(name = "category_display_order")
    private int categoryDisplayOrder;

    @Column(name = "store_id")
    private int storeId;

    @Column(name = "currency")
    private String currency;

    @Column(name = "creation_date")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date creationDate;

    @Override
    public boolean equals(Object obj) {

        return ((ProductFlat) obj).id == this.id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductEnName() {
        return productEnName;
    }

    public void setProductEnName(String productEnName) {
        this.productEnName = productEnName;
    }

    public String getProductEnShortDescription() {
        return productEnShortDescription;
    }

    public void setProductEnShortDescription(String productEnShortDescription) {
        this.productEnShortDescription = productEnShortDescription;
    }

    public String getProductEnFullDescription() {
        return productEnFullDescription;
    }

    public void setProductEnFullDescription(String productEnFullDescription) {
        this.productEnFullDescription = productEnFullDescription;
    }

    public String getProductEnMetaTitle() {
        return productEnMetaTitle;
    }

    public void setProductEnMetaTitle(String productEnMetaTitle) {
        this.productEnMetaTitle = productEnMetaTitle;
    }

    public String getProductArName() {
        return productArName;
    }

    public void setProductArName(String productArName) {
        this.productArName = productArName;
    }

    public String getProductArShortDescription() {
        return productArShortDescription;
    }

    public void setProductArShortDescription(String productArShortDescription) {
        this.productArShortDescription = productArShortDescription;
    }

    public String getProductArFullDescription() {
        return productArFullDescription;
    }

    public void setProductArFullDescription(String productArFullDescription) {
        this.productArFullDescription = productArFullDescription;
    }

    public String getProductArMetaTitle() {
        return productArMetaTitle;
    }

    public void setProductArMetaTitle(String productArMetaTitle) {
        this.productArMetaTitle = productArMetaTitle;
    }

    public String getProductArLuxuryShortDescription() {
        return productArLuxuryShortDescription;
    }

    public void setProductArLuxuryShortDescription(String productArLuxuryShortDescription) {
        this.productArLuxuryShortDescription = productArLuxuryShortDescription;
    }

    public String getProductArLuxuryFullDescription() {
        return productArLuxuryFullDescription;
    }

    public void setProductArLuxuryFullDescription(String productArLuxuryFullDescription) {
        this.productArLuxuryFullDescription = productArLuxuryFullDescription;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductPictureUrl() {
        return productPictureUrl;
    }

    public void setProductPictureUrl(String productPictureUrl) {
        this.productPictureUrl = productPictureUrl;
    }

    public int getProductDisplayOrder() {
        return productDisplayOrder;
    }

    public void setProductDisplayOrder(int productDisplayOrder) {
        this.productDisplayOrder = productDisplayOrder;
    }

    public boolean isProductShowOnHomePage() {
        return productShowOnHomePage;
    }

    public void setProductShowOnHomePage(boolean productShowOnHomePage) {
        this.productShowOnHomePage = productShowOnHomePage;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryEnName() {
        return categoryEnName;
    }

    public void setCategoryEnName(String categoryEnName) {
        this.categoryEnName = categoryEnName;
    }

    public String getCategoryEnDescription() {
        return categoryEnDescription;
    }

    public void setCategoryEnDescription(String categoryEnDescription) {
        this.categoryEnDescription = categoryEnDescription;
    }

    public String getCategoryArName() {
        return categoryArName;
    }

    public void setCategoryArName(String categoryArName) {
        this.categoryArName = categoryArName;
    }

    public String getCategoryArDescription() {
        return categoryArDescription;
    }

    public void setCategoryArDescription(String categoryArDescription) {
        this.categoryArDescription = categoryArDescription;
    }

    public boolean isCategoryShowOnHomePage() {
        return categoryShowOnHomePage;
    }

    public void setCategoryShowOnHomePage(boolean categoryShowOnHomePage) {
        this.categoryShowOnHomePage = categoryShowOnHomePage;
    }

    public boolean isCategoryShowOnMobileHomePage() {
        return categoryShowOnMobileHomePage;
    }

    public void setCategoryShowOnMobileHomePage(boolean categoryShowOnMobileHomePage) {
        this.categoryShowOnMobileHomePage = categoryShowOnMobileHomePage;
    }

    public int getCategoryDisplayOrder() {
        return categoryDisplayOrder;
    }

    public void setCategoryDisplayOrder(int categoryDisplayOrder) {
        this.categoryDisplayOrder = categoryDisplayOrder;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
