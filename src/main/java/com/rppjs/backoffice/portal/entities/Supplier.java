package com.rppjs.backoffice.portal.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Table(name = "suppliers")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "supplierEmail")
@ToString
public class Supplier {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    private String supplierId;
    @Column
    private String name;
    @Column
    private String addressNumber;
    @Column
    private String addressLine1;
    @Column
    private String addressLine2;
    @Column
    private String city;
    @Column
    private String postalCode;
    @Column
    private String country;
    @Column
    private String contactName;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private Date creationDate;
    @Column
    private String lastUpdatedBy;
    @Column
    private Date lastModified;
}
