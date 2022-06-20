package com.jsfc.streamprogrammer.dto;

import com.jsfc.streamprogrammer.collection.VideoGame;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TwitchStreamDto {
    private String id;
    private String day;
    private String category;
    private List<VideoGame> videoGameList;
}
