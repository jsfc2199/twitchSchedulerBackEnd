package com.jsfc.streamprogrammer.repository;

import com.jsfc.streamprogrammer.collection.TwitchStream;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TwitchStreamRepository extends ReactiveMongoRepository<TwitchStream, String> {
}
