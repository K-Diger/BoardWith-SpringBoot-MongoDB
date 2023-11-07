package com.diger.notonlysqlboard.core.board.domain;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "title")
public class Title {
    private final String value;

    public Title(String value) {
        validate(value);
        this.value = value;
    }

    public void validate(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("Title Must Not Be Blank");
        }
    }
}
