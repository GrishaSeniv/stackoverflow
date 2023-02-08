package com.example.stackoverflowparser.service.impl;

import com.example.stackoverflowparser.dto.ItemDto;
import com.example.stackoverflowparser.model.Tag;
import com.example.stackoverflowparser.service.ConsoleOutputConverterService;
import java.util.List;

public class ConsoleOutputConverterServiceImpl implements ConsoleOutputConverterService {
    public static final String COMMA_DELIMITER = ", ";

    @Override
    public String convert(List<ItemDto> itemDtos) {
        StringBuilder builder = new StringBuilder();
        for (ItemDto item : itemDtos) {
            StringBuilder tagsToCommaDelimitedString = new StringBuilder();
            for (Tag tag : item.getTags()) {
                tagsToCommaDelimitedString.append(tag)
                        .append(COMMA_DELIMITER);
            }
            builder.append("User name: ").append(item.getDisplayName())
                    .append(System.lineSeparator())
                    .append(" Location: ").append(item.getLocation())
                    .append(System.lineSeparator())
                    .append(" Answer count: ").append(item.getTotalAnswers())
                    .append(System.lineSeparator())
                    .append(" Question count: ").append(item.getTotalQuestions())
                    .append(System.lineSeparator())
                    .append(" Tags: ").append(tagsToCommaDelimitedString.toString().trim())
                    .append(System.lineSeparator())
                    .append(" Link to profile: ").append(item.getLink())
                    .append(System.lineSeparator())
                    .append(" Link to avatar: ").append(item.getProfileImage())
                    .append(System.lineSeparator())
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
