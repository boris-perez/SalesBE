package com.lego.care4you.domain;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@Document
public class File extends GenericDomain {

    private Binary file;
    private String referenceId;
}
