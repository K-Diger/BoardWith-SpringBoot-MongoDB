package com.diger.notonlysqlboard.core.board.domain;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Document(collection = "staticContent")
public class StaticContent {
    private final List<String> links = new ArrayList<>();

    public StaticContent(List<String> value) {
        links.addAll(value);
    }

    public void validate(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("Content Link Must Not Be Blank");
        }
    }
}
