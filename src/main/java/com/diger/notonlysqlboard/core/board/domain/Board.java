package com.diger.notonlysqlboard.core.board.domain;

import com.diger.notonlysqlboard.core.BaseDocument;
import com.diger.notonlysqlboard.core.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@AllArgsConstructor
@Document("board")
public class Board extends BaseDocument {

    private final Title title;

    private final TextContent textContent;

    private final StaticContent staticContent;

    private final User writer;

    private final List<Comment> comments; // List<>()로 할수도있음
}
