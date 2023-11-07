package com.diger.notonlysqlboard.core.board.domain;

import com.diger.notonlysqlboard.core.BaseDocument;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@Builder
@Document("board")
public class Board extends BaseDocument {

    private Title title;
    private TextContent textContent;
    // private StaticContent staticContent;
    private String writer;
}
