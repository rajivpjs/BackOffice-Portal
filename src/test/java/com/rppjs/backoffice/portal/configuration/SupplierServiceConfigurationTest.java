package com.rppjs.backoffice.portal.configuration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.rppjs.backoffice.portal.service.impl.SupplierServiceImpl;
import org.junit.jupiter.api.Test;

class SupplierServiceConfigurationTest {

    private SupplierServiceConfiguration supplierServiceConfiguration = new SupplierServiceConfiguration();

    @Test
    public void testSupplierService_expectsSupplierServiceImpl() {
        assertTrue(supplierServiceConfiguration.supplierService() instanceof SupplierServiceImpl);
    }
}
