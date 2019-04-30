package com.rppjs.backoffice.portal.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import com.rppjs.backoffice.portal.dtos.AddressDTO;
import com.rppjs.backoffice.portal.dtos.ContactDTO;
import com.rppjs.backoffice.portal.dtos.SupplierRequestDTO;
import com.rppjs.backoffice.portal.dtos.SupplierResponseDTO;
import com.rppjs.backoffice.portal.entities.Supplier;
import com.rppjs.backoffice.portal.repository.SupplierRepository;
import com.rppjs.backoffice.portal.service.SupplierService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SupplierServiceImplTest {

    @Mock
    private SupplierRepository mockSupplierRepository;

    @InjectMocks
    private SupplierService supplierService = new SupplierServiceImpl();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddSupplier_expectsSavedSupplierEmail() {
        when(mockSupplierRepository.save(anyObject())).thenReturn(anyObject());

        SupplierRequestDTO requestDTO = new SupplierRequestDTO();
        requestDTO.supplierName = "XYZ";

        AddressDTO address = new AddressDTO();
        address.addressDoorNumber = "120";
        address.addressLine1 = "line 1";
        address.addressLine2 = "line 2";
        address.city = "London";
        address.postalCode = "TW1 1RD";
        address.country = "United Kingdom";

        ContactDTO contact = new ContactDTO();
        contact.contactName = "name";
        contact.email = "email@gmail.com";
        contact.phone = "phone";

        requestDTO.addressDTO = address;
        requestDTO.contactDTO = contact;

        SupplierResponseDTO supplierResponseDTO = supplierService.addSupplier(requestDTO);
        assertNotNull(supplierResponseDTO);
        assertEquals("email@gmail.com", supplierResponseDTO.supplierEmail);

        verify(mockSupplierRepository).save(anyObject());
    }
}
