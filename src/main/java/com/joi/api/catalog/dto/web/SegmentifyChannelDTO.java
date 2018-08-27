/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.dto.web;

import com.joi.api.catalog.Global;
import com.joi.api.catalog.entity.ProductFlat;
import com.joi.api.catalog.help.Helper;
import com.joi.api.catalog.service.IProductFlatService;
import com.joi.api.catalog.service.ProductFlatService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ramy
 */
public class SegmentifyChannelDTO {

    private String title;
    private String link;
    private String description;
    private List<WebSegmentfiyProductDTO> item;

    public SegmentifyChannelDTO(List<ProductFlat> products, int languageId, IProductFlatService productFlatService) {
        item = new ArrayList<WebSegmentfiyProductDTO>();
        for (int i = 0; i < products.size(); i++) {
            ProductFlat p = (ProductFlat) products.get(i);
            if (!productExist(p)) {
                item.add(new WebSegmentfiyProductDTO(p, languageId, productFlatService));
            }
        }

    }

    boolean productExist(ProductFlat p) {

        for (int i = 0; i < item.size(); i++) {
            if (item.get(i).id == p.getProductId()) {
                return true;
            }
        }
        return false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<WebSegmentfiyProductDTO> getItem() {
        return item;
    }

    public void setItem(List<WebSegmentfiyProductDTO> item) {
        this.item = item;
    }

    class WebSegmentfiyProductDTO {

        public int id;
        public String sku;
        public String title;
        public String description;
        public String link;
        public String image_link;
        public String additional_image_link;
        public String availability;
        public float price;
        public float sale_price;
        public List<String> google_product_category;

        public WebSegmentfiyProductDTO(ProductFlat pf, int languageId, IProductFlatService productFlatService) {
            id = pf.getProductId();
            sku = pf.getProductSku();
            if (languageId == Global.LANGUAGE_EN) {
                title = pf.getProductEnName();
                description = pf.getProductEnShortDescription();
                link = "https://www.joigifts.com/en/" + Helper.getStoreNameById(pf.getStoreId()) + "/" + pf.getProductSlug();
            } else if (languageId == Global.LANGUAGE_AR) {
                title = pf.getProductArName();
                description = pf.getProductArShortDescription();
                link = "https://www.joigifts.com/ar/" + Helper.getStoreNameById(pf.getStoreId()) + "/" + pf.getProductSlug();

            }
            google_product_category = getCategories(languageId, productFlatService.getProductsAndCategoriesByStoreId(pf.getStoreId()));
//            google_product_category = productFlatService.getCategoriesNameByProductIdAndStoreId(pf.getProductId(), pf.getStoreId(), languageId);

            image_link = pf.getProductPictureUrl();

        }

        List<String> getCategories(int languageId, List<ProductFlat> products) {
            List<String> categories = new ArrayList<String>();
            for (int i = 0; i < products.size(); i++) {

                if (products.get(i).getProductId() == this.id) {
                    if (languageId == Global.LANGUAGE_EN) {
                        categories.add(products.get(i).getCategoryEnName());
                    } else if (languageId == Global.LANGUAGE_AR) {
                        categories.add(products.get(i).getCategoryArName());
                    }
                }
            }
            return categories;
        }
    }
}
