package com.jsfc.streamprogrammer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoGameDto {
    private String id;
    private String name;
    private String genre;
    private URL url;
}
