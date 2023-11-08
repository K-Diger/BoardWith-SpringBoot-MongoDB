package com.diger.notonlysqlboard.core.board.repository;

import com.diger.notonlysqlboard.core.board.domain.Board;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends MongoRepository<Board, String> {
}
