package com.kshrd.springdatajpacrud.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

/**
 * --------------------------------------------------------------------
 * Class Name: ApiResponse
 * Description: A generic class for wrapping API responses.
 * Author: Meng  Chantha
 * Date: 2024-12-27
 * Version: 1.0
 * --------------------------------------------------------------------
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private String message;
    private HttpStatus status;
    private LocalDateTime timestamp;
    private T payload;
}


/*
@Builder:It enables a fluent and readable way of creating instances of the class,
         especially for classes with many fields or optional parameters.
         Example:
         ApiResponse<String> response = ApiResponse.<String>builder()
        .message("Success")
        .status(HttpStatus.OK)
        .timestamp(LocalDateTime.now())
        .payload("Data payload")
        .build();
the necessary inner builder class to support this syntax.

without builder
ApiResponse<String> response = new ApiResponse<>(
    "Success",
    HttpStatus.OK,
    LocalDateTime.now(),
    "Data payload"
);

@JsonInclude(JsonInclude.Include.NON_NULL)
It specifies that only non-null fields should be included in the JSON representation of the object.

 */