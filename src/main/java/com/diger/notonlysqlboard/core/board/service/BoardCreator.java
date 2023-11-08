package com.diger.notonlysqlboard.core.board.service;

import com.diger.notonlysqlboard.core.board.domain.Board;
import com.diger.notonlysqlboard.core.board.domain.StaticContent;
import com.diger.notonlysqlboard.core.board.domain.TextContent;
import com.diger.notonlysqlboard.core.board.domain.Title;
import com.diger.notonlysqlboard.core.board.repository.TestRepository;
import com.diger.notonlysqlboard.core.user.domain.User;
import com.diger.notonlysqlboard.util.aws.s3.S3Uploader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class BoardCreator {

    private final TestRepository testRepository;
    private final S3Uploader s3Uploader;

    public void execute(
            String title,
            String content,
            MultipartFile[] multipartFiles,
            User writer
    ) {
        writer.getAuthority().isUserCanWrite();
        testRepository.save(
                new Board(
                        new Title(title),
                        new TextContent(content),
                        new StaticContent(Arrays.asList(s3Uploader.execute(multipartFiles))),
                        writer,
                        new ArrayList<>()
                )
        );
    }
}
