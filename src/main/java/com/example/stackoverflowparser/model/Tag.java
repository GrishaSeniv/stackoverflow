package com.example.stackoverflowparser.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tag {
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
