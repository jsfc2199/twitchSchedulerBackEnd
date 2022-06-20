package com.jsfc.streamprogrammer.repository;

import com.jsfc.streamprogrammer.collection.VideoGame;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoGameRepository extends ReactiveMongoRepository<VideoGame, String> {
}
