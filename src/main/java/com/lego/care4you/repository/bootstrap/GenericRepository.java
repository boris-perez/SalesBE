package com.lego.care4you.repository.bootstrap;

import com.lego.care4you.domain.bootstrap.GenericDomain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface GenericRepository<T extends GenericDomain> extends MongoRepository<T, String> {

    @Query("{ 'id' : ?0 }")
    T findOne(String id);
}
