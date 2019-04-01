package com.lego.care4you.domain;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import com.lego.care4you.domain.enums.MachineCapacity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;


@Getter
@Setter
@Document
public class Machine extends GenericDomain {

    private String name;
    private BigDecimal price;
    private String description;
    private String mark;
    private String model;
    private MachineCapacity capacity;

}
