package com.lego.care4you.domain.bootstrap;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Id;
import javax.persistence.Version;
import java.time.Instant;

@Getter
@Setter
public class GenericDomain {
    @Id
    private String id;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedBy
    private String lastModifiedUser;

    @LastModifiedDate
    private Instant lastModifiedDate;

    // DB version
    @Version
    private long version;
}
