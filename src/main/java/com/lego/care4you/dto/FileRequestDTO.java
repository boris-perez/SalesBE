package com.lego.care4you.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FileRequestDTO {

    private String referenceId;

    public FileRequestDTO(String referenceId) {
        this.referenceId = referenceId;
    }
}
