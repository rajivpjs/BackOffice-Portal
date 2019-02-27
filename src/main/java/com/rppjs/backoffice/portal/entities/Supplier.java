package com.rppjs.backoffice.portal.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "suppliers")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(exclude = "supplierId")
@ToString
public class Supplier {

    @Id
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
