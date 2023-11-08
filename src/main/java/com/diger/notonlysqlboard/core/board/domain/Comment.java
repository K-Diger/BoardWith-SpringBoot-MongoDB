package com.diger.notonlysqlboard.core.board.domain;

import com.diger.notonlysqlboard.core.BaseDocument;
import com.diger.notonlysqlboard.core.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@Document(collection = "comment")
public class Comment extends BaseDocument {
    private final String value;
    private final String fileLink;
    private final User writer;
}
