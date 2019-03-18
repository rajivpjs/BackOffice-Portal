package com.rppjs.backoffice.portal.endpoints;

import com.rppjs.backoffice.portal.configuration.H2Configuration;
import com.rppjs.backoffice.portal.configuration.MyConfig;
import com.rppjs.backoffice.portal.configuration.SupplierServiceConfiguration;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
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
}
