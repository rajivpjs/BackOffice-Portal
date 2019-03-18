package com.rppjs.backoffice.portal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.rppjs.backoffice.portal.configuration.H2Configuration;
import com.rppjs.backoffice.portal.configuration.MyConfig;
import com.rppjs.backoffice.portal.entities.Supplier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {H2Configuration.class, MyConfig.class})
@Transactional
@TestPropertySource("classpath:application-test.properties")
public class SupplierRepositoryIT {

    @Autowired
    private SupplierRepository supplierRepository;

    @Test
    public void testFindAll_returnsTwoSavedSuppliers() {
        supplierRepository.save(new Supplier());
        supplierRepository.save(new Supplier());
        assertEquals(2, supplierRepository.findAll().size());
    }
}
