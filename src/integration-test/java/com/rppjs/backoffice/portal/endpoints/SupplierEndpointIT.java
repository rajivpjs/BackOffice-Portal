package com.rppjs.backoffice.portal.endpoints;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.rppjs.backoffice.portal.configuration.H2Configuration;
import com.rppjs.backoffice.portal.configuration.MyConfig;
import com.rppjs.backoffice.portal.configuration.SupplierServiceConfiguration;
import com.rppjs.backoffice.portal.dtos.AddressDTO;
import com.rppjs.backoffice.portal.dtos.ContactDTO;
import com.rppjs.backoffice.portal.dtos.SupplierRequestDTO;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {H2Configuration.class,
                SupplierServiceConfiguration.class, SupplierEndpoint.class,
                MyConfig.class})
@Transactional
@TestPropertySource("classpath:application-test.properties")
public class SupplierEndpointIT {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateSupplier_expectsHttpResponse200WithValidJSONBody() throws JSONException {
        String expected = "{supplierEmail:email@gmail.com}";

        SupplierRequestDTO requestDTO = new SupplierRequestDTO();
        requestDTO.supplierName = "XYZ";

        ContactDTO contactDTO = new ContactDTO();
        contactDTO.email = "email@gmail.com";

        requestDTO.contactDTO = contactDTO;
        requestDTO.addressDTO = new AddressDTO();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity entity = new HttpEntity(requestDTO, headers);

        ResponseEntity<String> response = restTemplate.postForEntity("/supplier/generate-supplier", entity, String.class);
        assertEquals(200, response.getStatusCodeValue());
        JSONAssert.assertEquals(expected, response.getBody(), true);

    }
}
