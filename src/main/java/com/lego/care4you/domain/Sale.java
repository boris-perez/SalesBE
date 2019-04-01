package com.lego.care4you.domain;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document
public class Sale extends GenericDomain {

    private String code;

    @DBRef
    private Machine machine;

    @DBRef
    private Customer customer;
}
