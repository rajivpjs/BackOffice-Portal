package com.rppjs.backoffice.portal.dtos.mapper.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.rppjs.backoffice.portal.dtos.AddressDTO;
import com.rppjs.backoffice.portal.dtos.ContactDTO;
import com.rppjs.backoffice.portal.dtos.SupplierRequestDTO;
import com.rppjs.backoffice.portal.dtos.SupplierResponseDTO;
import com.rppjs.backoffice.portal.dtos.mapper.SupplierMapper;
import com.rppjs.backoffice.portal.entities.Supplier;
import org.junit.jupiter.api.Test;

class SupplierMapperImplTest {

    private SupplierMapper supplierMapper = new SupplierMapperImpl();

    @Test
    public void testSupplierRequestDTOToSupplier_expectsSupplierObject() {
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

        Supplier supplier = supplierMapper.supplierRequestDTOToSupplier(requestDTO);
        assertNotNull(supplier);
        assertEquals("email@gmail.com", supplier.getEmail());
    }

    @Test
    public void testSupplierToSupplierResponseDTO_expectsSupplierResponseDTO() {
        Supplier supplier = new Supplier();
        supplier.setEmail("email@gmail.com");
        SupplierResponseDTO supplierResponseDTO = supplierMapper.supplierToSupplierResponseDTO(supplier);
        assertNotNull(supplierResponseDTO);
        assertEquals("email@gmail.com", supplierResponseDTO.supplierEmail);
    }
}
