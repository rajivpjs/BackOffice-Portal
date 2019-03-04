package com.rppjs.backoffice.portal.service;

import com.rppjs.backoffice.portal.dtos.SupplierRequestDTO;
import com.rppjs.backoffice.portal.dtos.SupplierResponseDTO;

public interface SupplierService {

    SupplierResponseDTO addSupplier(SupplierRequestDTO requestDTO);
}
