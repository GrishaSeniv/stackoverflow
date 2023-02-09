package com.example.stackoverflowparser.dto;

import com.example.stackoverflowparser.model.Tag;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private Long reputation;
    private String location;
    private String link;
    private String profileImage;
    private String displayName;
    private Long totalAnswers;
    private Long totalQuestions;
    private List<Tag> tags;
}
