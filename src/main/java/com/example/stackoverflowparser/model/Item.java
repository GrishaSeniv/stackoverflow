package com.example.stackoverflowparser.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {
    private Long reputation;
    private String location;
    private String link;
    private String profile_image;
    private String display_name;
    private Long user_id;
}
