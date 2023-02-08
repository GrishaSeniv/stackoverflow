package com.example.stackoverflowparser.util;

import com.example.stackoverflowparser.model.Item;
import com.example.stackoverflowparser.model.Tag;
import java.util.function.Predicate;

public class FilterPredicateUtil {
    public static final Predicate<Tag> tagFilter = new Predicate<Tag>() {
        @Override
        public boolean test(Tag tag) {
            String tagName = tag.getName();
            return tagName.contains("java")
                    || tagName.contains(".net")
                    || tagName.contains("docker")
                    || tagName.contains("C#");
        }
    };

    public static final Predicate<Item> itemFilter = new Predicate<Item>() {
        @Override
        public boolean test(Item item) {
            return (item.getLocation() != null && (item.getLocation().contains("Romania")
                    || item.getLocation().contains("Moldova")))
                    && item.getReputation() >= 223;
        }
    };
}
