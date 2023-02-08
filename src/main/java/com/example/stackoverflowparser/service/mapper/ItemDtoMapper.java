package com.example.stackoverflowparser.service.mapper;

import com.example.stackoverflowparser.dto.ItemDto;
import com.example.stackoverflowparser.model.Item;
import com.example.stackoverflowparser.model.Tag;
import com.example.stackoverflowparser.util.FilterPredicateUtil;
import com.example.stackoverflowparser.util.RetrofitUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ItemDtoMapper {
    private final RetrofitUtil retrofitUtil;

    public ItemDtoMapper(RetrofitUtil retrofitUtil) {
        this.retrofitUtil = retrofitUtil;
    }

    public ItemDto toDto(Item item) {
        Long totalAnswers = retrofitUtil.getTotalAnswers(item.getUser_id())
                .getTotal();
        Long totalQuestions = retrofitUtil.getTotalQuestions(item.getUser_id())
                .getTotal();
        ItemDto itemDto = new ItemDto();
        itemDto.setReputation(item.getReputation());
        itemDto.setLocation(item.getLocation());
        itemDto.setLink(item.getLink());
        itemDto.setProfileImage(item.getProfile_image());
        itemDto.setDisplayName(item.getDisplay_name());
        itemDto.setTotalAnswers(totalAnswers);
        itemDto.setTotalQuestions(totalQuestions);
        List<Tag> tags = getTags(item.getUser_id());
        if (!tags.isEmpty()) {
            itemDto.setTags(tags);
        }
        return itemDto;
    }

    private List<Tag> getTags(Long id) {
        List<Tag> tags = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException("Couldn't get tags. " + e);
            }
            tags.addAll(new ArrayList<>(retrofitUtil.getTags(id, i)
                    .getItems()));
        }
        long foundedTagsCount = tags.stream()
                .filter(FilterPredicateUtil.tagFilter)
                .count();
        return foundedTagsCount > 0 ? tags : Collections.emptyList();
    }
}
