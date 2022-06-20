package com.jsfc.streamprogrammer.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "url")
@AllArgsConstructor
@NoArgsConstructor
public class Url {
    @Id
    private String id;
    private String webSiteName;
    private String webSiteUrl;
}
