package com.diger.notonlysqlboard.core.board.service;

import com.diger.notonlysqlboard.core.board.domain.Board;
import com.diger.notonlysqlboard.core.board.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardExplorer {

    private final MongoTemplate mongoTemplate;
    private final TestRepository testRepository;

    public List<Board> execute(Integer page, Integer size) {
        if (isNeedPaging(page, size)) {
            return findAllByNative();
            //return findAllByPage(page, size);
        }
        return findAllByNative();
    }

    private List<Board> findAllByNative() {
        return testRepository.findAll();
    }

    private List<Board> findAllByPage(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.unsorted());

        Query query = new Query()
                .with(pageable)
                .skip((long) pageable.getPageSize() * pageable.getPageNumber())
                .limit(pageable.getPageSize());

        List<Board> boards = mongoTemplate.find(query, Board.class, "board");

        return PageableExecutionUtils.getPage(
                boards,
                pageable,
                () -> mongoTemplate.count(Query.of(query).limit(-1).skip(-1), Board.class)).stream().toList();
    }

    private boolean isNeedPaging(Integer page, Integer size) {
        return page >= 0 && size >= 0;
    }
}
