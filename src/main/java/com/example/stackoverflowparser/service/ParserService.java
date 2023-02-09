package com.example.stackoverflowparser.service;

import com.example.stackoverflowparser.dto.ItemDto;
import java.util.List;

public interface ParserService {
    List<ItemDto> parse();
}
