package com.stackroute.muzixservice.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Image {

    /*
     * This class should have following fields
     * (imageId,imageUrl,imageSpec,
     *  Out of these fields, the field
     * imageId should be annotated with @Id. This class should also contain the
     * getters and setters for the fields along with the no-arg , parameterized
     * constructor and toString method.
     */
   @Id
    private int imageId;
    private String imageUrl,imageSpec;

    public Image() {
    }

    public Image(int imageId, String imageUrl, String imageSpec) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
        this.imageSpec = imageSpec;
    }
}
