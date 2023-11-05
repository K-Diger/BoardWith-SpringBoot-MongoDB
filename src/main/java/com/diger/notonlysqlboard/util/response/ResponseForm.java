package com.diger.notonlysqlboard.util.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResponseForm<T> {

    private Integer status;
    private T data;

    public static <T> ResponseForm<T> success(
            HttpStatus httpStatus
    ) {
        return new ResponseForm<>(
                httpStatus.value(),
                null
        );
    }

    public static <T> ResponseForm<T> success(
            HttpStatus httpStatus,
            T data
    ) {
        return new ResponseForm<T>(
                httpStatus.value(),
                data
        );
    }
}
