package io.spring.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.Objects;

public class ApiResponse<T> {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private final LocalDateTime timestamp = LocalDateTime.now();

    private final int status;
    private final String message;
    private final String path;
    private final T data;

    public ApiResponse(int status, String message, String path, T data) {
        this.status = status;
        this.message = Objects.requireNonNull(message, "message must not be null");
        this.path = path;
        this.data = data;
    }

    public static <T> ApiResponse<T> of(int status, String message, String path, T data) {
        return new ApiResponse<>(status, message, path, data);
    }

    public static <T> ApiResponse<T> success(int status, String message, String path, T data) {
        return of(status, message, path, data);
    }

    public static <T> ApiResponse<T> success(int status, String message, String path) {
        return of(status, message, path, null);
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public T getData() {
        return data;
    }
}
