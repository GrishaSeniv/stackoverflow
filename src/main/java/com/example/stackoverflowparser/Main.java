package com.example.stackoverflowparser;

import com.example.stackoverflowparser.dto.ItemDto;
import com.example.stackoverflowparser.service.ConsoleOutputConverterService;
import com.example.stackoverflowparser.service.ParserService;
import com.example.stackoverflowparser.service.impl.ConsoleOutputConverterServiceImpl;
import com.example.stackoverflowparser.service.impl.RetrofitParserServiceImpl;
import com.example.stackoverflowparser.service.mapper.ItemDtoMapper;
import com.example.stackoverflowparser.util.RetrofitUtil;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RetrofitUtil retrofitUtil = new RetrofitUtil();
        ItemDtoMapper itemDtoMapper = new ItemDtoMapper(retrofitUtil);
        ParserService parserService = new RetrofitParserServiceImpl(retrofitUtil, itemDtoMapper);
        System.out.println("Parsing...");
        List<ItemDto> itemDtos = parserService.parse();
        ConsoleOutputConverterService converterService = new ConsoleOutputConverterServiceImpl();
        System.out.println(converterService.convert(itemDtos));
        System.out.println("Finish");
    }
}
