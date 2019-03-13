package com.rppjs.backoffice.portal.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import java.util.Date;

class SupplierTest {

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Supplier.class).verify();;
    }

    @Test
    public void testToString_expectsValidToStringFormat() {
        Date creationDate = new Date();
        Supplier supplier = new Supplier("id", "Supplier", "1", "Street", null, "London", "TW4 179", "United Kingdom",
                "contactName", "email", "123", creationDate, null, null);

        String expected = "Supplier(supplierEmail=id, name=Supplier, addressNumber=1, addressLine1=Street, addressLine2=null, " +
                "city=London, postalCode=TW4 179, country=United Kingdom, contactName=contactName, email=email," +
                " phone=123, creationDate=" + creationDate + ", lastUpdatedBy=null, lastModified=null)";

        assertEquals(expected, supplier.toString());
    }
}
