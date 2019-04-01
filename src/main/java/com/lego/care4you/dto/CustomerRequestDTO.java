package com.lego.care4you.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CustomerRequestDTO {

    private String firstName;
    private String lastName;
    private String address;
    private Integer phone;
    private String email;
    private String comment;
}