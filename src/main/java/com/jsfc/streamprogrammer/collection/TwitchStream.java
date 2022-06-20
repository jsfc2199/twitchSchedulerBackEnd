package com.jsfc.streamprogrammer.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "twitchstream")
@AllArgsConstructor
@NoArgsConstructor
public class TwitchStream {
    @Id
    private String id;
    private String day;
    private String category;
    private List<VideoGame> videoGameList;
}
