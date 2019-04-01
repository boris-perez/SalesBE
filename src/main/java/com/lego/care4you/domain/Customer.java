package com.lego.care4you.domain;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document
public class Customer extends GenericDomain {

    private String firstName;
    private String lastName;
    private String address;
    private Integer phone;
    private String email;
    private String comment;
}
