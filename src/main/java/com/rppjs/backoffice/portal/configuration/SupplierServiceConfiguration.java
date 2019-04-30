package com.rppjs.backoffice.portal.configuration;

import com.rppjs.backoffice.portal.service.SupplierService;
import com.rppjs.backoffice.portal.service.impl.SupplierServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SupplierServiceConfiguration {

    @Bean
    public SupplierService supplierService() {
        return new SupplierServiceImpl();
    }
}
