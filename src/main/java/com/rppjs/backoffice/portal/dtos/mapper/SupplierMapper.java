package com.rppjs.backoffice.portal.dtos.mapper;

import com.rppjs.backoffice.portal.dtos.SupplierRequestDTO;
import com.rppjs.backoffice.portal.dtos.SupplierResponseDTO;
import com.rppjs.backoffice.portal.entities.Supplier;

public interface SupplierMapper {

    Supplier supplierRequestDTOToSupplier(SupplierRequestDTO requestDTO);

    SupplierResponseDTO supplierToSupplierResponseDTO(Supplier supplier);
}
