package com.jsfc.streamprogrammer.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "videogame")
@AllArgsConstructor
@NoArgsConstructor
public class VideoGame {
    @Id
    private String id;
    private String name;
    private String genre;
    private Url url;
}
