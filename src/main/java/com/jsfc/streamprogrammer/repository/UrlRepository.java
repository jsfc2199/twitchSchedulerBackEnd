package com.jsfc.streamprogrammer.repository;

import com.jsfc.streamprogrammer.collection.Url;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends ReactiveMongoRepository<Url, String> {
}
