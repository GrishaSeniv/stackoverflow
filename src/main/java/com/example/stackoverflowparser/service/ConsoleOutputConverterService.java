package com.example.stackoverflowparser.service;

import com.example.stackoverflowparser.dto.ItemDto;
import java.util.List;

public interface ConsoleOutputConverterService {
    String convert(List<ItemDto> itemDtos);
}
