$("#add-supplier-form").on('click', function(e) {
    var json = {
            supplierName : $("#supplier-name").val(),
            addressDTO {
                addressDoorNumber  : $("#supplier-door-number").val(),
                addressLine1 : $("#supplier-address-line-one").val(),
                addressLine2 : $("#supplier-address-line-two").val(),
                city : $("#supplier-address-city").val(),
                postalCode : $("#supplier-address-postalcode").val(),
                country : $("#supplier-address-country").val()
            },
            contactDTO {
                contactName : $("#supplier-contact-name").val(),
                email : $("#supplier-contact-email").val(),
                phone : $("#supplier-contact-phone").val()
            }
    };

    e.preventDefault();

    $.ajax({
           type: "POST",
           url: "/supplier/generate-supplier",
           data: JSON.stringify(json),
           dataType: "json",
           contentType : "application/json",
           success: function(data)
           {

           },
            error: function(xhr,err) {

            }
         });
});
