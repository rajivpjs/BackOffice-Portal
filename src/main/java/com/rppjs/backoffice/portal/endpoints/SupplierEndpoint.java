package com.rppjs.backoffice.portal.endpoints;

import com.rppjs.backoffice.portal.dtos.SupplierRequestDTO;
import com.rppjs.backoffice.portal.dtos.SupplierResponseDTO;
import com.rppjs.backoffice.portal.service.SupplierService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplier")
public class SupplierEndpoint {

    @Autowired
    private SupplierService supplierService;

    @RequestMapping(value = "/generate-supplier", method = RequestMethod.POST)
    public ResponseEntity<SupplierResponseDTO> createSupplier(@RequestBody SupplierRequestDTO supplierRequestDTO) {
        if (StringUtils.isBlank(supplierRequestDTO.supplierName)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else if (supplierRequestDTO.contactDTO == null || supplierRequestDTO.addressDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        SupplierResponseDTO responseDTO = supplierService.addSupplier(supplierRequestDTO);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}
