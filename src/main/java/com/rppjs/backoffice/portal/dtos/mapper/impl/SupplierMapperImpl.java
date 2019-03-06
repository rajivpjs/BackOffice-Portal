package com.rppjs.backoffice.portal.dtos.mapper.impl;

import com.rppjs.backoffice.portal.dtos.SupplierRequestDTO;
import com.rppjs.backoffice.portal.dtos.SupplierResponseDTO;
import com.rppjs.backoffice.portal.dtos.mapper.SupplierMapper;
import com.rppjs.backoffice.portal.entities.Supplier;
import java.util.Date;

public class SupplierMapperImpl implements SupplierMapper {

    @Override
    public Supplier supplierRequestDTOToSupplier(SupplierRequestDTO requestDTO) {
        Supplier supplier = new Supplier(null, requestDTO.supplierName, requestDTO.addressDTO.addressDoorNumber,
        requestDTO.addressDTO.addressLine1, requestDTO.addressDTO.addressLine2, requestDTO.addressDTO.city,
        requestDTO.addressDTO.postalCode, requestDTO.addressDTO.country, requestDTO.contactDTO.contactName,
        requestDTO.contactDTO.email, requestDTO.contactDTO.phone, new Date(), null, null);

        return supplier;
    }

    @Override
    public SupplierResponseDTO supplierToSupplierResponseDTO(Supplier supplier) {
        SupplierResponseDTO supplierResponseDTO = new SupplierResponseDTO();
        supplierResponseDTO.supplierId = supplier.getSupplierId();
        return supplierResponseDTO;
    }
}
