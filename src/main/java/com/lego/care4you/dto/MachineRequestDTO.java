package com.lego.care4you.dto;

import com.lego.care4you.domain.enums.MachineCapacity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class MachineRequestDTO {

    private String name;
    private BigDecimal price;
    private String description;
    private String mark;
    private String model;
    private MachineCapacity capacity;
}
