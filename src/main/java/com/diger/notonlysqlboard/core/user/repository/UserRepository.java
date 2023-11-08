package com.diger.notonlysqlboard.core.user.repository;

import com.diger.notonlysqlboard.core.user.domain.LoginId;
import com.diger.notonlysqlboard.core.user.domain.Password;
import com.diger.notonlysqlboard.core.user.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    User findByLoginIdAndPassword(LoginId LoginId, Password password);
}
