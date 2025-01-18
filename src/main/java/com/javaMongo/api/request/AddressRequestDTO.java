package com.javaMongo.api.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class AddressRequestDTO{
    private String street;
    private String number;
    private String city;
    private String zipCode;
    private String complement;
    private String locality;
}
