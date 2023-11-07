package com.diger.notonlysqlboard.core.board.repository;

import com.diger.notonlysqlboard.core.board.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BoardRepository extends MongoRepository<Board, String> {

    Page<Board> findAll(Pageable pageable);
}
