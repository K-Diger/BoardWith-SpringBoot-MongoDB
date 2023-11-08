package com.diger.notonlysqlboard.core.user.domain;

import com.diger.notonlysqlboard.core.BaseDocument;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@Document("user")
public class User extends BaseDocument {

    private final LoginId loginId;

    private final Password password;

    private Authority authority;

    public void updateAuthority(Authority newAuthority) {
        this.authority = newAuthority;
    }
}
