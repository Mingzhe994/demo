package com.example.demo.repository;

import com.example.demo.entity.MyUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Stuart on 24/9/17.
 */
@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends MongoRepository<MyUser,String> {

    MyUser findById(String id);
    MyUser findByUsername(String name);
    MyUser findByEmail(String email);
}
