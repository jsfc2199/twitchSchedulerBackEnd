package com.jsfc.streamprogrammer.dto;

import com.jsfc.streamprogrammer.collection.Url;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoGameDto {
    private String id;
    private String name;
    private String genre;
    private Url url;
}
