/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.joi.api.catalog.config;

import com.joi.api.catalog.security.APIFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Ramy
 */
@Configuration
public class configuration {

    @Bean
    public FilterRegistrationBean myFilterBean() {
        final FilterRegistrationBean filterRegBean = new FilterRegistrationBean();
        filterRegBean.setFilter(new APIFilter());
        filterRegBean.addUrlPatterns("/*");
        filterRegBean.setEnabled(Boolean.TRUE);
        filterRegBean.setName("API Filter");
        filterRegBean.setAsyncSupported(Boolean.TRUE);
        return filterRegBean;
    }
}
