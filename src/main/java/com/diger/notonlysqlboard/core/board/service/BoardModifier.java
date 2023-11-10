package com.diger.notonlysqlboard.core.board.service;

import com.diger.notonlysqlboard.core.board.domain.Board;
import com.diger.notonlysqlboard.core.board.domain.StaticContent;
import com.diger.notonlysqlboard.core.board.domain.TextContent;
import com.diger.notonlysqlboard.core.board.domain.Title;
import com.diger.notonlysqlboard.core.board.repository.BoardRepository;
import com.diger.notonlysqlboard.util.aws.s3.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardModifier {

    private final BoardRepository boardRepository;
    private final S3Uploader s3Uploader;

    public void execute(
            String identifier,
            String titleValue,
            String contentValue,
            MultipartFile[] file
    ) {
        Optional<Board> before = boardRepository.findById(identifier);
        Board after = new Board(
                new Title(titleValue),
                new TextContent(contentValue),
                new StaticContent(List.of(s3Uploader.execute(file))),
                before.get().getWriter(),
                before.get().getComments()
        );

        boardRepository.save(after);
        boardRepository.delete(before.get());
    }
}
