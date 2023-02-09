package com.example.stackoverflowparser.model;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RootItem {
    private ArrayList<Item> items;
    private boolean has_more;
}
