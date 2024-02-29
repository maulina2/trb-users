package ru.hits.trbcore.trbusers.exception;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiError {

    private List<String> messages;

    public ApiError(String message) {
        this.messages = new ArrayList<>();
        this.messages.add(message);
    }
}