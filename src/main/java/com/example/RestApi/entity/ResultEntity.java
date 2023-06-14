package com.example.RestApi.entity;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultEntity {
    private HttpStatus httpStatus;
}
