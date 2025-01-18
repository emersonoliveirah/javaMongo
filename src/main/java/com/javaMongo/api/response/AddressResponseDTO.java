package com.javaMongo.api.response;

public record AddressResponseDTO(String street,
                                 String number,
                                 String city,
                                 String state,
                                 String country,
                                 String zipCode,
                                 String complement,
                                 String locality) {
}
