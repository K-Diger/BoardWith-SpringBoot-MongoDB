package com.diger.notonlysqlboard.core.board.domain;

import lombok.Getter;

@Getter
public class TextContent {
    private final String value;

    public TextContent(String value) {
        validate(value);
        this.value = value;
    }

    public void validate(String value) {
        if (value.isBlank()) {
            throw new IllegalArgumentException("Content Must Not Be Blank");
        }
    }
}
