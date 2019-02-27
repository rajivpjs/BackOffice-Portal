create table suppliers (
  supplierId varchar(255) PRIMARY KEY,
  name varchar(50) NOT NULL,
  addressNumber varchar(10) NOT NULL,
  addressLine1 varchar(50) NOT NULL,
  addressLine2 varchar(50),
  city varchar(50) NOT NULL,
  postalCode varchar(50) NOT NULL,
  country varchar(50) NOT NULL,
  contactName varchar(50),
  email varchar(50),
  phone varchar(50) NOT NULL,
  creationDate timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  lastUpdatedBy varchar(50),
  lastModified timestamp
);
