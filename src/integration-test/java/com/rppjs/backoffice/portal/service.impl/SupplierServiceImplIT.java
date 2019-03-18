package com.rppjs.backoffice.portal.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.rppjs.backoffice.portal.configuration.H2Configuration;
import com.rppjs.backoffice.portal.configuration.MyConfig;
import com.rppjs.backoffice.portal.dtos.AddressDTO;
import com.rppjs.backoffice.portal.dtos.ContactDTO;
import com.rppjs.backoffice.portal.dtos.SupplierRequestDTO;
import com.rppjs.backoffice.portal.dtos.SupplierResponseDTO;
import com.rppjs.backoffice.portal.repository.SupplierRepository;
import com.rppjs.backoffice.portal.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {H2Configuration.class,
        SupplierServiceImpl.class, MyConfig.class})
@Transactional
@TestPropertySource("classpath:application-test.properties")
public class SupplierServiceImplIT {

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private SupplierService supplierService;

    @Test
    public void testAddSupplier_expectsSupplierResponseDTOAndSavedToDatabase() {
        SupplierRequestDTO supplierRequestDTO = new SupplierRequestDTO();
        supplierRequestDTO.supplierName = "XYZ";
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.email = "email@gmail.com";

        supplierRequestDTO.addressDTO = new AddressDTO();
        supplierRequestDTO.contactDTO = contactDTO;

        SupplierResponseDTO responseDTO = supplierService.addSupplier(supplierRequestDTO);
        assertNotNull(responseDTO);
        assertEquals("email@gmail.com", responseDTO.supplierEmail);

        assertEquals(1, supplierRepository.findAll().size());
    }
}
