package com.organizeu.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomResponse<T> {
    private boolean status;
    private String message;
    private T data;
}
