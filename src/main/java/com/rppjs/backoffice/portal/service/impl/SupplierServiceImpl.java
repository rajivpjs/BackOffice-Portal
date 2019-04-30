package com.rppjs.backoffice.portal.service.impl;

import com.rppjs.backoffice.portal.dtos.SupplierRequestDTO;
import com.rppjs.backoffice.portal.dtos.SupplierResponseDTO;
import com.rppjs.backoffice.portal.dtos.mapper.SupplierMapper;
import com.rppjs.backoffice.portal.dtos.mapper.impl.SupplierMapperImpl;
import com.rppjs.backoffice.portal.entities.Supplier;
import com.rppjs.backoffice.portal.repository.SupplierRepository;
import com.rppjs.backoffice.portal.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;

public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    private SupplierMapper mapper = new SupplierMapperImpl();

    @Override
    public SupplierResponseDTO addSupplier(SupplierRequestDTO requestDTO) {
        Supplier supplier = mapper.supplierRequestDTOToSupplier(requestDTO);
        supplierRepository.save(supplier);

        SupplierResponseDTO supplierResponseDTO = new SupplierResponseDTO();
        supplierResponseDTO.supplierEmail = supplier.getEmail();
        return supplierResponseDTO;
    }
}
