package com.example.stackoverflowparser.service.impl;

import com.example.stackoverflowparser.dto.ItemDto;
import com.example.stackoverflowparser.service.ParserService;
import com.example.stackoverflowparser.service.mapper.ItemDtoMapper;
import com.example.stackoverflowparser.util.FilterPredicateUtil;
import com.example.stackoverflowparser.util.RetrofitUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RetrofitParserServiceImpl implements ParserService {
    private final RetrofitUtil retrofitUtil;
    private final ItemDtoMapper mapper;

    public RetrofitParserServiceImpl(RetrofitUtil retrofitUtil, ItemDtoMapper mapper) {
        this.retrofitUtil = retrofitUtil;
        this.mapper = mapper;
    }

    @Override
    public List<ItemDto> parse() {
        List<ItemDto> itemDtos = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException("Couldn't get items. " + e);
            }
            itemDtos.addAll(retrofitUtil.getRoots(i)
                    .getItems()
                    .stream()
                    .filter(FilterPredicateUtil.itemFilter)
                    .map(mapper::toDto)
                    .filter(itemDto -> itemDto.getTotalAnswers() > 1)
                    .collect(Collectors.toList()));
        }
        return itemDtos;
    }
}
