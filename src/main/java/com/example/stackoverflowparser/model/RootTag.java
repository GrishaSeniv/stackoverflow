package com.example.stackoverflowparser.model;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RootTag {
    private ArrayList<Tag> items;
}
