package com.jsfc.streamprogrammer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlDto {
    private String id;
    private String webSiteName;
    private String webSiteUrl;
}
