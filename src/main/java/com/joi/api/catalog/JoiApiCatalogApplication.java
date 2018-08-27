package com.joi.api.catalog;

import static com.joi.api.catalog.Global.stores;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EnableCaching
public class JoiApiCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(JoiApiCatalogApplication.class, args);
        loadStores();
    }

    public static void loadStores() {
        stores.put("dubai", 1);
        stores.put("abu dhabi", 2);
        stores.put("riyadh", 3);
        stores.put("jeddah", 4);
        stores.put("sharjah", 5);
        stores.put("medina", 10);
        stores.put("ajman", 17);
        stores.put("al ain", 18);
        stores.put("dammam", 21);
        stores.put("khobar", 22);
        stores.put("hail", 23);
        stores.put("buraydah", 24);
        stores.put("amman", 25);
        stores.put("dhahran", 26);
        stores.put("manama", 27);
        stores.put("muscat", 28);
        stores.put("mecca", 29);

    }
}
