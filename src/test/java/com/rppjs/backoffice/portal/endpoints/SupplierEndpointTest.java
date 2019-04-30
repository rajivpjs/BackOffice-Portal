package com.rppjs.backoffice.portal.endpoints;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;

import com.rppjs.backoffice.portal.dtos.AddressDTO;
import com.rppjs.backoffice.portal.dtos.ContactDTO;
import com.rppjs.backoffice.portal.dtos.SupplierRequestDTO;
import com.rppjs.backoffice.portal.dtos.SupplierResponseDTO;
import com.rppjs.backoffice.portal.service.SupplierService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

class SupplierEndpointTest {

    @Mock
    private SupplierService supplierService;

    @InjectMocks
    private SupplierEndpoint supplierEndpoint = new SupplierEndpoint();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateSupplier_expectsHttpResponse200WithSupplierResponseDTO() {
        SupplierResponseDTO responseDTO = new SupplierResponseDTO();
        responseDTO.supplierEmail = "email@gmail.com";

        when(supplierService.addSupplier(any(SupplierRequestDTO.class))).thenReturn(responseDTO);

        SupplierRequestDTO requestDTO = new SupplierRequestDTO();
        requestDTO.supplierName = "ABC";
        ContactDTO contactDTO = new ContactDTO();
        contactDTO.email = "email@gmail.com";
        requestDTO.contactDTO = contactDTO;
        requestDTO.addressDTO = new AddressDTO();

        ResponseEntity<SupplierResponseDTO> responseEntity = supplierEndpoint.createSupplier(requestDTO);
        assertNotNull(responseDTO);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertEquals("email@gmail.com", responseEntity.getBody().supplierEmail);

        verify(supplierService).addSupplier(any(SupplierRequestDTO.class));
    }

    @Test
    public void testCreateSupplier_emailMissing_expectsHttpResponse400() {
        SupplierResponseDTO responseDTO = new SupplierResponseDTO();

        SupplierRequestDTO requestDTO = new SupplierRequestDTO();
        requestDTO.supplierName = "ABC";

        ResponseEntity<SupplierResponseDTO> responseEntity = supplierEndpoint.createSupplier(requestDTO);
        assertNotNull(responseDTO);
        assertEquals(400, responseEntity.getStatusCodeValue());
        assertNull(responseEntity.getBody());

        verify(supplierService, never()).addSupplier(any(SupplierRequestDTO.class));
    }

    @Test
    public void testCreateSupplier_supplierNameMissing_expectsHttpResponse400() {
        SupplierResponseDTO responseDTO = new SupplierResponseDTO();

        SupplierRequestDTO requestDTO = new SupplierRequestDTO();

        ResponseEntity<SupplierResponseDTO> responseEntity = supplierEndpoint.createSupplier(requestDTO);
        assertNotNull(responseDTO);
        assertEquals(400, responseEntity.getStatusCodeValue());
        assertNull(responseEntity.getBody());

        verify(supplierService, never()).addSupplier(any(SupplierRequestDTO.class));
    }

    @Test
    public void testCreateSupplier_addressMissing_expectsHttpResponse400() {
        SupplierResponseDTO responseDTO = new SupplierResponseDTO();

        SupplierRequestDTO requestDTO = new SupplierRequestDTO();
        requestDTO.supplierName = "ABC";

        ResponseEntity<SupplierResponseDTO> responseEntity = supplierEndpoint.createSupplier(requestDTO);
        assertNotNull(responseDTO);
        assertEquals(400, responseEntity.getStatusCodeValue());
        assertNull(responseEntity.getBody());

        verify(supplierService, never()).addSupplier(any(SupplierRequestDTO.class));
    }
}
