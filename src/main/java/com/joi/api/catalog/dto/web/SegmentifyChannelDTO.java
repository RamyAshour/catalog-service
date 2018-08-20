/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.dto.web;

import com.joi.api.catalog.Global;
import com.joi.api.catalog.entity.ProductFlat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author ramy
 */
public class SegmentifyChannelDTO {

    private String title;
    private String link;
    private String description;
    private Collection<WebSegmentfiyProductDTO> item;

    public SegmentifyChannelDTO( List<ProductFlat> products,int languageId)  {
        item = new ArrayList<WebSegmentfiyProductDTO>();
        for(int i=0; i<products.size();i++){
            item.add(new WebSegmentfiyProductDTO(products.get(i), languageId));
        }
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

    public Collection<WebSegmentfiyProductDTO> getItem() {
        return item;
    }

    public void setItem(Collection<WebSegmentfiyProductDTO> item) {
        this.item = item;
    }

    class WebSegmentfiyProductDTO {

        int id;
        String sku;
        String title;
        String description;
        String link;
        String image_link;
        String additional_image_link;
        String availability;
        float price;
        float sale_price;
        Collection<String> google_product_category;

        public WebSegmentfiyProductDTO(ProductFlat pf, int languageId) {
            id = pf.getProductId();
            sku = pf.getProductSku();
            if (languageId ==Global.LANGUAGE_EN) {
                title = pf.getProductEnName();
                description = pf.getProductEnShortDescription();
            } else if (languageId == Global.LANGUAGE_AR) {
                title = pf.getProductArName();
                description = pf.getProductArShortDescription();
            }
//        link=pf.getProductLink();
            image_link = pf.getProductPictureUrl();

        }

    }
}
