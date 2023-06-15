package com.example.RestApi.entity;

import org.springframework.http.HttpStatus;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class ResponseEntity<T> {
    
    @NonNull
    private HttpStatus httpStatus;

    @Nullable
    private T data;
}
